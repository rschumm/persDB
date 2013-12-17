package ch.saxer.persDB;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import ch.saxer.persDB.service.PersService;

import ch.saxer.persDB.model.Adresse;
import ch.saxer.persDB.model.Item;
import ch.saxer.persDB.model.Person;


@RunWith(Arquillian.class)
public class CopyOfDBTest {

    @Inject
    private PersService persService;

    @EJB
    private PersService persService2;

    private PersService persService3 = new PersService();

    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap
                .create(JavaArchive.class)
                .addClasses(PersService.class, PersService.class, Person.class, Item.class, Adresse.class,
                        EntityManager.class).addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }

    @Test
    public void testpersJPA1() {
        Assert.assertEquals("found", persService.testPersService());
    }

    @Test
    public void testpersJPA2() {
        Assert.assertEquals("found", persService2.testPersService());
    }

    @Test
    public void testpersJPA3() {
        Assert.assertEquals("found", persService3.testPersService());
    }

    @Test
    public void testTest() {
        Assert.assertEquals("test", "test");
    }

    @Test
    public void testAllPerson1() {
        Assert.assertEquals(2, persService.getAllPerson().size());
    }

    @Test
    public void testAllItems1() {
        Assert.assertEquals(1, persService.getAllItems().size());
    }

    @Test
    public void testAllAdresse1() {
        Assert.assertEquals(1, persService.getAllAdresse().size());
    }

    @Test
    public void testAllPerson2() {
        Assert.assertEquals(2, persService2.getAllPerson().size());
    }

    @Test
    public void testAllItems2() {
        Assert.assertEquals(1, persService2.getAllItems().size());
    }

    @Test
    public void testAllAdresse2() {
        Assert.assertEquals(1, persService2.getAllAdresse().size());
    }

    @Test
    public void testAllPerson3() {
        Assert.assertEquals(2, persService3.getAllPerson().size());
    }

    @Test
    public void testAllItems3() {
        Assert.assertEquals(1, persService3.getAllItems().size());
    }

    @Test
    public void testAllAdresse3() {
        Assert.assertEquals(1, persService3.getAllAdresse().size());
    }

}
