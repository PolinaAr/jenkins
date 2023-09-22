package org.example.controller;

import org.example.service.UserDtoCreate;
import org.example.service.UserDtoFull;
import org.example.service.UserService;
import org.example.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/users/create")
public class CreateUser extends HttpServlet {

    private final UserService userService = UserServiceImpl.getInstance();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserDtoFull userDtoFull = userService.create(getUserDtoCreate(req));
        req.setAttribute("user", userDtoFull);
        req.getRequestDispatcher("jsp/getUser.jsp");
    }

    private UserDtoCreate getUserDtoCreate(HttpServletRequest req) {
        return new UserDtoCreate(
                req.getParameter("name"),
                req.getParameter("lastname"),
                Integer.parseInt(req.getParameter("age"))
        );
    }
}
