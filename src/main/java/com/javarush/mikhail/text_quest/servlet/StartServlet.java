package com.javarush.mikhail.text_quest.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/start")
public class StartServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.getRequestDispatcher("/jsp/start.jsp")
                .forward(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String playerName = req.getParameter("name");

        HttpSession session = req.getSession(true);

        session.setAttribute("playerName", playerName);

        session.setAttribute("currentQuestionId", null);

        if (session.getAttribute("gamesCount") == null) {
            session.setAttribute("gamesCount", 0);
        }

        resp.sendRedirect(req.getContextPath() + "/game");
    }
}
