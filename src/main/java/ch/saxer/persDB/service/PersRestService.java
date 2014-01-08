package ch.saxer.persDB.service;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;

import ch.saxer.persDB.model.Adresse;
import ch.saxer.persDB.model.Item;
import ch.saxer.persDB.model.Person;

@Path("/r")
@RequestScoped
public class PersRestService implements PersInterface {

    @Inject
    private Logger log;

    @Inject
    private PersService persService;

    @GET
    @Path("/personen")
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public List<Person> getPersonen() {
        log.info("liste Personen");
        for (Person person : persService.getPersonen()) {
            System.out.println(person.getId() + " " + person.getName() + " " + person.getVorname());
        }
        return persService.getPersonen();
    }

    @GET
    @Path("/items")
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public List<Item> getItems() {
        log.info("liste Items");
        return persService.getItems();
    }

    @GET
    @Path("/adressen")
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public List<Adresse> getAdressen() {
        log.info("liste Adressen");
        return persService.getAdressen();
    }

    @GET
    @Path("/person/{vorname}/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public Person getPerson(@PathParam("name")
    String name, @PathParam("vorname")
    String vorname) {
        log.info("Person");

        return persService.getPerson(name, vorname);

    }

    @POST
    @Path("/addItem")
    @Consumes(MediaType.APPLICATION_JSON)
    @Override
    public void addItem(Item item) {
        log.info("add Item");

        persService.addItem(item);
    }

    @DELETE
    @Path("/deleteItem/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Override
    public void deleteItemWithId(@PathParam("id")
    int id) {
        log.info("delete Item");
        persService.deleteItemWithId(id);
    }
}
