package ch.saxer.persDB.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

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
        return em.createQuery("SELECT x from Person x", Person.class).getResultList();

    }

    public Person getPerson(String name, String vorname) {

        log.info("getPerson " + name + " " + vorname);
        TypedQuery<Person> q = em.createQuery("SELECT x from Person x where x.name = :name and x.vorname = :vorname",
                Person.class);
        q.setParameter("name", name).setParameter("vorname", vorname);

        return q.getSingleResult();

    }

    public List<Item> getAllItems() {
        log.info("getAllItems");
        return em.createQuery("SELECT x from Item x", Item.class).getResultList();

    }

    public List<Adresse> getAllAdresse() {
        log.info("getAllAdresse");

        return em.createQuery("SELECT x from Adresse x", Adresse.class).getResultList();

    }

    public void addItem(Item item) {
        em.persist(item);
    }

    public void deleteItem(Item item) {
        em.remove(item);
    }
}
