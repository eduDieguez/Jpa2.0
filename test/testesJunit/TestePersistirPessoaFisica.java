
package testesJunit;

import java.util.Calendar;
import javax.persistence.EntityManager;
import jpa.EntityManagerUtil;
import junit.framework.Assert;
import modelo.Estado;
import modelo.Pais;
import modelo.PessoaFisica;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author edudieguez
 */
public class TestePersistirPessoaFisica {
    
    EntityManager em;
    
    public TestePersistirPessoaFisica() {
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
            PessoaFisica pf = new PessoaFisica();
            pf.setCpf("669.259.449-93");
            pf.setEmail("meuemail@email.com.br");
            pf.setFone("46 9 9909-9126");
            pf.setNascimento(Calendar.getInstance());
            pf.setNome("Edu Dieguez");
            pf.setNomeUsuario("Dieguez");
            pf.setRg("15.143.531-5");
            pf.setSenha("123456");
            
            
            em.getTransaction().begin();
            em.persist(pf);
            em.getTransaction().commit();
            
        } catch (Exception e) {
            exception = true;
            e.printStackTrace();
        }
        Assert.assertEquals(false, exception);
    }
    
    
}
