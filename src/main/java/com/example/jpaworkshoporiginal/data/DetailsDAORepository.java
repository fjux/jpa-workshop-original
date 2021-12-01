package com.example.jpaworkshoporiginal.data;

import com.example.jpaworkshoporiginal.model.Details;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@Transactional
public class DetailsDAORepository implements DetailsDAO{

    private final EntityManager entityManager;

    @Autowired
    public DetailsDAORepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Details findById(int id) {
        return entityManager.find(Details.class, id);
    }

    @Override
    public List<Details> findAll() {
        return entityManager.createQuery("SELECT d FROM Details d", Details.class)
                .getResultList();
    }

    @Override
    public Details create(Details details) {
        if (details == null) throw new IllegalArgumentException("Address was null");
        entityManager.persist(details);
        return details;
    }

    @Override
    public Details update(Details details) {
        return entityManager.merge(details);
    }

    @Override
    public void delete(int id) {
        entityManager.remove(findById(id));
    }
}
