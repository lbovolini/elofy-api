package com.github.lbovolini.elofy.repository;

import com.github.lbovolini.elofy.exception.NameAlreadyRegisteredException;
import com.github.lbovolini.elofy.exception.NotFoundException;

import javax.persistence.*;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

public class BaseRepository<T> {

    protected static EntityManagerFactory factory = Persistence.createEntityManagerFactory("Elofy");

    public static EntityManager getEntityManager() {
        return factory.createEntityManager();
    }


    public List execute(String query) {
        EntityManager entityManager = null;
        try {
            entityManager = getEntityManager();
            Query query1 = entityManager.createQuery(query);

            return query1.getResultList();
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
    }

    public List execute(String query, List parameters) {
        EntityManager entityManager = null;
        try {
            entityManager = getEntityManager();
            Query query1 = entityManager.createQuery(query);
            for (int i = 0; i < parameters.size(); i++) {
                query1.setParameter(i + 1, parameters.get(i));
            }

            return query1.getResultList();
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
    }

    public Object executeSingle(String query) {
        EntityManager entityManager = null;
        try {
            entityManager = getEntityManager();

            Query query1 = entityManager.createQuery(query);

            return query1.getSingleResult();
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
    }

    public Object executeSingle(String query, List<String> parameters) {
        EntityManager entityManager = null;
        try {
            entityManager = getEntityManager();

            Query query1 = entityManager.createQuery(query);
            for (int i = 0; i < parameters.size(); i++) {
                query1.setParameter(i + 1, parameters.get(i));
            }

            return query1.getSingleResult();
        } catch (NoResultException nre) {
            throw new NotFoundException();
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
    }

    public void executeUpdate(String query, List<String> parameters) {
        EntityManager entityManager = null;
        try {
            entityManager = getEntityManager();
            entityManager.getTransaction().begin();

            Query query1 = entityManager.createQuery(query);
            for (int i = 0; i < parameters.size(); i++) {
                query1.setParameter(i + 1, parameters.get(i));
            }
            query1.executeUpdate();

            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            Throwable t = ex.getCause();
            while ((t != null) && !(t instanceof SQLIntegrityConstraintViolationException)) {
                t = t.getCause();
            }
            if (t instanceof SQLIntegrityConstraintViolationException) {
                if (t.getMessage().endsWith("'name'")) {
                    throw new NameAlreadyRegisteredException();
                }
            }
            throw new RuntimeException(ex.getCause());
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
    }

    public void executeDelete(String query) {
        EntityManager entityManager = null;
        try {
            entityManager = getEntityManager();
            entityManager.getTransaction().begin();

            Query query1 = entityManager.createQuery(query);
            query1.executeUpdate();

            entityManager.getTransaction().commit();
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
    }

    public void executeDelete(String query, List parameters) {
        EntityManager entityManager = null;
        try {
            entityManager = getEntityManager();
            entityManager.getTransaction().begin();

            Query query1 = entityManager.createQuery(query);
            for (int i = 0; i < parameters.size(); i++) {
                query1.setParameter(i + 1, parameters.get(i));
            }
            query1.executeUpdate();

            entityManager.getTransaction().commit();
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
    }

    public T save(T table) {

        EntityManager entityManager = null;
        try {
            entityManager = getEntityManager();
            entityManager.getTransaction().begin();

            entityManager.persist(table);

            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            Throwable t = ex.getCause();
            while ((t != null) && !(t instanceof SQLIntegrityConstraintViolationException)) {
                t = t.getCause();
            }
            if (t instanceof SQLIntegrityConstraintViolationException) {
                if (t.getMessage().endsWith("'name'")) {
                    throw new NameAlreadyRegisteredException();
                }
            }
            throw new RuntimeException(ex.getCause());
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }

        return table;
    }

    public void update(T table) {

        EntityManager entityManager = null;
        try {
            entityManager = getEntityManager();
            entityManager.getTransaction().begin();

            entityManager.merge(table);

            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            Throwable t = ex.getCause();
            while ((t != null) && !(t instanceof SQLIntegrityConstraintViolationException)) {
                t = t.getCause();
            }
            if (t instanceof SQLIntegrityConstraintViolationException) {
                if (t.getMessage().endsWith("'name'")) {
                    throw new NameAlreadyRegisteredException();
                }
            }
            throw new RuntimeException(ex.getCause());
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
    }
}
