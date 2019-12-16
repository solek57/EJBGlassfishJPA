package com.devcolibri.bean;

import com.devcolibri.entity.Topic;
import com.devcolibri.entity.User;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
@Local
public class TopicBean {

    // Будет инициализирован контейнером Glassfish
    // unitName = "DEVMODE" - это имя persistence-unit
    // EntityManager дает возможность выполнять CRUD запросы в БД
    @PersistenceContext(unitName = "DEVMODE")
    private EntityManager em;

    // Добавляем User-а В базу данных
    public Topic add(Topic topic){
        return em.merge(topic);
    }


    // Получаем пользователя по id
    public Topic get(long id){
        return em.find(Topic.class, id);
    }

    // обновляем пользователя
    // если User которого мыпытаемся обновить нет,
    // то запишется он как новый
    public void update(Topic topic){
        add(topic);
    }

    // удаляем User по id
    public void delete(long id){
        em.remove(get(id));
    }

    // Получаем все пользователей с БД
    public List<Topic> getAllTopic() {
        Query query = em.createQuery("SELECT t FROM Topic t");
        return query.getResultList();
    }

    public void deleteAllNews(long idd){
        Query query = em.createQuery("DELETE FROM News n WHERE n.id =:id");
        query.setParameter("id",idd);
    }

}
