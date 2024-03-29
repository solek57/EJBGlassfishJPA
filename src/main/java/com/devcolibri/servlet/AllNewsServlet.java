package com.devcolibri.servlet;

import com.devcolibri.bean.NewsBean;
import com.devcolibri.entity.News;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/allNews")
public class AllNewsServlet extends HttpServlet{

    @EJB
    private NewsBean newsBean;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

            long id = Long.valueOf(req.getParameter("id_topic"));
            req.setCharacterEncoding("UTF-8");
            List<News> allNews = newsBean.getAllNews(id);
            req.setAttribute("news", allNews);
            req.getRequestDispatcher("/allNews.jsp").forward(req, resp);
    }
}
