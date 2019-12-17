package com.devcolibri.bean;

import com.devcolibri.entity.Topic;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
@Local
public class TopicBean {

    @PersistenceContext(unitName = "DEVMODE")
    private EntityManager em;

    public Topic add(Topic topic){
        return em.merge(topic);
    }

    public Topic get(long id){
        return em.find(Topic.class, id);
    }

    public void update(Topic topic){
        add(topic);
    }

    public void delete(long id){
        em.remove(get(id));
    }

    public List<Topic> getAllTopic() {
        Query query = em.createQuery("SELECT t FROM Topic t");
        return query.getResultList();
    }

    public void deleteAllNews(Topic topic){
        Query query = em.createQuery("DELETE FROM News n WHERE n.topic =:id");
        query.setParameter("id",topic);
    }

}
