package org.academiadecodigo.bootcamp.Positioning;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Cell {
    private int row;
    private int col;
    private Color currentColor;
    private boolean isPainted;
    private Rectangle thisRecangle;
    private int paintStatus;

    public Cell(int startingX, int startingY, int length, int height){


        thisRecangle = new Rectangle(startingX, startingY, length, height);
        thisRecangle.setColor(Color.BLACK);
        thisRecangle.draw();
        this.currentColor = Color.BLACK;
        isPainted = false;
        this.row = startingY;
        this.col = startingX;
        paintStatus = 0;

    }

    public void paintCell(int whichType){

        switch (whichType) {
            case 0:
                thisRecangle.setColor(Color.BLACK);
                thisRecangle.draw();
                this.currentColor = Color.BLACK;
                isPainted = false;
                paintStatus = 0;
                break;

            case 1:
                thisRecangle.setColor(Color.RED);
                thisRecangle.fill();
                this.currentColor = Color.RED;
                isPainted = true;
                paintStatus = 1;
                break;
        }

    }

    public boolean isPainted(){
        return isPainted;
    }

    public void paint(){
        thisRecangle.setColor(Color.RED);
        thisRecangle.fill();
        paintStatus = 1;
        isPainted = true;
    }

    public void unpaint(){
        thisRecangle.setColor(Color.BLACK);
        thisRecangle.draw();
        isPainted=false;
        paintStatus = 0;
    }

    public int getPaintStatus(){
        return paintStatus;
    }
}
