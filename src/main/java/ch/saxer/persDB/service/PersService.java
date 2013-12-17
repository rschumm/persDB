package ch.saxer.persDB.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ch.saxer.persDB.model.Adresse;
import ch.saxer.persDB.model.Item;
import ch.saxer.persDB.model.Person;


@Stateless
public class PersService {

    private final static Logger LOGGER = LoggerFactory.getLogger(PersService.class);

    @PersistenceContext
    private EntityManager em;

    public List<Person> getAllPerson() {
        LOGGER.info("getAllPerson");
        return em.createQuery("SELECT x from Person x", Person.class).getResultList();

    }

    public List<Item> getAllItems() {
        LOGGER.info("getAllItems");
        return em.createQuery("SELECT x from Item x", Item.class).getResultList();

    }

    public List<Adresse> getAllAdresse() {
        LOGGER.info("getAllAdresse");

        return em.createQuery("SELECT x from Adresse x", Adresse.class).getResultList();

    }

    public Object testPersService() {
        LOGGER.info("testPersService");
        return "found";
    }

    public void addItem(Item item) {
        em.persist(item);
    }

    public void deleteItem(Item item) {
        em.remove(item);
    }
}
