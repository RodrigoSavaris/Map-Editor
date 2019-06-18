package org.academiadecodigo.bootcamp.Positioning;

//import org.academiadecodigo.bootcamp.Colors.Colors;
import org.academiadecodigo.bootcamp.Game;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class GameKeyboardHandler implements KeyboardHandler {

    private Game game;

    public GameKeyboardHandler(Game game) {
        this.game = game;
    }


    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        int whichKey = keyboardEvent.getKey();

        switch (whichKey) {
            case KeyboardEvent.KEY_RIGHT:
                game.moveCursor(Directions.RIGHT);
                break;
            case KeyboardEvent.KEY_LEFT:
                game.moveCursor(Directions.LEFT);
                break;
            case KeyboardEvent.KEY_UP:
                game.moveCursor(Directions.UP);
                break;
            case KeyboardEvent.KEY_DOWN:
                game.moveCursor(Directions.DOWN);
                break;
            case KeyboardEvent.KEY_SPACE:
                game.paint();
                break;
            case KeyboardEvent.KEY_S:
                game.saveImage();
                break;
            case KeyboardEvent.KEY_L:
                game.loadImage();
                break;
            case KeyboardEvent.KEY_1:
                game.changeColor(1); //Color red (default)
                break;
            case KeyboardEvent.KEY_2:
                game.changeColor(2); //Color black
                break;
            case KeyboardEvent.KEY_3:
                game.changeColor(3); //Color green
                break;
            case KeyboardEvent.KEY_4:
                game.changeColor(4); //Color yellow
                break;
            case KeyboardEvent.KEY_C:
                game.clearGrid();
                break;
            case KeyboardEvent.KEY_F:
                game.fillGrid();
                break;


        }

    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
}
