package com.devcolibri.servlet;

import com.devcolibri.bean.TopicBean;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/deleteTopic")
public class DeleteTopic extends HttpServlet {

    @EJB
    private TopicBean topicBean;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("id") != null && req.getParameter("id") != "") {
            long id = Long.valueOf(req.getParameter("id"));
            topicBean.deleteAllNews(topicBean.get(id));
            topicBean.delete(id);
        }
        req.getRequestDispatcher("/allTopic").forward(req, resp);
    }
}
