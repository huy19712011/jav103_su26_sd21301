package org.example.jav103_su26_sd21301.repository;

import jakarta.persistence.EntityManager;
import org.example.jav103_su26_sd21301.entity.Product;
import org.example.jav103_su26_sd21301.utils.EntityManagerUtils;
import java.util.List;

public class ProductRepository {

    public List<Product> getProducts() {
        try (EntityManager em = EntityManagerUtils.getEntityManager()) {
            return em.createQuery("select p from Product p", Product.class).getResultList();
        }
    }

    public Product getProductById(Long id) {
        try (EntityManager em = EntityManagerUtils.getEntityManager()) {
            return em.find(Product.class, id);
        }
    }

    public void updateProduct(Product product) {
        try (EntityManager em = EntityManagerUtils.getEntityManager()) {
            em.getTransaction().begin();
            em.merge(product);
            em.getTransaction().commit();
        }
    }

    public void deleteProduct(long id) {
        try (EntityManager em = EntityManagerUtils.getEntityManager()) {
            em.getTransaction().begin();
            Product p = em.find(Product.class, id);
            if (p != null) {
                em.remove(p);
            }
            em.getTransaction().commit();
        }
    }

    public void addProduct(Product product) {
        try (EntityManager em = EntityManagerUtils.getEntityManager()) {
            em.getTransaction().begin();
            em.persist(product);
            em.getTransaction().commit();
        }
    }

}
