package maze_solver;

//import maze_solver.data_types.mazeNode;
import maze_solver.data_types.mazeNode;
import utility.fileIO;

import java.awt.Point;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;


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

    // Use BFS to solve the maze
    public mazeNode solve(int[][] gridLength, Point src, Point dest){
        if (src == null || dest == null){
            return null;
        }
        gridLength[src.x][src.y] = 0; // Distance to self is 0
        boolean queued[][] = new boolean[gridLength.length][gridLength[0].length]; //Set all booleans to false
        queued[src.x][src.y] = true;
        Queue<mazeNode> queue = new LinkedList<>();
        mazeNode initialNode = new mazeNode(src, 0, null);
        queue.add(initialNode);
        while (!queue.isEmpty()){
            mazeNode currentNode = queue.peek();
            Point currentPoint = currentNode.getPoint();
            if (currentPoint.equals(dest)){
                return currentNode;
            }
            queue.poll();
            // Add adjacent valid cells
            try {
                if (canMove(pathGrid[currentPoint.x].charAt(currentPoint.y - 1)) && !queued[currentPoint.x][currentPoint.y - 1]) {
                    gridLength[currentPoint.x][currentPoint.y - 1] = currentNode.getDist() + 1;
                    queue.add(new mazeNode(new Point(currentPoint.x, currentPoint.y - 1), currentNode.getDist() + 1, currentNode));
                    queued[currentPoint.x][currentPoint.y - 1] = true;
                }
            }catch (IndexOutOfBoundsException e){

            }

            try {
                if (canMove(pathGrid[currentPoint.x].charAt(currentPoint.y + 1)) && !queued[currentPoint.x][currentPoint.y + 1]){
                    gridLength[currentPoint.x][currentPoint.y + 1] = currentNode.getDist() + 1;
                    queue.add(new mazeNode(new Point(currentPoint.x, currentPoint.y + 1), currentNode.getDist() + 1, currentNode));
                    queued[currentPoint.x][currentPoint.y + 1] = true;
                }
            } catch (IndexOutOfBoundsException e) {
            }
            try {
                if (canMove(pathGrid[currentPoint.x - 1].charAt(currentPoint.y)) && !queued[currentPoint.x - 1][currentPoint.y]){
                    gridLength[currentPoint.x - 1][currentPoint.y] = currentNode.getDist() + 1;
                    queue.add(new mazeNode(new Point(currentPoint.x - 1, currentPoint.y), currentNode.getDist() + 1, currentNode));
                    queued[currentPoint.x - 1][currentPoint.y] = true;
                }
            } catch (IndexOutOfBoundsException e) {
            }
            try {
                if (canMove(pathGrid[currentPoint.x + 1].charAt(currentPoint.y)) && !queued[currentPoint.x + 1][currentPoint.y]){
                    gridLength[currentPoint.x + 1][currentPoint.y] = currentNode.getDist() + 1;
                    queue.add(new mazeNode(new Point(currentPoint.x + 1, currentPoint.y), currentNode.getDist() + 1, currentNode));
                    queued[currentPoint.x + 1][currentPoint.y] = true;
                }
            } catch (IndexOutOfBoundsException e) {
            }
        }
        return null; // Cannot be reached
    }

    public Solver(String path){
        setPath(path);
    }


}
