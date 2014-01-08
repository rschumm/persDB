package ch.saxer.persDB.service;

import java.util.List;

import ch.saxer.persDB.model.Adresse;
import ch.saxer.persDB.model.Item;
import ch.saxer.persDB.model.Person;



public interface PersInterface {

    List<Person> getPersonen();

    List<Item> getItems();

    List<Adresse> getAdressen();

    Person getPerson(String name, String vorname);
}
