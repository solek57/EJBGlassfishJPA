package com.devcolibri.bean;

import com.devcolibri.entity.News;


import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
@Local
public class NewsBean {

    @PersistenceContext(unitName = "DEVMODE")
    private EntityManager em;

    public News add(News news){
        return em.merge(news);
    }

    public News get(long id){
        return em.find(News.class, id);
    }


    public void update(News news){
        add(news);
    }

    public void delete(long id){
        em.remove(get(id));
    }

    public List<News> getAllNews(long idd) {
        Query query = em.createQuery("SELECT n FROM News n where n.topic.id = :id");
        query.setParameter("id" ,idd);
        return query.getResultList();
    }

}
