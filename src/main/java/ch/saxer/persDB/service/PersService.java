package ch.saxer.persDB.service;

import java.util.List;

import javax.inject.Inject;

import ch.saxer.persDB.model.Adresse;
import ch.saxer.persDB.model.Item;
import ch.saxer.persDB.model.Person;

public class PersService implements PersInterface {

    @Inject
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
