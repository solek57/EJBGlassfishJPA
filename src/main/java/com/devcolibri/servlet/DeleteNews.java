package com.devcolibri.servlet;

import com.devcolibri.bean.NewsBean;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/deleteNews")
public class DeleteNews extends HttpServlet {

    @EJB
    private NewsBean newsBean;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("id") != null && req.getParameter("id") != "") {
            long id = Long.valueOf(req.getParameter("id"));
            newsBean.delete(id);
        }
        req.getRequestDispatcher("/allTopic").forward(req, resp);

    }
}
