package com.example;
import com.example.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import java.util.List;

public class ProductMain {
    public static void main(String[] args) {
        // 1. Initialize the Hibernate Session Factory using our config file
        SessionFactory factory = new Configuration().configure().buildSessionFactory();

        // 2. Open a database communication channel
        try (Session session = factory.openSession()) {

            // Start a transaction block
            session.beginTransaction();

            System.out.println("\n--- INSERTING PRODUCTS INTO DATABASE ---");
            Product p1 = new Product("Java Programming Book", 49.99);
            Product p2 = new Product("Mechanical Keyboard", 89.50);

            // Persist (Save) objects directly to the DB without typing SQL strings
            session.persist(p1);
            session.persist(p2);

            // Commit transaction to finalize updates
            session.getTransaction().commit();

            // 3. Open a separate session to retrieve the newly saved data
            try (Session session_2 = factory.openSession()) {
                System.out.println("\n--- RETRIEVING DATA USING HQL ---");

                // HQL (Hibernate Query Language) operates on Java Class names, not SQL table names
                List<Product> products = session_2.createQuery("from Product", Product.class).list();

                for (Product product : products) {
                    System.out.println("ID: " + product.getId() + " | Item: " + product.getName() + " | Cost: $" + product.getPrice());
                }
                System.out.println("--------------------------------\n");
            } finally {
                // 4. Safely shut down the database factory pool
                factory.close();
            }
        }
    }
}
