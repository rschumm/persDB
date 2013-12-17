package ch.saxer.persDB.service;

import ch.saxer.persDB.model.Person;

public class RefeactorPerson {

    public Person refeacotorPerson(Person person) {
        person.setName(person.getName().toUpperCase());
        return person;
    }

}
