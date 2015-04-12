/*state_main.js*/

var StateMain = {
    preload: function () {
        game.load.image("imgPaddle", "img/player/playerShip2_red.png");
        game.load.image("imgBrickBlack", "img/enemies/enemyBlack3.png");
        game.load.image("imgBrickBlue", "img/enemies/enemyBlue3.png");
        game.load.image("imgBrickGreen", "img/enemies/enemyGreen3.png");
        game.load.image("imgBrickRed", "img/enemies/enemyRed3.png");
        game.load.image("imgBall", "img/lasers/laserBlue04.png");
    },
    
    create: function () {
        
        this.numCol = 5;
        this.numRow = 3;
        this.prevX = game.input.x;
        var w = game.world.width;
        var h = game.world.height;
        this.paddle = game.add.sprite(0,0,"imgPaddle");
        this.paddle.anchor.set(0.5, 1); 
        this.paddleHalf = this.paddle.width / 3;
        

        this.paddleSpeed = 300;
        
        var imgList = [ 
            "imgBrickBlack",
            "imgBrickBlue",
            "imgBrickGreen",
            "imgBrickRed", 
        ];
      
        this.brickList = game.add.group(); 
        var i, j;
        for(j = 0; j < this.numRow; j++){
            var img = imgList[j];
            for(i = 0; i< this.numCol; i++)
            { 
                var brick = this.brickList.create(0,0,img);
                brick.x = i * brick.width;
                brick.y = j * brick.height;
            }
        }
        
        this.ball = game.add.sprite(0,0, "imgBall");
        this.ball.isShot = false;
        
        this.reset();
    },
    
    update: function () { 
            
            // input  mouse
            if(this.prevX != game.input.x){ 
                
                this.paddle.x = game.input.x;
            
            } else {
            //input keyboard

                var kRight = game.input.keyboard.isDown(Phaser.Keyboard.RIGHT); 
                var kLeft = game.input.keyboard.isDown(Phaser.Keyboard.LEFT);

                if(kRight && !kLeft) {

                    this.paddle.x += this.paddleSpeed * game.time.physicsElapsed;
                }
                if(kLeft && !kRight) {
                    this.paddle.x -= this.paddleSpeed * game.time.physicsElapsed;
                }
                if (this.paddle.x - this.paddleHalf < 0) { 
                    this.paddle.x = this.paddleHalf;
                }
            }

            this.prevX = game.input.x; 
            if(this.paddle.x + this.paddleHalf > game.world.width) 
            this.paddle.x = game.world.width - this.paddleHalf; 
            if(!this.ball.isShot)
            {
                this.ball.x = this.paddle.x;
            }

        },
    
    
    reset: function () {
        this.paddle.x = game.world.centerX;
        this.paddle.y = game.world.height;
        this.brickList.x = game.world.height/7;
        this.ball.anchor.set(0.5,0.5);
        this.ball.x = this.paddle.x;
        this.ball.y = this.paddle.y;
        this.ball.y -= this.paddle.height+12;
        this.ball.y -= this.ball.width/2;
        
    }
};