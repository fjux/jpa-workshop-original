package com.example.jpaworkshoporiginal.data;

import com.example.jpaworkshoporiginal.model.AppUser;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Repository
public class AppUserDAORepository implements AppUserDAO{
    private final EntityManager entityManager;

    public AppUserDAORepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional(readOnly = true)
    public AppUser findById(int id) {
        return entityManager.find(AppUser.class, id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<AppUser> findAll() {
        return entityManager.createQuery("SELECT a FROM AppUser a", AppUser.class)
                .getResultList();
    }

    @Override
    public AppUser create(AppUser appUser) {
        entityManager.persist(appUser);
        return appUser;
    }

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public AppUser update(AppUser appUser) {
        if (appUser == null) throw new IllegalArgumentException("AppUser was null");
        return entityManager.merge(appUser);
    }

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public void delete(int id) {
        entityManager.remove(findById(id));

    }
}
