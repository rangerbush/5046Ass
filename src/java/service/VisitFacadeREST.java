/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entity.fit5046.LocationAndStudent;
import entity.fit5046.Student;
import entity.fit5046.Visit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
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
@Path("entity.fit5046.visit")
public class VisitFacadeREST extends AbstractFacade<Visit> {

    @PersistenceContext(unitName = "5046AssPU")
    private EntityManager em;

    public VisitFacadeREST() {
        super(Visit.class);
    }

        @GET
@Path("findByDate/{date}")
 @Produces({"application/json"})
 public List<Visit> findByDate(@PathParam("date") java.sql.Date ln) {
 Query query = em.createNamedQuery("Visit.findByDate");
 query.setParameter("date", ln);
 return query.getResultList();
 }

         
                 @GET
@Path("findByUid/{uid}")
 @Produces({"application/json"})
 public List<Visit> findByUid(@PathParam("uid") Integer ln) {
 Query query = em.createNamedQuery("Visit.findByUid");
 query.setParameter("uid", ln);
 return query.getResultList();
 }
 
        @GET
@Path("findByLid/{lid}")
 @Produces({"application/json"})
 public List<Visit> findByLid(@PathParam("lid") Integer ln) {
 Query query = em.createNamedQuery("Visit.findByLid");
 query.setParameter("lid", ln);
 return query.getResultList();
 }
 
 @GET
@Path("VisitRecord/{sdate}/{edate}/{UID}")
 @Produces({"application/json"})
 public List<Visit> VisitRecord(@PathParam("sdate") java.sql.Date sd,@PathParam("edate") java.sql.Date ed,@PathParam("UID") Integer id) {
Query q = em.createQuery("SELECT v FROM Visit v WHERE v.date >= :sdate AND v.date <= :edate AND v.uid.id  = :UID",Visit.class);
q.setParameter("sdate", sd);
q.setParameter("edate", ed);
q.setParameter("UID", id);
return q.getResultList();   
 }
 

  @GET
@Path("WhoisNear/{UID}/{La}/{Lo}")
 @Produces({"application/json"})
 public List<LocationAndStudent> WhoisNear(@PathParam("UID") Integer ID,@PathParam("La") double la,@PathParam("Lo") double lo) {
    Query q = em.createQuery("SELECT v FROM Visit v WHERE v.uid.id != :UID",Visit.class);
q.setParameter("UID", ID);
List<Visit> list =q.getResultList();   

Iterator it = list.iterator();
List<LocationAndStudent> resultList = new ArrayList();
while(it.hasNext())
{
    Visit v = (Visit)it.next();
    double distance = Math.pow(v.getLid().getLongtitude()-lo,2)+Math.pow(v.getLid().getLatitude()-la, 2);
    resultList.add(new LocationAndStudent(v.getUid().getFirstname(),v.getUid().getLastname(),v.getLid().getLatitude(),v.getLid().getLongtitude()));
    
}
     return resultList;
 }
     
     
     
     
     
     
     
     
     
     
     
     
     /*
Query q = em.createQuery("SELECT v FROM Visit v WHERE v.uid.id != :UID",Visit.class);
q.setParameter("UID", ID);
List<Visit> list = q.getResultList();   
Iterator it = list.iterator();
List<LocationAndStudent> resultList = new ArrayList();
while(it.hasNext())
{
    Visit v = (Visit)it.next();
    v.setLati(Double.parseDouble(v.getLid().getLatitude()));
    v.setLongti(Double.parseDouble(v.getLid().getLongtitude()));
    v.setDistance(Math.pow(v.getLati()-la, 2)+Math.pow(v.getLongti()-lo, 2));
    resultList.add(new LocationAndStudent(v.getLid(),v.getUid(),v.getDistance()));
    
}
Collections.sort(resultList, new Comparator<LocationAndStudent>() {
            public int compare(LocationAndStudent s1, LocationAndStudent s2) {
                if (s1.getDistance() == s2.getDistance())
                    return 0;
                else if (s1.getDistance() > s2.getDistance())
                    return 1;
                else return -1;
                
            }
        });
return resultList;
*/

 

 
 
 
    
    
    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Visit entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, Visit entity) {
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
    public Visit find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Visit> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Visit> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
