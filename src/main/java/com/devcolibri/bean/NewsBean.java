package com.devcolibri.bean;

import com.devcolibri.entity.News;
import com.devcolibri.entity.Topic;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
@Local
public class NewsBean {

    // Будет инициализирован контейнером Glassfish
    // unitName = "DEVMODE" - это имя persistence-unit
    // EntityManager дает возможность выполнять CRUD запросы в БД
    @PersistenceContext(unitName = "DEVMODE")
    private EntityManager em;

    // Добавляем User-а В базу данных
    public News add(News news){
        return em.merge(news);
    }


    // Получаем пользователя по id
    public News get(long id){
        return em.find(News.class, id);
    }

    // обновляем пользователя
    // если User которого мыпытаемся обновить нет,
    // то запишется он как новый

    public void update(News news){
        add(news);
    }

    // удаляем User по id
    public void delete(long id){
        em.remove(get(id));
    }

    // Получаем все пользователей с БД
    public List<News> getAllNews(long idd) {
        Query query = em.createQuery("SELECT n FROM News n where n.topic_id = :id");
        query.setParameter("id" ,idd);
        return query.getResultList();
    }

}
