package servlets;

import accounts.AccountService;
import accounts.UserProfile;
import dbService.DBException;
import dbService.DBService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SignUpServlet extends HttpServlet {

    private DBService dbService;

    public SignUpServlet(DBService dbService) {
        this.dbService = dbService;
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String login = request.getParameter("login");
        try {
            dbService.addUser(login);
        }
        catch (DBException e) {}
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String login = request.getParameter("login");
        try {
            dbService.addUser(login);
        }
        catch (DBException e) {}
    }
}
