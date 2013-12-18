package ch.saxer.persDB.service;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;

import ch.saxer.persDB.model.Adresse;
import ch.saxer.persDB.model.Item;
import ch.saxer.persDB.model.Person;

// @DependsOn("PersService")
@Path("/r")
@RequestScoped
public class PersRESTService implements PersInterface {

    @Inject
    private Logger log;

    // @EJB
    @Inject
    private PersService persService;

    @GET
    @Path("/personen")
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public List<Person> getPersonen() {
        log.info("liste Personen");
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

}
