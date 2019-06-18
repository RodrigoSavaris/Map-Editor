package org.academiadecodigo.bootcamp.Positioning;

import org.academiadecodigo.simplegraphics.graphics.Color;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class Grid {
    private int height;
    private int width;
    private int padding;
    private int cellSize;
    private Cell[][] gridCells;
    private int rectangleStartX;
    private int rectangleStartY;


    public Grid(int height, int width, int padding, int cellSize){
        this.height = height;
        this.width = width;
        this.padding = padding;
        this.cellSize = cellSize;
        gridCells = new Cell[width][height];



    }

    public void setRectangleStart(int x, int y){
        rectangleStartX = x;
        rectangleStartY = y;
    }

    public int getRectangleStartX(){
        return rectangleStartX;
    }

    public int getRectangleStartY(){
        return rectangleStartY;
    }

    public int getHeight(){
        return height;
    }

    public int getWidth(){
        return width;
    }

    public int getPadding(){
        return padding;
    }

    public int getCellSize(){
        return cellSize;
    }

    public void initializeGrid(){

        for (int y = 0; y < height; y++){
            for (int x = 0; x < width ; x++){

                gridCells[x][y] = new Cell(x*cellSize + padding, y*cellSize + padding, cellSize,cellSize);

                //System.out.println(allPaintedStatus[x][y] );
            }
        }
    }


    public void initializeAllCellsSaved(int x, int y, int whichType){
        gridCells[x][y].paintCell(whichType);
    }


    public void paint(int whichCol, int whichRow){

        if(!gridCells[whichCol][whichRow].isPainted()){

            gridCells[whichCol][whichRow].paint();

        } else {

            gridCells[whichCol][whichRow].unpaint();
        }

    }

    /*public Cell getGridCells(int x, int y){
        return gridCells[x][y];
    }*/

    public Cell getCell(int x, int y){
        return gridCells[x][y];
    }

    public void fillGrid(){
        for (int y = 0; y < getHeight(); y++){
            for (int x = 0; x < getWidth() ; x++){

                getCell(x,y).paint();

            }
        }
    }

    public void drawingRectangle(int secondX, int secondY){

        int finalX = secondX;
        int startingX = rectangleStartX;

        if ( secondX < rectangleStartX){
            finalX = rectangleStartX;
            startingX = secondX;
        }

        int finalY = secondY;
        int startingY = rectangleStartY;

        if ( secondY < rectangleStartY){
            finalY = rectangleStartY;
            startingY = secondY;
        }


        for (int y = 0; y < getHeight(); y++){
            for (int x = 0; x < getWidth() ; x++){

                if ( (x == startingX) && (y >= startingY) && (y <= finalY)

                || (x == finalX) && (y >= startingY) && (y <= finalY)

                || (y == startingY) && (x <= finalX) && (x >= startingX)

                || (y == finalY) && (x <= finalX) && (x >= startingX)){

                    gridCells[x][y].paint();

                }

            }
        }
    }

    public void fillingRectangle( int secondX, int secondY){

        int finalX = secondX;
        int startingX = rectangleStartX;

        if ( secondX < rectangleStartX){
            finalX = rectangleStartX;
            startingX = secondX;
        }

        int finalY = secondY;
        int startingY = rectangleStartY;

        if ( secondY < rectangleStartY){
            finalY = rectangleStartY;
            startingY = secondY;
        }

        for (int y = 0; y < getHeight(); y++){
            for (int x = 0; x < getWidth() ; x++){

                if ( (x <= finalX) && (x >= startingX) && (y <= finalY) && (y >= startingY)){

                    gridCells[x][y].paint();


                }

            }
        }

    }

}
