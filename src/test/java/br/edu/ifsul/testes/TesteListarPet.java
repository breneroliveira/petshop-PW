
package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Pet;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author brener
 */

public class TesteListarPet {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("petshop-PWPU");
        EntityManager em = emf.createEntityManager();
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        
        List<Pet> lista = em.createQuery("from Pet order by id").getResultList(); // select e from Pet e...
        
        for(Pet p : lista) {
           System.out.println("\n-- ID: " + p.getId() 
                            + "\n-- Nome: " + p.getNome() 
                            + "\n-- Peso: " + p.getPeso() 
                            + "\n-- Nascimento: " + sdf.format(p.getNascimento().getTime()) 
                            + "\n-- Espécie: " + p.getEspecie() 
                            + "\n-- Raça: " + p.getRaca().getNome());
        }
        
        System.out.println("");
        
        em.close();
        emf.close();
    }   
}