package org.academiadecodigo.bootcamp.Positioning;

import org.academiadecodigo.bootcamp.Colors.Colors;
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
        currentColor = Color.RED;

    }

    public void paintCell(int whichType){

        switch (whichType) {
            case 0:
                thisRecangle.setColor(Color.BLACK);
                thisRecangle.draw();
                isPainted = false;
                paintStatus = 0;
                break;

            case 1:
                thisRecangle.setColor(Color.RED);
                thisRecangle.fill();
                isPainted = true;
                paintStatus = 1;
                break;
            case 2:
                thisRecangle.setColor(Color.BLACK);
                thisRecangle.fill();
                isPainted = true;
                paintStatus = 2;
                break;
            case 3:
                thisRecangle.setColor(Color.GREEN);
                thisRecangle.fill();
                isPainted = true;
                paintStatus = 3;
                break;
        }

    }

    public boolean isPainted(){
        return isPainted;
    }

    public void paint(){
        thisRecangle.setColor(currentColor);
        thisRecangle.fill();
        if ( currentColor == Color.RED) {
            paintStatus = 1;
        } else if ( currentColor == Color.BLACK){
            paintStatus = 2;
        } else if ( currentColor == Color.GREEN){
            paintStatus = 3;
        }
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

    public void setCurrentColor(Color whichColor){
      currentColor = whichColor;
    }



}
