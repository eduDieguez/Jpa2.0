package dao;

import java.util.Set;
import javax.imageio.spi.ServiceRegistry;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.security.auth.login.Configuration;
import javax.validation.Constraint;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import modelo.Pais;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class AlterarPaisDAO {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("aulaJpaPU");
        EntityManager em = emf.createEntityManager();

        Pais p = em.find(Pais.class, 3);
        p.setIso("ARG");
        p.setNome("Argentina");

        em.getTransaction().begin();
        Validator validador = Validation.buildDefaultValidatorFactory().getValidator();
        Set<ConstraintViolation<Pais>> erros = validador.validate(p);
        if (erros.size() > 0) {
            for (ConstraintViolation<Pais> erro : erros) {
                System.out.println("Erro: " + erro.getMessage());
            }
        } else {
            em.merge(p);
        }
        em.getTransaction().commit();
        em.close();
        emf.close();
        System.out.println("Pais: " + p.getNome());
    }
}
