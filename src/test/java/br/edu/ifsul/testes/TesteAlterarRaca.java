
package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Raca;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author brener
 */

public class TesteAlterarRaca {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("petshop-PWPU");
        EntityManager em = emf.createEntityManager();
        
        Raca r = em.find(Raca.class, 1); // Encontra a Raça com determinado ID.
        r.setNome("Siamese");
        
        em.getTransaction().begin();
        em.merge(r);
        em.getTransaction().commit();
        
        em.close();
        emf.close();
    }   
}