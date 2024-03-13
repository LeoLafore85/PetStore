package pet;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("petstore");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Product product = new Product();
        product.setCode("3223");
        product.setType(ProdType.FOOD);
        product.setLabel("Felix");
        product.setPrice(10.99);
        em.persist(product);

        Address petStoreAddress = new Address();
        petStoreAddress.setNumber("123");
        petStoreAddress.setStreet("Rue du PetStore");
        petStoreAddress.setZipCode("44000");
        petStoreAddress.setCity("Nantes");
        em.persist(petStoreAddress);

        PetStore petStore = new PetStore();
        petStore.setName("MonPetStore");
        petStore.setAddress(petStoreAddress);
        petStore.setManagerName("LAFORE Léo");
        em.persist(petStore);

        Fish fish1 = new Fish();
        fish1.setBirth(new Date());
        fish1.setCouleur("Rouge");
        fish1.setLivingEnv(FishLivEnv.SEA_WATER);
        em.persist(fish1);

        Cat cat1 = new Cat();
        cat1.setBirth(new Date());
        cat1.setCouleur("Bleu");
        cat1.setChipId("8379");
        em.persist(cat1);
        System.out.println("----- Animal -----");

        List<Animal> animaux = em.createQuery("SELECT a FROM Animal a", Animal.class).getResultList();
        for (Animal animal : animaux) {
            System.out.println("Animal id = " + animal.getId() + ", birth = " + animal.getBirth() + ", couleur = " + animal.getCouleur());
        }

        System.out.println("----- PetStore -----");

        List<PetStore> petStores = em.createQuery("SELECT p FROM PetStore p", PetStore.class).getResultList();
        for (PetStore p : petStores) {
            System.out.println("PetStore id = " + p.getId() + ", name = " + p.getName() + ", address = " + p.getAddress().getNumber() + " " + p.getAddress().getStreet() + ", " + p.getAddress().getCity());
        }

        System.out.println("----- Products -----");
        List<Product> productList = em.createQuery("SELECT p FROM Product p", Product.class).getResultList();
        for (Product p : productList) {
            System.out.println("Produit = " + p.getLabel() + ", au prix de : " + p.getPrice());
        }

        em.getTransaction().commit();

        em.close();
        emf.close();
    }
}