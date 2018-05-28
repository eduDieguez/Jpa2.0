
package testesJunit;

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
public class TestePersistirEstado {
    
    EntityManager em;
    
    public TestePersistirEstado() {
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
            Estado e = new Estado();
            e.setNome("Paraná");
            e.setUf("PR");
            e.setPais(em.find(Pais.class, 6));
            em.getTransaction().begin();
            em.persist(e);
            em.getTransaction().commit();
            
        } catch (Exception e) {
            exception = true;
            e.printStackTrace();
        }
        Assert.assertEquals(false, exception);
    }
    
    
}
