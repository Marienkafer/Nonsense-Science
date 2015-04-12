/*state_main.js*/

var StateMain = {
    preload: function () {
        game.load.image("imgPaddle", "img/paddle.png");
        game.load.image("imgBrickGreen", "img/brick_green.png");
        game.load.image("imgBrickPurple", "img/brick_purple.png");
        game.load.image("imgBrickYellow", "img/brick_yellow.png");
        game.load.image("imgBrickRed", "img/brick_red.png");
        game.load.image("imgBall", "img/ball.png");
        game.load.image("imgBgBlue", "img/bg_blue.png");
    },
    
    create: function() {
        
        this.lives = 3;
        this.score = 0;
        
        game.physics.startSystem(Phaser.Physics.ARCADE); // Inicia el motor de fisica
        game.physics.arcade.checkCollision.down = false; // No colisiona con la parte de abajo edl mundo
        
        this.numCol = 10;
        this.numRow = 4;
        this.prevX = game.input.x;
        var w = game.world.width;
        var h = game.world.height;
            
        this.bg = game.add.tileSprite(0,0,w,h, "imgBgBlue"); // Crea copias de una iamgen pequeña y la multiplica
        this.paddle = game.add.sprite(0,0,"imgPaddle");
        
        this.paddle.anchor.set(0.5, 1); // El porcentaje por altura y anchura en este caso toma el 50% de la anchura del 100% de la altura
        this.paddleHalf = this.paddle.width / 2;
        game.physics.enable(this.paddle);
        this.paddle.enableBody = true;
        this.paddle.body.bounce.set(1); // rebote con la raqueta
        this.paddle.body.immovable = true; // No queremos que se mueva ya que nosotros movemos la raqueta
        
        // Velocidad del paddle por segundos - pixels
        this.paddleSpeed = 300; /// Input por teclado
        var imgList = [ // crea una lista de los distintos cubos
            "imgBrickGreen",
            "imgBrickPurple",
            "imgBrickYellow",
            "imgBrickRed", 
        ];
        // Se crea la linea de arreglo
        this.brickList = game.add.group(); // Es un grupo vacio, es decir una especie de arreglo
        this.brickList.enableBody = true;
        this.brickList.physicsBodyType = Phaser.Physics.ARCADE;
        
        //Se declara el ciclo para llenar la linea o arreglo con la imagen
        var i, j;
        for(j = 0; j < this.numRow; j++){
            var img = imgList[j]; // se mueve por las posiciones de la lista de bloques
            for(i = 0; i< this.numCol; i++)
            { // Buscar como llenarlo por posiciones random
                var brick = this.brickList.create(0,0,img); // va llenando imgList[r]
               // var r = Math.floor(Math.random() * imgList.length);
                // math.floor para los reales
                brick.x = i * brick.width;
                brick.y = j * brick.height;
                brick.body.bounce.set(1);
                brick.body.immovable = true;
            }
        }
        
        this.ballSpeed = 300; //Velocidad de disparo de la bola
        this.ballVelX = 200;
        this.ballVelY = -200;
        this.ball = game.add.sprite(0,0, "imgBall");
        game.physics.enable(this.ball);
        this.ball.enableBody = true; // Añadir al motor de fisica la pelota
        this.ball.body.collideWorldBounds = true; // Para que tome los limites del mundo y rebote
        this.ball.body.bounce.set(1);// La velocidad de rebote al haber colision
        this.ball.isShot = false;
        this.ball.checkWorldBounds = true; // revisa los limites del mundo
        this.ball.events.onOutOfBounds.add(this.lose, this); // Agrega eventos de cuand sale del mundo resetea
        this.reset();
        
        game.input.onDown.add(this.shoot, this);
        
        // Agregar texto a la aplicacion
        this.strScore = "score: ";
        this.strLives = "lives: ";
        
        var txtProps = {
            font: "400 20px 'Indie Flower'",
            fill: "#ffffff",
            align: "left"
        };
       
        
        this.txtScore = game.add.text(0,0, this.strScore, txtProps);
        this.txtScore.anchor.set(0,1);
        this.txtScore.x = game.world.width - game.world.width/7;
        this.txtScore.y = game.world.height;
        this.txtScore.text = this.strScore + this.score;
        
        this.txtLives = game.add.text(0,0, this.strLives, txtProps);
        this.txtLives.anchor.set(0,1);
        this.txtLives.x += 7;
        this.txtLives.y = game.world.height;
        this.txtLives.text = this.strLives + this.lives;
    },
    
    update: function () { // un while por asi decirlo
            
        game.physics.arcade.collide(this.paddle, this.ball) // Colision entre la raqueta y la pelota
       // game.physics.arcade.collide(this.brickList, this.ball)    
        game.physics.arcade.collide(this.ball, this.brickList, this.killBrick, null, this);
        // input por mouse
        
            if(this.prevX != game.input.x){ // Toma la ultima posicion del mouse y le da prioridad  
                
                this.paddle.x = game.input.x;
            
            } else {
            //input por teclado

                var kRight = game.input.keyboard.isDown(Phaser.Keyboard.RIGHT); // Activacion de teclas es con esta sintaxis - varia el mapeo de las teclas
                var kLeft = game.input.keyboard.isDown(Phaser.Keyboard.LEFT);

                if(kRight && !kLeft) {// cuando se pulsan ambas teclas no entra en conflicto

                    this.paddle.x += this.paddleSpeed * game.time.physicsElapsed; // Se hace el calculo de la velocidad refiriendo el tiempo
                }
                if(kLeft && !kRight) {
                    this.paddle.x -= this.paddleSpeed * game.time.physicsElapsed;
                }
                if (this.paddle.x - this.paddleHalf < 0) { // Calculo de limites con lado izquierdo
                    this.paddle.x = this.paddleHalf;
                }
            }

            this.prevX = game.input.x; // asigna a prevx la ultima posicion del mouse

            if(this.paddle.x + this.paddleHalf > game.world.width) /// Calculo con lado derecho o limite del mundo
            this.paddle.x = game.world.width - this.paddleHalf; // toma en cuenta el ancho del mundo para calcular los limites de movimiento
            
            if(game.input.keyboard.isDown(Phaser.Keyboard.SPACEBAR)){
               this.shoot();
            }
        
            if(!this.ball.isShot)
            {
                this.ball.x = this.paddle.x;
            }else {
             //   this.ball.x += this.ballVelX * game.time.physics.physicsElapsed; //Rl movimiento de la pelota sin la inclusion del motor de fisica
            // this.ball.y += this.ballVelY * game.time.physics.physicsElapsed;
            }

        },
    
    killBrick: function(ball, brick){
        brick.kill();
        this.score += 10;
        this.txtScore.text = this.strScore + this.score;
    },
    
    reset: function () {
        this.paddle.x = game.world.centerX;
        this.paddle.y = game.world.height;
        this.paddle.y -= this.paddle.height;
        this.ball.anchor.set(0.5,0.5);
        this.ball.body.velocity.set(0); //resetear la velocidad de la bola
        this.ball.x = this.paddle.x;
        this.ball.y = this.paddle.y;
        this.ball.y -= this.paddle.height;
        this.ball.y -= this.ball.width / 2;
        this.ball.isShot= false;
        
    },
    
    lose: function(){
        this.lives--;
        this.txtLives.text = this.strLives + this.lives;
        if(this.lives === 0)
            game.state.start("StateOver");
        this.reset();
    },
    
    shoot: function(){ //Verificar el disparo de la pelotita
        if(this.ball.isShot === true)
        return;
        this.ball.isShot = true;
        this.ball.body.velocity.x = this.ballVelX; // se coloca 0
        this.ball.body.velocity.y = this.ballVelY;
    }

};