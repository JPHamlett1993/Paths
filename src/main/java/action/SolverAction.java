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
        mazeNode solution = solver.solve(new int[solver.getPath().length][solver.getPath()[0].length()], solver.findA(), solver.findB());
        System.out.println(solution);
        request.setAttribute("path", solution);
        request.setAttribute("", "");

        httpAction.forwardTo(
                "index.jsp",
                request,
                response);
    }
}
