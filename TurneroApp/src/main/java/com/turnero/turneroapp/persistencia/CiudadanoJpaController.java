/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.turnero.turneroapp.persistencia;

import com.turnero.turneroapp.logica.Ciudadano;
import com.turnero.turneroapp.persistencia.exceptions.NonexistentEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author pedro
 */
public class CiudadanoJpaController implements Serializable{
    
     public CiudadanoJpaController() {
        this.emf = Persistence.createEntityManagerFactory("turneroPU");
    }    
    
    public CiudadanoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Ciudadano ciudadano) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(ciudadano);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
    
     public void edit(Ciudadano ciudadano) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            ciudadano = em.merge(ciudadano);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = ciudadano.getId();
                if (findCiudadano(id) == null) {
                    throw new NonexistentEntityException("The ciudadano with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Long id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Ciudadano ciudadano;
            try {
                ciudadano = em.getReference(Ciudadano.class, id);
                ciudadano.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The ciudadano with id " + id + " no longer exists.", enfe);
            }
            em.remove(ciudadano);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Ciudadano> findCiudadanoEntities() {
        return findCiudadanoEntities(true, -1, -1);
    }

    public List<Ciudadano> findCiudadanoEntities(int maxResults, int firstResult) {
        return findCiudadanoEntities(false, maxResults, firstResult);
    }

    private List<Ciudadano> findCiudadanoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Ciudadano.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Ciudadano findCiudadano(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Ciudadano.class, id);
        } finally {
            em.close();
        }
    }

    public int getCiudadanoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Ciudadano> rt = cq.from(Ciudadano.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    //Método para comprobar que existe un ciudadano con ese DNI, utilizando Query en la base de datos
    public boolean existeCiudadanoConDNI(String dni) {
        EntityManager em = getEntityManager();
        List<Ciudadano> ciudadanos = em.createQuery("SELECT c FROM Ciudadano c", Ciudadano.class).getResultList();
        return ciudadanos.stream().anyMatch(ciudadano -> ciudadano.getDni().equals(dni));
    }
}
