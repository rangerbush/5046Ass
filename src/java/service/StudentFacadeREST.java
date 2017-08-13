/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entity.fit5046.FUnitFrequency;
import entity.fit5046.Student;
import java.util.Date;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import net.sf.json.JSONObject;
import net.sf.json.JSONArray;
import net.sf.json.JSONException;


/**
 *
 * @author Ranger
 */
@Stateless
@Path("entity.fit5046.student")
public class StudentFacadeREST extends AbstractFacade<Student> {

    @PersistenceContext(unitName = "5046AssPU")
    private EntityManager em;

    public StudentFacadeREST() {
        super(Student.class);
    }
    
    
        @POST
    @Path("NEW")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
        public Response New(String in) {   
 Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
   Student student = gson.fromJson(in,Student.class);
Calendar c = Calendar.getInstance();
student.setRegdate(new Date(c.get(Calendar.YEAR)-1900,c.get(Calendar.MONTH),c.get(Calendar.DATE)));
try{
super.edit(student);
}
catch(IllegalArgumentException e)
{
    return Response.status(400).build();
}
return Response.status(200).build();
    }

    
    
     
        
@GET
@Path("SearchLocationNameWithSurburb/{LocName}/{surburb}")
 @Produces({"application/json"})
 public List<Student> SearchLocationAndStudent2(@PathParam("LocName") String l,@PathParam("surburb") String s) {
Query q = em.createQuery("SELECT s FROM Visit v JOIN v.uid s JOIN v.lid l WHERE s.surburb = :surburb AND l.locationname =  :LocName", Student.class);
q.setParameter("LocName", l);
q.setParameter("surburb", s);
return q.getResultList();

     
 }
 
 private String valuer(String f,Student s)
 {
     if (f ==  null)
         return "";
          if (f.equalsIgnoreCase("id")||f.equalsIgnoreCase("uid"))
             return s.getId().toString(); else
     if (f.equalsIgnoreCase("FirstName")||f.equalsIgnoreCase("fn"))
             return "\'"+s.getFirstname()+"\'"; else
        if (f.equalsIgnoreCase("Lastname")||f.equalsIgnoreCase("ln"))
           return "\'"+s.getLastname()+"\'"; else
        if (f.equalsIgnoreCase("DOB")||f.equalsIgnoreCase("dateofbirth"))
        {
            return "\'"+DateFormat.getDateInstance().format(s.getDob())+"\'";     
        } else
        if (f.trim().equalsIgnoreCase("Gender")||f.equalsIgnoreCase("sex"))
            return "\'"+s.getGender()+"\'"; else
        if (f.trim().equalsIgnoreCase("course")||f.equalsIgnoreCase("unit"))
            return "\'"+s.getCourse()+"\'"; else
        if (f.equalsIgnoreCase("ISFULLTIME")||f.equalsIgnoreCase("fulltime"))
        {
            return s.getIsfulltime().toString();
        }  else
        if (f.equalsIgnoreCase("address"))
            return "\'"+s.getAddress()+"\'"; else
        if (f.equalsIgnoreCase("surburb"))
            return "\'"+s.getSurburb()+"\'" ; else
        if (f.trim().equalsIgnoreCase("NATIONALITY"))
            return "\'"+s.getNationality()+"\'"; else
        if (f.trim().equalsIgnoreCase("NATIVELANGUAGE"))
            return "\'"+s.getNativelanguage()+"\'";
        else if (f.trim().equalsIgnoreCase("FAVORITESPORT"))
            return "\'"+s.getFavoritesport()+"\'";
        else if (f.trim().equalsIgnoreCase("FAVORITEMOVIE"))
            return "\'"+s.getFavoritemovie()+"\'";
        else if (f.trim().equalsIgnoreCase("FAVORITEUNIT"))
            return "\'"+s.getFavoriteunit()+"\'";
        else if (f.trim().equalsIgnoreCase("CURRENTJOB"))
            return "\'"+s.getCurrentjob()+"\'";
        else if (f.trim().equalsIgnoreCase("MAIL"))
            return "\'"+s.getMail()+"\'";
        else if (f.trim().equalsIgnoreCase("PASSWORD"))    
            return "\'"+s.getPassword()+"\'";
        else if (f.trim().equalsIgnoreCase("REGDATE")||f.trim().equalsIgnoreCase("registerdate"))   
        {
            return "\'"+DateFormat.getDateInstance().format(s.getRegdate())+"\'";   
        }
        else return "";
 }
 
 private String valuer2(String f,String s)
 {
     if (f ==  null)
         return "";
          if (f.equalsIgnoreCase("id")||f.equalsIgnoreCase("uid"))
             return s; else
     if (f.equalsIgnoreCase("FirstName")||f.equalsIgnoreCase("fn"))
             return "\'"+s+"\'"; else
        if (f.equalsIgnoreCase("Lastname")||f.equalsIgnoreCase("ln"))
           return "\'"+s+"\'"; else
        if (f.equalsIgnoreCase("DOB")||f.equalsIgnoreCase("dateofbirth"))
        {
            return "\'"+s+"\'";     
        } else
        if (f.trim().equalsIgnoreCase("Gender")||f.equalsIgnoreCase("sex"))
            return "\'"+s+"\'"; else
        if (f.trim().equalsIgnoreCase("course")||f.equalsIgnoreCase("unit"))
            return "\'"+s+"\'"; else
        if (f.equalsIgnoreCase("ISFULLTIME")||f.equalsIgnoreCase("fulltime"))
        {
            return s;
        }  else
        if (f.equalsIgnoreCase("address"))
            return "\'"+s+"\'"; else
        if (f.equalsIgnoreCase("surburb"))
            return "\'"+s+"\'" ; else
        if (f.trim().equalsIgnoreCase("NATIONALITY"))
            return "\'"+s+"\'"; else
        if (f.trim().equalsIgnoreCase("NATIVELANGUAGE"))
            return "\'"+s+"\'";
        else if (f.trim().equalsIgnoreCase("FAVORITESPORT"))
            return "\'"+s+"\'";
        else if (f.trim().equalsIgnoreCase("FAVORITEMOVIE"))
            return "\'"+s+"\'";
        else if (f.trim().equalsIgnoreCase("FAVORITEUNIT"))
            return "\'"+s+"\'";
        else if (f.trim().equalsIgnoreCase("CURRENTJOB"))
            return "\'"+s+"\'";
        else if (f.trim().equalsIgnoreCase("MAIL"))
            return "\'"+s+"\'";
        else if (f.trim().equalsIgnoreCase("PASSWORD"))    
            return "\'"+s+"\'";
        else if (f.trim().equalsIgnoreCase("REGDATE")||f.trim().equalsIgnoreCase("registerdate"))   
        {
            return "\'"+s+"\'";   
        }
        else return "";
 }
 
  
 //
  @GET
@Path("SearchWith2/{field1}/{value1}/{field2}/{value2}")
 @Produces({"application/json"})
 public List<Student> SearchWith2(@PathParam("field1") String f1,@PathParam("value1") String v1,@PathParam("field2") String f2,@PathParam("value2") String v2){

String i1 = (f1!=null?"  s."+f1+" = ":"");
String i2 = (f2!=null?" AND s."+f2+" = ":"");
String o1 = this.valuer2(f1, v1);
String o2 = this.valuer2(f2, v2);
Query q = em.createQuery("SELECT s FROM Student s WHERE  "+i1+o1+i2+o2, Student.class);
return q.getResultList();

     
 }
    
    
 
 //t3c
 @GET
@Path("SearchNewFriends3/{id}/{field1:.*}/{field2:.*}/{field3:.*}")
 @Produces({"application/json"})
 public List<Student> SearchNewFriends3(@PathParam("id") Integer id,@PathParam("field1") String f1,@PathParam("field2") String f2,@PathParam("field3") String f3) {
Query q = em.createQuery("SELECT s FROM Student s WHERE s.id = :id ", Student.class);
q.setParameter("id", id);
Student stu =  (Student)q.getResultList().get(0);
String v1 = this.valuer(f1, stu);
String v2 = this.valuer(f2, stu);
String v3 = this.valuer(f3, stu);
String i1 = (f1!=null&&!f1.equalsIgnoreCase("")?" AND s."+f1+" = ":"");
String i2 = (f2!=null&&!f2.equalsIgnoreCase("")?" AND s."+f2+" = ":"");
String i3 = (f3!=null&&!f3.equalsIgnoreCase("")?" AND s."+f3+" = ":"");
v1 = (i1.equalsIgnoreCase("")?"":v1);
v2 = (i1.equalsIgnoreCase("")?"":v2);
v3 = (i1.equalsIgnoreCase("")?"":v3);
q = em.createQuery("SELECT s FROM Student s WHERE s.id != :id "+i1+v1+i2+v2+i3+v3, Student.class);
q.setParameter("id", id);
return q.getResultList();

     
 }
 
  //test
 @GET
@Path("test")
 @Produces({"application/json"})
 public List<Student> Stest() {
Query q = em.createQuery("SELECT s FROM Student s WHERE s.id = 27658997 AND s.dob = '1990-12-8'", Student.class);
return q.getResultList();

     
 }
 
 //T3d
  @GET
@Path("SearchNewFriends11/{id}/{field1:.*}/{field2:.*}/{field3:.*}/{field4:.*}/{field5:.*}/{field6:.*}/{field7:.*}/{field8:.*}/{field9:.*}/{field10:.*}/{field11:.*}")
 @Produces({"application/json"})
 public List<Student> SearchNewFriends11(@PathParam("id") Integer id,@PathParam("field1") String f1,@PathParam("field2") String f2,@PathParam("field3") String f3,@PathParam("field4") String f4,@PathParam("field5") String f5,@PathParam("field6") String f6,@PathParam("field7") String f7,@PathParam("field8") String f8,@PathParam("field9") String f9,@PathParam("field10") String f10,@PathParam("field11") String f11){
Query q = em.createQuery("SELECT s FROM Student s WHERE s.id = :id ", Student.class);
q.setParameter("id", id);
Student stu =  (Student)q.getResultList().get(0);

String v1 = this.valuer(f1, stu);
String v2 = this.valuer(f2, stu);
String v3 = this.valuer(f3, stu);
String v4 = this.valuer(f4, stu);
String v5 = this.valuer(f5, stu);
String v6 = this.valuer(f6, stu);
String v7 = this.valuer(f7, stu);
String v8 = this.valuer(f8, stu);
String v9 = this.valuer(f9, stu);
String v10 = this.valuer(f10, stu);
String v11 = this.valuer(f11, stu);
String i1 = (f1!=null&&!f1.equalsIgnoreCase("")?" AND s."+f1+" = ":"");
String i2 = (f2!=null&&!f2.equalsIgnoreCase("")?" AND s."+f2+" = ":"");
String i3 = (f3!=null&&!f3.equalsIgnoreCase("")?" AND s."+f3+" = ":"");
String i4 = (f4!=null&&!f4.equalsIgnoreCase("")?" AND s."+f4+" = ":"");
String i5 = (f5!=null&&!f5.equalsIgnoreCase("")?" AND s."+f5+" = ":"");
String i6 = (f6!=null&&!f6.equalsIgnoreCase("")?" AND s."+f6+" = ":"");
String i7 = (f7!=null&&!f7.equalsIgnoreCase("")?" AND s."+f7+" = ":"");
String i8 = (f8!=null&&!f8.equalsIgnoreCase("")?" AND s."+f8+" = ":"");
String i9 = (f9!=null&&!f9.equalsIgnoreCase("")?" AND s."+f9+" = ":"");
String i10 = (f10!=null&&!f10.equalsIgnoreCase("")?" AND s."+f10+" = ":"");
String i11 = (f11!=null&&!f11.equalsIgnoreCase("")?" AND s."+f11+" = ":"");
v1 = (i1.equalsIgnoreCase("")?"":v1);
v2 = (i2.equalsIgnoreCase("")?"":v2);
v3 = (i3.equalsIgnoreCase("")?"":v3);
v4 = (i4.equalsIgnoreCase("")?"":v4);
v5 = (i5.equalsIgnoreCase("")?"":v5);
v6 = (i6.equalsIgnoreCase("")?"":v6);
v7 = (i7.equalsIgnoreCase("")?"":v7);
v8 = (i8.equalsIgnoreCase("")?"":v8);
v9 = (i9.equalsIgnoreCase("")?"":v9);
v10 = (i10.equalsIgnoreCase("")?"":v10);
v11 = (i11.equalsIgnoreCase("")?"":v11);


q = em.createQuery("SELECT s FROM Student s WHERE s.id != :id "+i1+v1+i2+v2+i3+v3+i4+v4+i5+v5+i6+v6+i7+v7+i8+v8+i9+v9+i10+v10+i11+v11, Student.class);
q.setParameter("id", id);
return q.getResultList();

     
 }
    
    
    
  //t3e
 @GET
@Path("FavorUnit")
 @Produces({"application/json"})
 public FUnitFrequency fUnit() {
Query q = em.createQuery("SELECT s FROM Student s ", Student.class);
Iterator it = q.getResultList().iterator();
FUnitFrequency fU = new FUnitFrequency();
while(it.hasNext())
{
    fU.add(((Student)it.next()).getFavoriteunit());
}
return fU;
     
 }
    
    
    
    
    
    
//-----------------------------------------
@GET
@Path("findBy2/{field1}/{field2}/{value1}/{value2}")
@Produces({"application/json"})
public List<Student> findBy2(@PathParam("field1") String f1,@PathParam("field2") String f2,@PathParam("value1") String v1,@PathParam("value2") String v2) {
         List<Student> answer = new ArrayList();
    try   
    {   
        List<Student> r1 = this.processor(f1, v1);  
        List<Student> r2 = this.processor(f2, v2); 
           
       for (Iterator it1 = r1.iterator();it1.hasNext();)
       {
           Student s = (Student)(it1.next());
           if (r2.contains(s))
               answer.add(s);
       }
    }
    catch (SecurityException e)
    {
        System.out.println("Warning: exception caught. -->>>  "+e.getMessage());
    }
       return answer;
}

@GET
@Path("findBy1/{field1}/{value1}")
@Produces({"application/json"})
public List<Student> findBy1(@PathParam("field1") String f1,@PathParam("value1") String v1) {
         List<Student> answer = new ArrayList();
    try   
    {   
        List<Student> r1 = this.processor(f1, v1);  
        answer = r1;
    }
    catch (SecurityException e)
    {
        System.out.println("Warning: exception caught. -->>>  "+e.getMessage());
    }
    finally
    {
       return answer;
    }
}

/*
@Param String f: field type
@Param String v: field value
Identify field type and process a query on given value based on recongnized type.
For full time, any input value other than "true" or "1" will be accpeted as false.
*/
private List<Student> processor(String f,String v) throws SecurityException
{
        if (f.equalsIgnoreCase("FirstName")||f.equalsIgnoreCase("fn"))
             return this.findByFN(v); else
        if (f.equalsIgnoreCase("Lastname")||f.equalsIgnoreCase("ln"))
            return this.findByLN(v); else
        if (f.equalsIgnoreCase("DOB")||f.equalsIgnoreCase("dateofbirth"))
        {
            return this.findByDOB(java.sql.Date.valueOf(v));        
        } else
        if (f.trim().equalsIgnoreCase("Gender")||f.equalsIgnoreCase("sex"))
            return this.findByGender(v); else
        if (f.trim().equalsIgnoreCase("course")||f.equalsIgnoreCase("unit"))
            return this.findByCourse(v); else
        if (f.equalsIgnoreCase("ISFULLTIME")||f.equalsIgnoreCase("fulltime"))
        {
            return this.findByIsfulltime(v.equalsIgnoreCase("true")||v.equalsIgnoreCase("1"));
        }  else
        if (f.equalsIgnoreCase("address"))
            return this.findByAddress(v); else
        if (f.equalsIgnoreCase("surburb"))
            return this.findBySurburb(v) ; else
        if (f.trim().equalsIgnoreCase("NATIONALITY"))
            return this.findByNationality(v); else
        if (f.trim().equalsIgnoreCase("NATIVELANGUAGE"))
            return this.findByNativelanguage(v);
        else if (f.trim().equalsIgnoreCase("FAVORITESPORT"))
            return this.findByFavoritesport(v);
        else if (f.trim().equalsIgnoreCase("FAVORITEMOVIE"))
            return this.findByFavoritemovie(v);
        else if (f.trim().equalsIgnoreCase("FAVORITEUNIT"))
            return this.findByFavoriteunit(v);
        else if (f.trim().equalsIgnoreCase("CURRENTJOB"))
            return this.findByCurrentjob(v);
        else if (f.trim().equalsIgnoreCase("MAIL"))
            return this.findByMail(v);
        else if (f.trim().equalsIgnoreCase("PASSWORD"))    
            return this.findByPassword(v);
        else if (f.trim().equalsIgnoreCase("REGDATE")||f.trim().equalsIgnoreCase("registerdate"))   
        {
            return this.findByRegdate(java.sql.Date.valueOf(v));
        }
        else return new ArrayList<Student>();
            
}
    
  //-------------------------------------------  
    
@GET
@Path("findByStudname/{id}")
 @Produces({"application/json"})
 public List<Student> findByID(@PathParam("id") Integer id) {
 Query query = em.createNamedQuery("Student.findById");
 query.setParameter("id", id);
 return query.getResultList();
 }
 
 @GET
@Path("findByFirstName/{firstname}")
 @Produces({"application/json"})
 public List<Student> findByFN(@PathParam("firstname") String fn) {
 Query query = em.createNamedQuery("Student.findByFirstname");
 query.setParameter("firstname", fn);
 return query.getResultList();
 }
 
  @GET
@Path("findByLastName/{lastname}")
 @Produces({"application/json"})
 public List<Student> findByLN(@PathParam("lastname") String ln) {
 Query query = em.createNamedQuery("Student.findByLastname");
 query.setParameter("lastname", ln);
 return query.getResultList();
 }
 
   @GET
@Path("findByDOB/{dob}")
 @Produces({"application/json"})
 public List<Student> findByDOB(@PathParam("dob") java.sql.Date dob) {
 Query query = em.createNamedQuery("Student.findByDob");
 query.setParameter("dob", dob);
 return query.getResultList();
 }
 
   @GET
@Path("findByGender/{gender}")
 @Produces({"application/json"})
 public List<Student> findByGender(@PathParam("gender") String ln) {
 Query query = em.createNamedQuery("Student.findByGender");
 query.setParameter("gender", ln);
 return query.getResultList();
 }
 
    @GET
@Path("findByCourse/{course}")
 @Produces({"application/json"})
 public List<Student> findByCourse(@PathParam("course") String ln) {
 Query query = em.createNamedQuery("Student.findByCourse");
 query.setParameter("course", ln);
 return query.getResultList();
 }
 
@GET
@Path("findByIsfulltime/{isfulltime}")
 @Produces({"application/json"})
 public List<Student> findByIsfulltime(@PathParam("isfulltime") Boolean ln) {
 Query query = em.createNamedQuery("Student.findByIsfulltime");
 query.setParameter("isfulltime", ln);
 return query.getResultList();
 }
 
 @GET
@Path("findByAddress/{address}")
 @Produces({"application/json"})
 public List<Student> findByAddress(@PathParam("address") String ln) {
 Query query = em.createNamedQuery("Student.findByAddress");
 query.setParameter("address", ln);
 return query.getResultList();
 }
 
  @GET
@Path("findBySurburb/{surburb}")
 @Produces({"application/json"})
 public List<Student> findBySurburb(@PathParam("surburb") String ln) {
 Query query = em.createNamedQuery("Student.findBySurburb");
 query.setParameter("surburb", ln);
 return query.getResultList();
 }

  @GET
@Path("findByNationality/{nationality}")
 @Produces({"application/json"})
 public List<Student> findByNationality(@PathParam("nationality") String ln) {
 Query query = em.createNamedQuery("Student.findByNationality");
 query.setParameter("nationality", ln);
 return query.getResultList();
 }
 
@GET
@Path("findByNativelanguage/{nativelanguage}")
 @Produces({"application/json"})
 public List<Student> findByNativelanguage(@PathParam("nativelanguage") String ln) {
 Query query = em.createNamedQuery("Student.findByNativelanguage");
 query.setParameter("nativelanguage", ln);
 return query.getResultList();
 }
 
 @GET
@Path("findByFavoritesport/{favoritesport}")
 @Produces({"application/json"})
 public List<Student> findByFavoritesport(@PathParam("favoritesport") String ln) {
 Query query = em.createNamedQuery("Student.findByFavoritesport");
 query.setParameter("favoritesport", ln);
 return query.getResultList();
 }
 
  @GET
@Path("findByFavoritemovie/{favoritemovie}")
 @Produces({"application/json"})
 public List<Student> findByFavoritemovie(@PathParam("favoritemovie") String ln) {
 Query query = em.createNamedQuery("Student.findByFavoritemovie");
 query.setParameter("favoritemovie", ln);
 return query.getResultList();
 }
 
   @GET
@Path("findByFavoriteunit/{favoriteunit}")
 @Produces({"application/json"})
 public List<Student> findByFavoriteunit(@PathParam("favoriteunit") String ln) {
 Query query = em.createNamedQuery("Student.findByFavoriteunit");
 query.setParameter("favoriteunit", ln);
 return query.getResultList();
 }
 
    @GET
@Path("findByCurrentjob/{currentjob}")
 @Produces({"application/json"})
 public List<Student> findByCurrentjob(@PathParam("currentjob") String ln) {
 Query query = em.createNamedQuery("Student.findByCurrentjob");
 query.setParameter("currentjob", ln);
 return query.getResultList();
 }
 
    @GET
@Path("findByMail/{mail}")
 @Produces({"application/json"})
 public List<Student> findByMail(@PathParam("mail") String ln) {
 Query query = em.createNamedQuery("Student.findByMail");
 query.setParameter("mail", ln);
 return query.getResultList();
 }
 
    @GET
@Path("findByPassword/{password}")
 @Produces({"application/json"})
 public List<Student> findByPassword(@PathParam("password") String ln) {
 Query query = em.createNamedQuery("Student.findByPassword");
 query.setParameter("password", ln);
 return query.getResultList();
 }
 
 
 
    @GET
@Path("findByRegdate/{regdate}")
 @Produces({"application/json"})
 public List<Student> findByRegdate(@PathParam("regdate") Date ln) {
 Query query = em.createNamedQuery("Student.findByRegdate");
 query.setParameter("regdate", ln);
 return query.getResultList();
 }
/* 
    @GET
@Path("VisitRecord/{id}")
 @Produces({"application/json"})
 public List<Student> VisitRecord(@PathParam("id") Integer ln) {
 Query query = em.createNamedQuery("Student.VisitRecord");
 query.setParameter("id", ln);
 return query.getResultList();
 }
 */
 

    
    
    
    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Student entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, Student entity) {
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
    public Student find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
      @Path("findAll")
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Student> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Student> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
