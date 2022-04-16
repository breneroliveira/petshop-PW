
package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Raca;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author brener
 */

public class TesteListarRaca {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("petshop-PWPU");
        EntityManager em = emf.createEntityManager();
        
        List<Raca> lista = em.createQuery("from Raca order by id").getResultList(); // select e from Raça e...
        
        for(Raca r : lista) {
           System.out.println("\n-- ID: " + r.getId() 
                            + "\n-- Nome: " + r.getNome());
        }
        
        System.out.println("");
        
        em.close();
        emf.close();
    }
}