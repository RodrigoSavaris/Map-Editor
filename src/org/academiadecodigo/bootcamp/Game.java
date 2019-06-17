package org.academiadecodigo.bootcamp;

import org.academiadecodigo.bootcamp.Positioning.Cursor;
import org.academiadecodigo.bootcamp.Positioning.Directions;
import org.academiadecodigo.bootcamp.Positioning.GameKeyboardHandler;
import org.academiadecodigo.bootcamp.Positioning.Grid;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;

public class Game {

    private Cursor cursor;
    private Grid grid;

    private GameKeyboardHandler playerKB;
    private Keyboard keyboard;


    public void gameInit(int height, int width, int padding, int cellsize) {
        grid = new Grid(height, width, padding, cellsize);
        grid.initializeGrid();

               cursor = new Cursor(padding, padding, cellsize, cellsize, height, width);

        playerKB = new GameKeyboardHandler(this);
        keyboard = new Keyboard(playerKB);

        addEvent(KeyboardEvent.KEY_UP, KeyboardEventType.KEY_PRESSED, keyboard);
        addEvent(KeyboardEvent.KEY_DOWN, KeyboardEventType.KEY_PRESSED, keyboard);
        addEvent(KeyboardEvent.KEY_RIGHT, KeyboardEventType.KEY_PRESSED, keyboard);
        addEvent(KeyboardEvent.KEY_LEFT, KeyboardEventType.KEY_PRESSED, keyboard);

        addEvent(KeyboardEvent.KEY_SPACE, KeyboardEventType.KEY_PRESSED, keyboard);


    }


    private void addEvent(int key, KeyboardEventType keyEvent, Keyboard keyboard) {

        KeyboardEvent e = new KeyboardEvent();
        e.setKey(key);
        e.setKeyboardEventType(keyEvent);

        keyboard.addEventListener(e);
    }


    public void moveCursor(Directions direction) {

        cursor.whichDirection(direction);

    }

    public void paint(){

        grid.paint(cursor.getCursorCol(),cursor.getCursorRow());
    }



}
