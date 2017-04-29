/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entity.fit5046.Relationship;
import entity.fit5046.RelationshipPK;
import java.util.ArrayList;
import java.util.HashSet;
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
import javax.ws.rs.core.PathSegment;

/**
 *
 * @author Ranger
 */
@Stateless
@Path("entity.fit5046.relationship")
public class RelationshipFacadeREST extends AbstractFacade<Relationship> {

    @PersistenceContext(unitName = "5046AssPU")
    private EntityManager em;

    private RelationshipPK getPrimaryKey(PathSegment pathSegment) {
        /*
         * pathSemgent represents a URI path segment and any associated matrix parameters.
         * URI path part is supposed to be in form of 'somePath;ownerid=owneridValue;targetid=targetidValue'.
         * Here 'somePath' is a result of getPath() method invocation and
         * it is ignored in the following code.
         * Matrix parameters are used as field names to build a primary key instance.
         */
        entity.fit5046.RelationshipPK key = new entity.fit5046.RelationshipPK();
        javax.ws.rs.core.MultivaluedMap<String, String> map = pathSegment.getMatrixParameters();
        java.util.List<String> ownerid = map.get("ownerid");
        if (ownerid != null && !ownerid.isEmpty()) {
            key.setOwnerid(new java.lang.Integer(ownerid.get(0)));
        }
        java.util.List<String> targetid = map.get("targetid");
        if (targetid != null && !targetid.isEmpty()) {
            key.setTargetid(new java.lang.Integer(targetid.get(0)));
        }
        return key;
    }

    public RelationshipFacadeREST() {
        super(Relationship.class);
    }

    
@GET
@Path("findByOwnerid/{ownerid}")
 @Produces({"application/json"})
 public List<Relationship> findByOwnerid(@PathParam("ownerid") Integer ln) {
 Query query = em.createNamedQuery("Relationship.findByOwnerid");
 query.setParameter("ownerid", ln);
 return query.getResultList();
 }
 
             @GET
@Path("findByTargetid/{targetid}")
 @Produces({"application/json"})
 public List<Relationship> findByTargetid(@PathParam("targetid") Integer ln) {
 Query query = em.createNamedQuery("Relationship.findByTargetid");
 query.setParameter("targetid", ln);
 return query.getResultList();
 }
 
              @GET
@Path("findByID/{id}")
 @Produces({"application/json"})
 public List<Relationship> findByID(@PathParam("id") Integer ln) {
 Query query = em.createNamedQuery("Relationship.findByID");
 query.setParameter("id", ln);
  return new ArrayList<Relationship>(new HashSet<Relationship>(query.getResultList()));
 }
 
@GET
@Path("findByEnddate/{enddate}")
 @Produces({"application/json"})
 public List<Relationship> findByEnddate(@PathParam("enddate") java.sql.Date ln) {
 Query query = em.createNamedQuery("Relationship.findByEnddate");
 query.setParameter("enddate", ln);
 return query.getResultList();
 }

@GET
@Path("searchUnisexFriends")
 @Produces({"application/json"})
 public List<Relationship> searchUnisexFriends() 
 {
 Query query = em.createNamedQuery("Relationship.searchUnisexFriends");
 return query.getResultList();
 }
 
 

    
    
    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Relationship entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") PathSegment id, Relationship entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") PathSegment id) {
        entity.fit5046.RelationshipPK key = getPrimaryKey(id);
        super.remove(super.find(key));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Relationship find(@PathParam("id") PathSegment id) {
        entity.fit5046.RelationshipPK key = getPrimaryKey(id);
        return super.find(key);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Relationship> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Relationship> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
