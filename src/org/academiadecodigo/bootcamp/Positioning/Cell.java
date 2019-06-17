package org.academiadecodigo.bootcamp.Positioning;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Cell {
    private int row;
    private int col;
    private Color currentColor;
    private boolean isPainted;
    private Rectangle thisRecangle;

    public Cell(int startingX, int startingY, int length, int height){

        thisRecangle = new Rectangle(startingX,startingY,length,height);
        thisRecangle.setColor(Color.BLACK);
        thisRecangle.draw();
        this.currentColor = Color.BLACK;
        isPainted = false;
        this.row = startingY;
        this.col = startingX;

    }

    public boolean isPainted(){
        return isPainted;
    }

    public void paint(){
        thisRecangle.setColor(Color.RED);
        thisRecangle.fill();
        isPainted = true;
    }

    public void unpaint(){
        thisRecangle.setColor(Color.BLACK);
        thisRecangle.draw();
        isPainted=false;
    }
}
