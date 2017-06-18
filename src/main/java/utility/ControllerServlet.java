package utility;

import action.IndexAction;
import action.SolverAction;
import maze_solver.Solver;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;



/**
 * Created by jphamlett on 6/17/17.
 */
public class ControllerServlet extends HttpServlet {

    Solver solver;

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        //Call super class init method
        super.init(servletConfig);

        solver = new Solver();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        handleRequest(request, response, true);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        handleRequest(request, response, false);
    }

    private void handleRequest(HttpServletRequest request, HttpServletResponse response, boolean solver) throws ServletException, IOException {
        System.out.println("Solver: " + solver);
        if (!solver) {
            IndexAction.perform(request, response);
        } else {
            SolverAction.perform(request, response);
        }
    }

}
