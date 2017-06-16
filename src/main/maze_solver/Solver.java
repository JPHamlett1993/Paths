package maze_solver;

import utility.fileIO;

import java.awt.*;
import java.io.IOException;
import java.nio.charset.Charset;

/**
 * Created by jphamlett on 6/16/17.
 */
public class Solver {
    private String[] pathGrid;
    private int[][] gridLength;


    public void setPath(String path) {
        try {
            this.pathGrid = generatePath(fileIO.readFile(path, Charset.defaultCharset()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Point findA(){
        for (int row = 0; row < pathGrid.length; row++){
                int pos = pathGrid[row].indexOf("A");
                if (pos != -1){
                    return new Point(row, pos);
                }
        }
        return null; // Something went wrong
    }

    public Point findB(){
        for (int row = 0; row < pathGrid.length; row++){
            int pos = pathGrid[row].indexOf("B");
            if (pos != -1){
                return new Point(row, pos);
            }
        }
        return null; // Something went wrong
    }

    public Boolean canMove(char symbol){
        return symbol != '#';
    }

    public String[] generatePath(String path){
        return path.split("\n");
    }

    public String[] getPath(){
        return this.pathGrid;
    }

    public void solve(){
        
    }

    public Solver(String path){
        setPath(path);
    }


}
