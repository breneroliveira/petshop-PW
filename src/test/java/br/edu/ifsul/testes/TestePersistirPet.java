
package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Pet;
import br.edu.ifsul.modelo.Raca;
import java.util.Calendar;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author brener
 */

public class TestePersistirPet {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("petshop-PWPU");
        EntityManager em = emf.createEntityManager();
        
        Raca r = em.find(Raca.class, 1);
        Pet p = new Pet();
        
        p.setNome("White");
        p.setNascimento(Calendar.getInstance());
        p.setPeso(3.8);
        p.setRaca(r);
        p.setEspecie("Gato");
        
        em.getTransaction().begin();
        em.persist(p);
        em.getTransaction().commit();
        
        r = em.find(Raca.class, 3);
        p = new Pet();
        
        p.setNome("Koda");
        p.setNascimento(Calendar.getInstance());
        p.setPeso(12.5);
        p.setRaca(r);
        p.setEspecie("Cachorro");
        
        em.getTransaction().begin();
        em.persist(p);
        em.getTransaction().commit();
        
        em.close();
        emf.close();
    }   
}