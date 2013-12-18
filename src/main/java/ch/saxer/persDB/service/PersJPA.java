package ch.saxer.persDB.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;

import ch.saxer.persDB.model.Adresse;
import ch.saxer.persDB.model.Item;
import ch.saxer.persDB.model.Person;

@Stateless
public class PersJPA {

    @Inject
    private Logger log;

    @PersistenceContext
    private EntityManager em;

    public List<Person> getAllPerson() {
        log.info("getAllPerson");
        List<Person> personen = em.createQuery("SELECT x from Person x", Person.class).getResultList();
        for (Person person : personen) {
            System.out.println(person.getId() + " " + person.getName() + " " + person.getVorname() + " "
                    + person.getAdresse().getId() + " " + person.getAdresse().getOrt() + " "
                    + person.getAdresse().getPlz());
        }
        return em.createQuery("SELECT x from Person x", Person.class).getResultList();

    }

    public List<Item> getAllItems() {
        log.info("getAllItems");
        return em.createQuery("SELECT x from Item x", Item.class).getResultList();

    }

    public List<Adresse> getAllAdresse() {
        log.info("getAllAdresse");

        return em.createQuery("SELECT x from Adresse x", Adresse.class).getResultList();

    }

    public Object testPersService() {
        log.info("testPersService");
        return "found";
    }

    public void addItem(Item item) {
        em.persist(item);
    }

    public void deleteItem(Item item) {
        em.remove(item);
    }
}
