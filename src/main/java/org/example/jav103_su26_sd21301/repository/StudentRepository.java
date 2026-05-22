package org.example.jav103_su26_sd21301.repository;

import jakarta.persistence.EntityManager;
import org.example.jav103_su26_sd21301.entity.Student;
import org.example.jav103_su26_sd21301.utils.EntityManagerUtils;

import java.util.List;

public class StudentRepository {

    public List<Student> getStudents() {

        try (EntityManager em = EntityManagerUtils.getEntityManager()) {

            return em.createQuery("SELECT s from Student s", Student.class).getResultList();
        }
    }

    public void addStudent(Student student) {

        try (EntityManager em = EntityManagerUtils.getEntityManager()) {

            em.getTransaction().begin();
            em.persist(student);
            em.getTransaction().commit();
        }
    }

    public void deleteStudent(long id) {

        try (EntityManager em = EntityManagerUtils.getEntityManager()) {

            em.getTransaction().begin();

            Student student = em.find(Student.class, id);
            if (student != null) {
                em.remove(student);
            }

            em.getTransaction().commit();
        }
    }

    public Student getStudentById(Long id) {

        try (EntityManager em = EntityManagerUtils.getEntityManager()) {
            return em.find(Student.class, id);
        }
    }

    public void updateStudent(Student student) {

        try (EntityManager em = EntityManagerUtils.getEntityManager()) {

            em.getTransaction().begin();

            em.merge(student);

            em.getTransaction().commit();
        }
    }
}
