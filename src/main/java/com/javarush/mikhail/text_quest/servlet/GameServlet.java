package com.javarush.mikhail.text_quest.servlet;

import com.javarush.mikhail.text_quest.model.Question;
import com.javarush.mikhail.text_quest.service.GameService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/game")
public class GameServlet extends HttpServlet {

    private final GameService gameService = new GameService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        HttpSession session = req.getSession();

        if (session == null || session.getAttribute("playerName") == null) {
            resp.sendRedirect(req.getContextPath() + "/start");
            return;
        }

        Integer currentQuestionId = (Integer) session.getAttribute("currentQuestionId");

        if (currentQuestionId == null) {
            currentQuestionId = gameService.getStartQuestionId();
            session.setAttribute("currentQuestionId", currentQuestionId);
        }

        Question question = gameService.getQuestion(currentQuestionId);

        req.setAttribute("question", question);

        req.getRequestDispatcher("jsp/game.jsp")
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        int nextQuestionId = Integer.parseInt(req.getParameter("answerId"));

        HttpSession session = req.getSession(false);

        Question nextQuestion = gameService.getQuestion(nextQuestionId);

        if (nextQuestion.isGameOver()) {
            Integer gamesCount = (Integer) session.getAttribute("gamesCount");
            session.setAttribute("gamesCount", gamesCount + 1);
        }

        session.setAttribute("currentQuestionId", nextQuestionId);

        resp.sendRedirect(req.getContextPath() + "/game");
    }
}
