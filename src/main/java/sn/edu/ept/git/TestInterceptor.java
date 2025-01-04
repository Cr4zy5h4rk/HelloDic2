package sn.edu.ept.git;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import sn.edu.ept.git.entities.Carte;
import sn.edu.ept.git.entities.Etudiant;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class TestInterceptor {
    public static void main(String[] args) {
        System.out.printf("Hello and welcome!");

        EntityManagerFactory emf= Persistence
                .createEntityManagerFactory("dic2Pu");
        EntityManager em = emf.createEntityManager();

        Etudiant touba = Etudiant.builder()
                .nom("touba")
                .prenom("Ali")
                .build();
//        System.out.println("####" + toubaCarte.getDateCreation);

        Carte toubaCarte = Carte.builder()
                        .code("ddk")
                        .etudiant(touba)
                        .dateDebut(new GregorianCalendar(2024, Calendar.OCTOBER, 1).getTime())
                        .dateFin(new GregorianCalendar(2025, Calendar.DECEMBER, 8).getTime())
                        .build();

        em.getTransaction().begin();
        em.persist(touba);
//        System.out.println("####" + toubaCarte.getDateCreation); à revoir

        em.persist(toubaCarte);
        em.getTransaction().commit();

        em.close();
        emf.close();


    }
}