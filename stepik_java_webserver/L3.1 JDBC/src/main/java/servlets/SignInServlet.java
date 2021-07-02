package servlets;

import accounts.UserProfile;
import dbService.DBException;
import dbService.DBService;
import dbService.dataSets.UsersDataSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SignInServlet extends HttpServlet {

    private DBService dbService;

    public SignInServlet(DBService dbService) {
        this.dbService = dbService;
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String login = request.getParameter("login");
        try {
            UsersDataSet profile = dbService.getUserByName(login);
            if (profile != null) {
                response.getWriter().write("Authorized: " + login);
            }
            else {
                response.getWriter().write("Unauthorized");
                response.setStatus(401);
            }
        }
        catch (DBException e) {
            response.getWriter().write("Unauthorized");
            response.setStatus(401);
        }

    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String login = request.getParameter("login");
        try {
            UsersDataSet profile = dbService.getUserByName(login);
            if (profile != null) {
                response.getWriter().write("Authorized: " + login);
            }
            else {
                response.getWriter().write("Unauthorized");
                response.setStatus(401);
            }
        }
        catch (DBException e) {
            response.getWriter().write("Unauthorized");
            response.setStatus(401);
        }

    }

}
