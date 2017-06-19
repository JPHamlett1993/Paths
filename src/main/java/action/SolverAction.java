package action;

import maze_solver.Solver;
import maze_solver.data_types.mazeNode;
import utility.httpAction;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * Created by jphamlett on 6/17/17.
 */
public class SolverAction {

    public static void perform(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("Request: " + request.getParameter("path"));
        String path = request.getParameter("path");


        if (request == null || response == null) {
            throw new ServletException("Null request/response object(s).");
        }


        Solver solver = new Solver(path);
        String[] mazeLayout = solver.getPath();
        char[][] visualSolution = new char[mazeLayout.length][mazeLayout[0].length()];
        mazeNode solution = solver.solve(new int[solver.getPath().length][solver.getPath()[0].length()], solver.findA(), solver.findB());
        for (int i = 0; i < mazeLayout.length; i++){
            for (int j = 0; j < mazeLayout[i].length(); j++){
                if (mazeLayout[i].charAt(j) == '#'){
                    visualSolution[i][j] = 'B';
                } else {
                    visualSolution[i][j] = 'P';
                }
            }
        }
        mazeNode currNode = solution;
        while (currNode != null){
            visualSolution[currNode.getPoint().x][currNode.getPoint().y] = 'S';
            currNode = currNode.getPreultimate();
        }

        System.out.println(visualSolution.length);
        String cssBlockClass = "";
        String cssMazeClass = "";
        if (visualSolution[0].length > 100){
            cssBlockClass = "block_small";
            cssMazeClass = "maze_large";
        }
        if (visualSolution[0].length > 50 && visualSolution[0].length <= 100){
            cssBlockClass = "block_medium";
            cssMazeClass = "maze_medium";
        }
        if (visualSolution[0].length <= 50){
            cssBlockClass = "block_large";
            cssMazeClass = "maze_small";
        }

        String htmlCode = "";
        for (char[] charA : visualSolution){
            htmlCode += "<div class=\"rowwrap\">";
            for (char c : charA){
                if (c == 'B') {
                    htmlCode += "<div class=\"" + cssBlockClass + " red\"></div>";
                }
                if (c == 'P') {
                    htmlCode += "<div class=\"" + cssBlockClass + " white\"></div>";
                }
                if (c == 'S') {
                    htmlCode += "<div class=\"" + cssBlockClass + " green\"></div>";
                }
            }
            htmlCode += "</div>";
        }
        System.out.println("X: " + visualSolution.length + " Y: " + visualSolution[0].length);
        request.setAttribute("path", htmlCode);
        request.setAttribute("pathSteps", solution.getDist());
        request.setAttribute("cssMazeClass", cssMazeClass);


        httpAction.forwardTo("index.jsp", request, response);
    }
}
