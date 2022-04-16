
package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Raca;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author brener
 */

public class TesteRemoverRaca {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("petshop-PWPU");
        EntityManager em = emf.createEntityManager();
        
        Raca r = em.find(Raca.class, 3);
        
        em.getTransaction().begin();
        em.remove(r);
        em.getTransaction().commit();
        
        em.close();
        emf.close();
    }   
}