package ch.saxer.persDB;

import org.junit.Assert;
import org.junit.Test;

import ch.saxer.persDB.service.RefeactorPerson;

import ch.saxer.persDB.model.Person;




public class BusinessLogic {

    @Test
    public void testRefeactorPerson() {
        RefeactorPerson refeactorPerson = new RefeactorPerson();
        Assert.assertEquals("SAXER", refeactorPerson.refeacotorPerson(new Person("saxer")).getName());
    }
}
