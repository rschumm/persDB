package ch.saxer.persDB.service;

import java.util.List;

import ch.saxer.persDB.model.Person;


public class MainApp {

    private PersService persService = new PersService();

    public static void main(String[] args) {
        MainApp m = new MainApp();
        PersService persService = m.persService;
        List<Person> personen = persService.getAllPerson();
        String name = personen.get(0).getName();
        System.out.println(name);
    }

}
