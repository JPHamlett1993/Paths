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
        String htmlCode = "";
        for (char[] charA : visualSolution){
            for (char c : charA){
                if (c == 'B') {
                    htmlCode += "<div class=\"block red\"></div>";
                }
                if (c == 'P') {
                    htmlCode += "<div class=\"block white\"></div>";
                }
                if (c == 'S') {
                    htmlCode += "<div class=\"block green\"></div>";
                }
            }
            htmlCode += "<br/>";
        }

        System.out.println(htmlCode);
        request.setAttribute("path", htmlCode);


        httpAction.forwardTo("index.jsp", request, response);
    }
}
