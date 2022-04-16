
package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Pet;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author brener
 */

public class TesteRemoverPet {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("petshop-PWPU");
        EntityManager em = emf.createEntityManager();
        
        Pet p = em.find(Pet.class, 3);
        
        em.getTransaction().begin();
        em.remove(p);
        em.getTransaction().commit();
        
        em.close();
        emf.close();
    }
    
}
