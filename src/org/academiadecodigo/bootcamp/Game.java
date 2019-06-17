package org.academiadecodigo.bootcamp;

import org.academiadecodigo.bootcamp.Colors.Colors;
import org.academiadecodigo.bootcamp.Positioning.*;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;

import java.io.*;

public class Game {

    private Cursor cursor;
    private Grid grid;

    private GameKeyboardHandler playerKB;
    private Keyboard keyboard;

    private FileReader reader = null;
    private BufferedReader bReader = null;

    private FileWriter writer = null;
    private BufferedWriter bWriter = null;





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
        addEvent(KeyboardEvent.KEY_S,KeyboardEventType.KEY_PRESSED,keyboard);
        addEvent(KeyboardEvent.KEY_L,KeyboardEventType.KEY_PRESSED,keyboard);
        addEvent(KeyboardEvent.KEY_1,KeyboardEventType.KEY_PRESSED,keyboard);
        addEvent(KeyboardEvent.KEY_2,KeyboardEventType.KEY_PRESSED,keyboard);
        addEvent(KeyboardEvent.KEY_3,KeyboardEventType.KEY_PRESSED,keyboard);
        addEvent(KeyboardEvent.KEY_C,KeyboardEventType.KEY_PRESSED,keyboard);


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

    public void saveImage(){

        try {
            writer = new FileWriter("/Users/codecadet/workspace/PaintProject/savedGrid/grid.txt");
            bWriter = new BufferedWriter(writer);
        } catch (FileNotFoundException e){
            e.getMessage();
        } catch (IOException i){
            i.getMessage();
        }


        for (int y = 0; y < grid.getHeight(); y++){
            for (int x = 0; x < grid.getWidth() ; x++){


                //byte[] buffer = String.valueOf(grid.getAllPaintedStatusCurrentPosition(x,y)).getBytes();

                try{
                    writer.write("" + grid.getCell(x,y).getPaintStatus());
                } catch ( IOException a){
                    a.getMessage();
                }

            }
        }
        System.out.println("Successfully saved!");
        try {
            writer.flush();
            writer.close();
        }catch (IOException o){
            o.getMessage();
        }

    }

    public void loadImage(){

        try {
            reader = new FileReader("/Users/codecadet/workspace/PaintProject/savedGrid/grid.txt");
            bReader = new BufferedReader(reader);
        } catch (FileNotFoundException e){
            e.getMessage();
        }

       String line = "";

       try {
           line = bReader.readLine();
       } catch (IOException e){
           e.getMessage();
       }

        //System.out.println(line.toCharArray());

       int fileCounter= 0;

        for (int y = 0; y < grid.getHeight(); y++){
            for (int x = 0; x < grid.getWidth() ; x++){

                grid.initializeAllCellsSaved(x,y,Character.getNumericValue( line.charAt(fileCounter)));
                //System.out.println("the file counter number "+fileCounter+" is equal to "+line.charAt(fileCounter));
                fileCounter++;

            }
        }
        System.out.println("Successfully loaded!");
        try {

            reader.close();
        }catch (IOException aa){
            aa.getMessage();
        }

    }


    public void changeColor(int colorIndex){

        cursor.setCurrentColor(colorIndex);

        for (int y = 0; y < grid.getHeight(); y++){
            for (int x = 0; x < grid.getWidth() ; x++){

                grid.getCell(x,y).setCurrentColor(cursor.getCursorColor());

            }
        }
    }

    public void clearGrid(){
        for (int y = 0; y < grid.getHeight(); y++){
            for (int x = 0; x < grid.getWidth() ; x++){

            grid.getCell(x,y).unpaint();

            }
        }

    }


}
