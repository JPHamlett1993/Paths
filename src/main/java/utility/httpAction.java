package utility;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by jphamlett on 6/17/17.
 */
public class httpAction {

    public static void redirectTo(String pageName, HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("LETS GO");
        if (pageName == null) {
            throw new IllegalArgumentException("Invalid redirect location - " + pageName);
        }
        if (request == null || response == null) {
            throw new IllegalArgumentException("Null request/response object(s).");
        }
        response.sendRedirect(pageName.trim());
    }

    public static void forwardTo(String pageName, HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (pageName.isEmpty()) {
            throw new IllegalArgumentException("Invalid redirect page - " + pageName);
        }
        if (request == null || response == null) {
            throw new IllegalArgumentException("Null request/response object(s).");
        }
        if (!response.isCommitted()) {
            RequestDispatcher dispatcher = request.getRequestDispatcher(pageName);
            dispatcher.forward(request, response);
        } else {
            System.out.println("Response was already committed when attempting to forward to: " + pageName);
        }
    }
}
