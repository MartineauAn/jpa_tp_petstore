package fr.epsi.b3.c1;

import fr.epsi.b3.c1.entity.*;
import fr.epsi.b3.c1.enums.FishLivEnv;
import fr.epsi.b3.c1.enums.ProdType;

import javax.persistence.*;
import java.time.Instant;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu-pet");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();

        ajouterPetStores(em);

        getAnimalsPetstore(em,1);
        getAnimalsPetstore(em,2);
        getAnimalsPetstore(em,3);

        et.commit();
        em.close();
        emf.close();
    }

    public static void ajouterPetStores(EntityManager em){
        PetStore petStore1 = new PetStore("PetStore 1", "Gustavo FRING", new Adresse(6353, "Juan Tabo","NM 87111","Albuquerque"));
        PetStore petStore2 = new PetStore("PetStore 2", "Walter WHITE", new Adresse(6353, "Juan Tabo","NM 87111","Albuquerque"));
        PetStore petStore3 = new PetStore("PetStore 3", "Mike ERHMANTRAUT", new Adresse(6353, "Juan Tabo","NM 87111","Albuquerque"));

        em.persist(petStore1);
        em.persist(petStore2);
        em.persist(petStore3);

        ajouterProduits(em, petStore1, petStore2, petStore3);

        ajouterAnimaux(em, petStore1, petStore2, petStore3);
    }

    public static void ajouterProduits(EntityManager em,PetStore petStore1, PetStore petStore2, PetStore petStore3){
        Product product1 = new Product("#0001","croquettes", ProdType.FOOD,9.99);
        Product product2 = new Product("#0002","Collier", ProdType.ACCESSORY,29.99);
        Product product3 = new Product("#0003","Lingettes", ProdType.CLEANING,2.5);

        product1.addPetStore(petStore1);
        product1.addPetStore(petStore3);

        product2.addPetStore(petStore3);

        product3.addPetStore(petStore1);
        product3.addPetStore(petStore2);
        product3.addPetStore(petStore3);

        em.persist(product1);
        em.persist(product2);
        em.persist(product3);
    }

    public static void ajouterAnimaux(EntityManager em, PetStore petStore1, PetStore petStore2, PetStore petStore3){
        AbstractAnimal cat1 = new Cat(Date.from(Instant.now()),"noir et orange","0001");
        AbstractAnimal cat2 = new Cat(Date.from(Instant.now()),"vert et bleu","0002");
        AbstractAnimal cat3 = new Cat(Date.from(Instant.now()),"rose fluo","0003");

        AbstractAnimal fish1 = new Fish(Date.from(Instant.now()), "bleu", FishLivEnv.SEA_WATER);
        AbstractAnimal fish2 = new Fish(Date.from(Instant.now()), "marron", FishLivEnv.FRESH_WATER);
        AbstractAnimal fish3 = new Fish(Date.from(Instant.now()), "jaune fluo", FishLivEnv.SEA_WATER);

        petStore1.addAnimal(cat1);
        petStore1.addAnimal(fish1);
        petStore1.addAnimal(fish2);

        petStore2.addAnimal(cat2);
        petStore2.addAnimal(cat3);

        petStore3.addAnimal(fish3);

        em.persist(cat1);
        em.persist(cat2);
        em.persist(cat3);
        em.persist(fish1);
        em.persist(fish2);
        em.persist(fish3);
    }

    public static void getAnimalsPetstore(EntityManager em, Integer id){
        TypedQuery<AbstractAnimal> query = em.createQuery("select a from AbstractAnimal a where a.petStore = " + id, AbstractAnimal.class);
        System.out.println();
        System.out.println(query.getResultList());
        System.out.println();
    }
}