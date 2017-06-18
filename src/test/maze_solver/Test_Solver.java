package maze_solver;

import org.junit.jupiter.api.Test;

import java.awt.*;

/**
 * Created by jphamlett on 6/16/17.
 */
public class Test_Solver {

    String testPath[] = {"##########", "#A...#...#", "#.#.##.#.#", "#.#.##.#.#", "#.#....#B#", "#.#.##.#.#", "#....#...#", "##########"};
    String fileLocationNoA = "test/maze1NoA.txt";
    String fileLocationNoB = "test/maze1NoB.txt";
    String fileLocation = "test/maze1.txt";

    @Test
    public void testPathSetter(){
        Solver solver = new Solver(fileLocation);
        assertArrayEquals(testPath, solver.getPath());
    }

    @Test
    public void testFindA(){
        Solver solver = new Solver(fileLocation);
        assertEquals(new Point(1, 1), solver.findA());
    }

    @Test
    public void testFindANotThere(){
        Solver solver = new Solver(fileLocationNoA);
        assertEquals(null, solver.findA());
    }

    @Test
    public void testFindB(){
        Solver solver = new Solver(fileLocation);
        assertEquals(new Point(4, 8), solver.findB());
    }

    @Test
    public void testFindBNotThere(){
        Solver solver = new Solver(fileLocationNoB);
        assertEquals(null, solver.findB());
    }

    @Test
    public void testCanMoveValid(){
        Solver solver = new Solver(fileLocation);
        assertTrue(solver.canMove('.'));
    }

    @Test
    public void testCanMoveInvalid(){
        Solver solver = new Solver(fileLocation);
        assertFalse(solver.canMove('#'));
    }

}
