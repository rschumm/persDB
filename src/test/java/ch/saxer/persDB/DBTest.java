package ch.saxer.persDB;

import javax.ejb.EJB;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.jpa.Search;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.EnterpriseArchive;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ch.saxer.persDB.service.PersService;


@RunWith(Arquillian.class)
public class DBTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(DBTest.class);

    @EJB
    private PersService persService;

    @PersistenceContext
    private EntityManager em;

    @Before
    public void init() {
        // Di Hibernate Search Initialisierung kann nicht über das dafür gedachte EJB HibernateSearchInitializerBean
        // gemacht werden, da die Initialisierung sonst vor dem Schema create läuft
        FullTextEntityManager fullTextEntityManager = Search.getFullTextEntityManager(this.em);
        try {
            fullTextEntityManager.createIndexer().startAndWait();
        } catch (InterruptedException e) {
            LOGGER.error("Failed to create initial Hibernate Search Index", e);
        }
    }

    /**
     * Erstellt ein ShrinkWrapEnterprise Archive, welches von Arquillian deployed und für die Tests verwendet wird.
     * 
     * @return EnterpriseArchive EAR, welches deployed wird.
     */
    @Deployment
    public static EnterpriseArchive createTestableDeployment() {
        final JavaArchive ejb = ShrinkWrap
        //
                .create(JavaArchive.class, "persDB-ejb.jar")
                // Service & Mapper
                .addPackages(true, "ch/saxer/perDB/service")
                // Hibernate Search Initializer
                // .addClass(HibernateSearchInitializerBean.class)
                // self
                .addClass(DBTest.class)
                // wsdl & schema
                .addAsManifestResource("META-INF/wsdl", "wsdl");
        return DeploymentFactory.createTestableDeployment(ejb);
    }

    @Test
    public void testpersJPA() {
        Assert.assertEquals("found", persService.testPersService());
    }

    @Test
    public void testTest() {
        Assert.assertEquals("test", "test");
    }

    @Test
    public void testAllPerson() {
        Assert.assertEquals(2, persService.getAllPerson().size());
    }

    @Test
    public void testAllItems() {
        Assert.assertEquals(1, persService.getAllItems().size());
    }

    @Test
    public void testAllAdresse() {
        Assert.assertEquals(1, persService.getAllAdresse().size());
    }

}
