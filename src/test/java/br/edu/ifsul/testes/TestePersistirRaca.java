
package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Raca;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author brener
 */

public class TestePersistirRaca {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("petshop-PWPU");
        EntityManager em = emf.createEntityManager();
        
        Raca r = new Raca();
        r.setNome("Persian");
        em.getTransaction().begin();
        em.persist(r);
        em.getTransaction().commit();
        
        r = new Raca();
        r.setNome("Sphynx");
        em.getTransaction().begin();
        em.persist(r);
        em.getTransaction().commit();
        
        r = new Raca();
        r.setNome("Golden Retriever");
        em.getTransaction().begin();
        em.persist(r);
        em.getTransaction().commit();
        
        r = new Raca();
        r.setNome("Husky");
        em.getTransaction().begin();
        em.persist(r);
        em.getTransaction().commit();
        
        em.getTransaction().begin();
        em.persist(r);
        em.getTransaction().commit();
        
        em.close();
        emf.close();
    }
    
}
