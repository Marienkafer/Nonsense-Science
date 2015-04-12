// state_over.js

var StateOver = {
    preload: function () {
    },
    
    create: function () {
        var txtProps = {
            font: "400 60px 'Indie Flower'",
            fill: "#ffffff",
            align: "center"
        };
        
        var text = game.add.text(0,0,"game over", txtProps);
        text.anchor.set(.5, .5);
        text.x = game.world.centerX;
        text.y = game.world.centerY;
        
        game.input.onDown.add(this.play, this); // Vuelve al main con el clic
    },
    
    update: function() {
        
        if(game.input.keyboard.isDown(Phaser.Keyboard.SPACEBAR)){
           this.play()
        }
    },
    
    play: function() {
        game.state.start("StateMain");
    }
};