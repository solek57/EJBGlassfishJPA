package com.devcolibri.servlet;

import com.devcolibri.bean.NewsBean;
import com.devcolibri.bean.TopicBean;
import com.devcolibri.entity.News;
import com.devcolibri.entity.Topic;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addNews")
public class AddAndEditNewsServlet extends HttpServlet {

    @EJB
    private NewsBean newsBean;
    long id_topic;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        req.setCharacterEncoding("UTF-8");


        if(req.getParameter("edit") != null){
           long id_edit = Long.valueOf(req.getParameter("edit"));
           id_topic=Long.valueOf(req.getParameter("id_topic"));
            News news = newsBean.get(id_edit);

            req.setAttribute("news", news);
        }

        req.getRequestDispatcher("/addNews.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        req.setCharacterEncoding("UTF-8");

        String message = req.getParameter("message");
        if(!"".equals(req.getParameter("id"))){
            long id = Long.valueOf(req.getParameter("id"));
            News news = newsBean.get(id);
            news.setMessage(message);
            newsBean.update(news);
        } else{
            News news = new News(message,id_topic);
            newsBean.add(news);
        }
        resp.sendRedirect("allNews");
    }
}
