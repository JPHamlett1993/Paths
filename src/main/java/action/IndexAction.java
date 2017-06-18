package action;

import utility.httpAction;
import maze_solver.data_types.mazeNode;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by jphamlett on 6/17/17.
 */
public class IndexAction {

    public static void perform(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("ASDFASD");
        if (request == null || response == null) {
            throw new ServletException("Null request/response object(s).");
        }

        httpAction.redirectTo(
                "index.jsp",
                request,
                response);
    }

}
