package testesJunit;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
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
    public void teste() {
        boolean exception = false;
        try {

            String jpql = "select count(id) from Estado";
//            List<Estado> lista = em.createQuery(jpql).getResultList();            
            Long valor = (Long) em.createQuery(jpql).getSingleResult();
            System.out.println("Valor da Query: " + valor);
            
//            System.out.println("Lista: " + lista.get(0));
//            for (Estado e : lista) {
//                System.out.println("UF: " + e.getUf() + " - País: " + e.getPais().getNome());
//            }
//            String jpql = "select count(id) from Estado";
//            Query consulta = em.createQuery(jpql);
//            int quanti = (int) consulta.getSingleResult();
//            System.out.println("QUantidade de estados: " + quanti);

        } catch (Exception e) {
            exception = true;
            e.printStackTrace();
        }
        Assert.assertEquals(false, exception);
    }

}
