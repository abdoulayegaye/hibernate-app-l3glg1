package org.example;

import org.example.entities.Categorie;
import org.example.entities.Produit;

import javax.persistence.*;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = managerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try{
            /*Début de transaction
            transaction.begin();
            //Creer un objet Produit
            Produit p = new Produit();
            p.setLibelleP("produit 1");
            p.setPrixP(800);
            p.setQteP(4);
            //Rechercher une catégorie via son id
            Categorie cat = entityManager.find(Categorie.class, 2);
            p.setCategorieByIdCategorie(cat);
            //Persister dans la BDD
            entityManager.persist(p);
            //Valider la transaction
            transaction.commit();*/

            /*String sql = "SELECT p FROM Produit p WHERE p.categorieByIdCategorie.nomCat = :name";
            TypedQuery<Produit> query = entityManager.createQuery(sql, Produit.class);
            query.setParameter("name", "Informatique");
            List<Produit> produits = query.getResultList();
            for (Produit p : produits){
                System.out.println(p);
            }*/

            /*TypedQuery<Produit> query = entityManager.createNamedQuery("toto", Produit.class);
            query.setParameter("tata", "Informatique");
            query.setParameter("titi", 20000);
            List<Produit> produits = query.getResultList();
            for (Produit p : produits){
                System.out.println(p);
            }*/

            TypedQuery<Produit> query = entityManager.createNamedQuery("sqlNatif", Produit.class);
            query.setParameter(1, 1);
            query.setParameter(2, 20000);
            List<Produit> produits = query.getResultList();
            for (Produit p : produits){
                System.out.println(p);
            }

        }catch (Exception e){
            if(transaction.isActive())
                transaction.rollback();
        }
        entityManager.close();
        managerFactory.close();
    }
}
