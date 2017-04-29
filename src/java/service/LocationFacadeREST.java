/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entity.fit5046.Location;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Ranger
 */
@Stateless
@Path("entity.fit5046.location")
public class LocationFacadeREST extends AbstractFacade<Location> {

    @PersistenceContext(unitName = "5046AssPU")
    private EntityManager em;

    public LocationFacadeREST() {
        super(Location.class);
    }

    
 

        @GET
@Path("findById/{id}")
 @Produces({"application/json"})
 public List<Location> findById(@PathParam("id") Integer ln) {
 Query query = em.createNamedQuery("Location.findById");
 query.setParameter("id", ln);
 return query.getResultList();
 }
 
         @GET
@Path("findByLatitude/{latitude}")
 @Produces({"application/json"})
 public List<Location> findByLatitude(@PathParam("latitude") double ln) {
 Query query = em.createNamedQuery("Location.findByLatitude");
 query.setParameter("latitude", ln);
 return query.getResultList();
 }
 
   @GET
@Path("findByLocationname/{locationname}")
 @Produces({"application/json"})
 public List<Location> findByLocationname(@PathParam("locationname") String ln) {
 Query query = em.createNamedQuery("Location.findByLocationname");
 query.setParameter("locationname", ln);
 return query.getResultList();
 }
 
         @GET
@Path("findByLongtitude/{longtitude}")
 @Produces({"application/json"})
 public List<Location> findByLongtitude(@PathParam("longtitude") double ln) {
 Query query = em.createNamedQuery("Location.findByLongtitude");
 query.setParameter("longtitude", ln);
 return query.getResultList();
 }
 
    
    
    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Location entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, Location entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Location find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Location> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Location> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
