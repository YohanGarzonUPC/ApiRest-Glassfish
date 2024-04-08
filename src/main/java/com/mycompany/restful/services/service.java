package com.mycompany.restful.services;

import com.mycompany.restful.SalarioPromedio;
import com.mycompany.restful.person;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/service")
public class service {
    private static Map<Integer,person> persons = new HashMap<>();

    static {
        int count = 0;
        for (int i = 0; i <= 10; i++) {
            person persona = new person();
            int id = i + 1;
            count++;
            persona.setId(id);
            persona.setFullName("trabajador #" + id);
            persona.setAge(new Random().nextInt(40)+1);
            persons.put(id, persona);
        }
    }

    @GET
    @Path("/getAllPersonsInJSON")
    @Produces(MediaType.APPLICATION_JSON)
    public List<person> getAllPersonsInJSON() {

        return new ArrayList<person>(persons.values());
    }

    @POST
    @Path("/addPerson")
    public List<person> addPerson(List<person> pr) {
        for (person persona : pr) {
            persons.put(persona.getId(), persona);
        }
        return new ArrayList<person>(persons.values());

    }

    @GET
    @Path("/getAllPersonsInXML")
    @Produces(MediaType.APPLICATION_XML)
    @Consumes(MediaType.APPLICATION_XML)
    public List<person> getAllPersonsInXML() {
        return new ArrayList<person>(persons.values());
    }

    @GET
    @Path("/sumaSalariosInJSON")
    @Produces(MediaType.APPLICATION_JSON)
    public double obtenerSumaSalarios() {
        double sumaSalarios = 0;
        for (person persona : persons.values()) {
            sumaSalarios += persona.calcularSalario();
        }
        return sumaSalarios;
    }


    @GET
    @Path("/PromedioSalarioInXML")
    @Produces(MediaType.APPLICATION_XML)
    public SalarioPromedio PromedioSalario() {
        int sumaSalario = 0;
        for (person persona : persons.values()) {
            sumaSalario += persona.calcularSalario();
        }
        sumaSalario=sumaSalario/persons.size();
        return new SalarioPromedio(sumaSalario);
    }
}