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

@WebServlet("/addTopic")
public class AddAndEditTopicServlet extends HttpServlet {

    @EJB
    private TopicBean topicBean;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        req.setCharacterEncoding("UTF-8");

        if(req.getParameter("edit") != null){
            long id = Long.valueOf(req.getParameter("edit"));
            Topic topic = topicBean.get(id);

            req.setAttribute("topic", topic);
        }

        req.getRequestDispatcher("/addTopic.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        req.setCharacterEncoding("UTF-8");

        String name = req.getParameter("name");
        if(!"".equals(req.getParameter("id"))){
            long id = Long.valueOf(req.getParameter("id"));
            Topic topic = topicBean.get(id);
            topic.setName(name);
            topicBean.update(topic);
        } else{
            topicBean.add(new Topic(name));
        }
        resp.sendRedirect("allTopic");
    }
}
