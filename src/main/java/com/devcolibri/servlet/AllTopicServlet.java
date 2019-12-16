package com.devcolibri.servlet;

import com.devcolibri.bean.NewsBean;
import com.devcolibri.bean.TopicBean;
import com.devcolibri.entity.Topic;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/allTopic")
public class AllTopicServlet extends HttpServlet{

    @EJB
    private TopicBean topicBean;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        List<Topic> allTopic = topicBean.getAllTopic();


        req.setAttribute("topics", allTopic);

        req.getRequestDispatcher("/allTopic.jsp").forward(req, resp);

    }

}
