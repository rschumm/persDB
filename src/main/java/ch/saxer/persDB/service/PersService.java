package ch.saxer.persDB.service;

import java.util.List;

import javax.ejb.DependsOn;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Named;

import ch.saxer.persDB.model.Adresse;
import ch.saxer.persDB.model.Item;
import ch.saxer.persDB.model.Person;

@DependsOn("PersJPA")
@Named
@Stateless
public class PersService implements PersInterface {

    @EJB
    PersJPA persJPA;

    public RefeactorPerson refeactorPerson;

    public PersService() {

        refeactorPerson = new RefeactorPerson();
    }

    @Override
    public List<Person> getPersonen() {
        List<Person> personen = persJPA.getAllPerson();
        for (Person p : personen) {
            p = refeactorPerson.refeacotorPerson(p);
        }
        return personen;
    }

    @Override
    public List<Item> getItems() {
        return persJPA.getAllItems();
    }

    @Override
    public List<Adresse> getAdressen() {
        return persJPA.getAllAdresse();
    }

}
