package com.inventario.model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

/**
 * Created by Claudio on 17/05/2015.
 */
public class JPA {

    public static EntityManagerFactory entityManagerFactory = null;
    public static ThreadLocal<JPA> local = new ThreadLocal<JPA>();
    public EntityManager entityManager;
    boolean readonly = true;
    boolean autoCommit = false;

    static JPA get() {
        if (local.get() == null) {
            try {
                throw new Exception("The JPA context is not initialized. JPA Entity Manager automatically start when one or more classes annotated with the @javax.persistence.Entity annotation are found in the application.");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return local.get();
    }

    static void clearContext() {
        local.remove();
    }

    static void createContext(EntityManager entityManager, boolean readonly) {
        if (local.get() != null) {
            try {
                local.get().entityManager.close();
            } catch (Exception e) {
                // Let's it fail
            }
            local.remove();
        }
        JPA context = new JPA();
        context.entityManager = entityManager;
        context.readonly = readonly;
        local.set(context);
    }

    // ~~~~~~~~~~~
    /*
     * Retrieve the current entityManager
     */
    public static EntityManager em() {
        return get().entityManager;
    }

    /*
     * Tell to JPA do not commit the current transaction
     */
    public static void setRollbackOnly() {
        em().getTransaction().setRollbackOnly();
    }

    /**
     * @return true if an entityManagerFactory has started
     */
    public static boolean isEnabled() {
        return entityManagerFactory != null;
    }

    /**
     * Execute a JPQL query
     */
    public static int execute(String query) {
        return em().createQuery(query).executeUpdate();
    }

    /*
     * Build a new entityManager.
     * (In most case you want to use the local entityManager with em)
     */
    public static EntityManager newEntityManager() {
        return entityManagerFactory.createEntityManager();
    }

    /**
     * @return true if current thread is running inside a transaction
     */
    public static boolean isInsideTransaction() {
        try {
            EntityManager manager = JPA.get().entityManager;
            EntityTransaction transaction = manager.getTransaction();
            return transaction != null;
        } catch (Exception e) {
            return false;
        }
    }

}
