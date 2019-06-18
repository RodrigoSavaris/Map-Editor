package org.academiadecodigo.bootcamp.Positioning;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class Cursor {

    private int cursorCol;
    private int cursorRow;
    private Rectangle playerCursor;

    private int cellSize;
    private int colBoundary;
    private int rowBoundary;

    private Color cursorColor;

    public Cursor(int startingX, int startingY, int recwidth, int recheight, int width, int height){


        playerCursor = new Rectangle(startingX,startingY,recwidth,recheight);
        playerCursor.setColor(Color.GREEN);
        playerCursor.fill();
        cursorCol = 0;
        cursorRow = 0;
        cellSize = recwidth;
        colBoundary = width;
        rowBoundary = height;
        cursorColor = Color.RED;


    }

    public int getCursorCol(){
        return cursorCol;
    }

    public int getCursorRow(){
        return cursorRow;
    }

    public void whichDirection( Directions directions){

        switch (directions){
            case RIGHT:
                moveRight();
                break;
            case LEFT:
                moveLeft();
                break;
            case UP:
                moveUp();
                break;
            case DOWN:
                moveDown();
                break;
        }

    }

    public void moveUp(){
        if (cursorRow > 0){
            playerCursor.translate(0,-cellSize);
            cursorRow--;
        }
    }

    public void moveDown(){
        if ( cursorRow < rowBoundary-1){
            playerCursor.translate(0,cellSize);
            cursorRow++;
        }
    }

    public void moveRight(){
        if ( cursorCol < rowBoundary-1){
            playerCursor.translate(cellSize,0);
            cursorCol++;
        }
    }

    public void moveLeft(){
        if ( cursorCol > 0){
            playerCursor.translate(-cellSize,0);
            cursorCol--;
        }
    }

    public void setCurrentColor(int colorIndex){
        switch (colorIndex){
            case 1:
                this.cursorColor=Color.RED;
                break;
            case 2:
                this.cursorColor=Color.BLACK;
                break;
            case 3:
                this.cursorColor=Color.GREEN;
                break;
            case 4:
                this.cursorColor=Color.YELLOW;
                break;

        }

    }

    public Color getCursorColor(){
        return cursorColor;
    }






}
