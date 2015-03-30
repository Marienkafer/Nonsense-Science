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
    
    create: function () {
        
        this.numCol = 10;
        this.numRow = 4;
        this.prevX = game.input.x;
        var w = game.world.width;
        var h = game.world.height;
        this.bg = game.add.tileSprite(0,0,w,h, "imgBgBlue"); // Crea copias de una iamgen pequeña y la multiplica
        this.paddle = game.add.sprite(0,0,"imgPaddle");
        this.paddle.anchor.set(0.5, 1); // El porcentaje por altura y anchura en este caso toma el 50% de la anchura del 100% de la altura
        this.paddleHalf = this.paddle.width / 2;
        
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
            }
        }
        
        this.ball = game.add.sprite(0,0, "imgBall");
        this.ball.isShot = false;
        
        this.reset();
    },
    
    update: function () { // un while por asi decirlo
            
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
            if(!this.ball.isShot)
            {
                this.ball.x = this.paddle.x;
            }

        },
    
    
    reset: function () {
        this.paddle.x = game.world.centerX;
        this.paddle.y = game.world.height;
        this.paddle.y -= this.paddle.height;
        this.ball.anchor.set(0.5,0.5);
        this.ball.x = this.paddle.x;
        this.ball.y = this.paddle.y;
        this.ball.y -= this.paddle.height;
        this.ball.y -= this.ball.width / 2;
        
    }
};