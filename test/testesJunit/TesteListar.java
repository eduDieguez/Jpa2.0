
package testesJunit;

import java.util.List;
import javax.persistence.EntityManager;
import jpa.EntityManagerUtil;
import junit.framework.Assert;
import modelo.Estado;
import modelo.Pais;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author edudieguez
 */
public class TesteListar {
    
    EntityManager em;
    
    public TesteListar() {
    }
    
    @Before
    public void setUp() {
        em = EntityManagerUtil.getEM();
    }
    
    @After
    public void tearDown() {
        EntityManagerUtil.closeFactory_EM();
    }
    
    @Test
    public void teste(){
        boolean exception = false;
        try {

            String jpql = "from Estado order by nome";
            List<Estado> lista = em.createQuery(jpql).getResultList();
            for (Estado e : lista) {
                System.out.println("UF: "+ e.getUf()+ " - País: "+ e.getPais().getNome());
            }
            
            
            
        } catch (Exception e) {
            exception = true;
            e.printStackTrace();
        }
        Assert.assertEquals(false, exception);
    }
    
    
}
