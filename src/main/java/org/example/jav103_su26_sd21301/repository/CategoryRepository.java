package org.example.jav103_su26_sd21301.repository;

import jakarta.persistence.EntityManager;
import org.example.jav103_su26_sd21301.entity.Category;
import org.example.jav103_su26_sd21301.utils.EntityManagerUtils;

import java.util.List;

public class CategoryRepository {

    public List<Category> getCategories() {

        try (EntityManager em = EntityManagerUtils.getEntityManager()) {

            return em.createQuery("select c from Category c", Category.class).getResultList();
        }
    }

    public Category getCategoryById(Long id) {

        try (EntityManager em = EntityManagerUtils.getEntityManager()) {
            return em.find(Category.class, id);
        }
    }
}
