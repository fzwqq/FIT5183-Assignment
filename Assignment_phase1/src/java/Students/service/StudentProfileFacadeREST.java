/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Students.service;

import Students.StudentProfile;
import Students.Friendship;
import Students.Location;
import java.sql.Date;
import java.sql.Time;
import java.util.List;
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
import javax.ws.rs.core.MediaType;

/**
 *
 * @author analysis.jinger
 */
@Stateless
@Path("students.studentprofile")
public class StudentProfileFacadeREST extends AbstractFacade<StudentProfile> {

    @PersistenceContext(unitName = "AssignmentsPU")
    private EntityManager em;

    public StudentProfileFacadeREST() {
        super(StudentProfile.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(StudentProfile entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, StudentProfile entity) {
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
    public StudentProfile find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<StudentProfile> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<StudentProfile> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }
    
    @GET
    @Path("findByFirstname/{firstname}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<StudentProfile> findByFirstname(@PathParam("firstname")  String firstname) {
        Query query = em.createNamedQuery("StudentProfile.findByFirstname");
        query.setParameter("firstname", firstname );
        return query.getResultList();
    }
    
    @GET
    @Path("findBySurname/{surname}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<StudentProfile> findBySurname(@PathParam("surname")  String surname) {
        Query query = em.createNamedQuery("StudentProfile.findBySurname");
        query.setParameter("surname", surname );
        return query.getResultList();
    }
    
    @GET
    @Path("findByGender/{gender}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<StudentProfile> findByGender(@PathParam("gender")  String gender) {
        Query query = em.createNamedQuery("StudentProfile.findByGender");
        query.setParameter("gender", gender );
        return query.getResultList();
    }
//    !!!
    @GET
    @Path("findByDob/{dob}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<StudentProfile> findByDob(@PathParam("dob")  Date dob) {
        Query query = em.createNamedQuery("StudentProfile.findByDob");
        query.setParameter("dob", dob );
        return query.getResultList();
    }
    
    @GET
    @Path("findByCourse/{course}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<StudentProfile> findByCourse(@PathParam("course")  String course) {
        Query query = em.createNamedQuery("StudentProfile.findByCourse");
        query.setParameter("course", course );
        return query.getResultList();
    }
    
    @GET
    @Path("findByStudymode/{studymode}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<StudentProfile> findByStudymode(@PathParam("studymode")  String studymode) {
        Query query = em.createNamedQuery("StudentProfile.findByStudymode");
        query.setParameter("studymode", studymode );
        return query.getResultList();
    }
    
    @GET
    @Path("findByAddress/{address}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<StudentProfile> findByAddress(@PathParam("address")  String address) {
        Query query = em.createNamedQuery("StudentProfile.findByAddress");
        query.setParameter("address", address );
        return query.getResultList();
    }
    
    @GET
    @Path("findById/{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<StudentProfile> findById(@PathParam("id")  Integer id) {
        Query query = em.createNamedQuery("StudentProfile.findById");
        query.setParameter("id", id );
        return query.getResultList();
    }
    
    @GET
    @Path("findBySuburb/{suburb}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<StudentProfile> findBySuburb(@PathParam("suburb")  String suburb) {
        Query query = em.createNamedQuery("StudentProfile.findBySuburb");
        query.setParameter("suburb", suburb );
        return query.getResultList();
    }
    
    @GET
    @Path("findByNationnality/{nationnality}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<StudentProfile> findByNationnality(@PathParam("nationnality")  String nationnality) {
        Query query = em.createNamedQuery("StudentProfile.findByNationnality");
        query.setParameter("nationnality", nationnality );
        return query.getResultList();
    }
    
    @GET
    @Path("findByNativelanguage/{nativelanguage}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<StudentProfile> findByNativelanguage(@PathParam("nativelanguage")  String nativelanguage) {
        Query query = em.createNamedQuery("StudentProfile.findByNativelanguage");
        query.setParameter("nativelanguage", nativelanguage );
        return query.getResultList();
    }
    
    @GET
    @Path("findByFsport/{fsport}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<StudentProfile> findByFsport(@PathParam("fsport")  String fsport) {
        Query query = em.createNamedQuery("StudentProfile.findByFsport");
        query.setParameter("fsport", fsport );
        return query.getResultList();
    }
    
    @GET
    @Path("findByFmovie/{fmovie}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<StudentProfile> findByFmovie(@PathParam("fmovie")  String fmovie) {
        Query query = em.createNamedQuery("StudentProfile.findByFmovie");
        query.setParameter("fmovie", fmovie );
        return query.getResultList();
    }
    
    @GET
    @Path("findByFunit/{funit}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<StudentProfile> findByFunit(@PathParam("funit")  String funit) {
        Query query = em.createNamedQuery("StudentProfile.findByFunit");
        query.setParameter("funit", funit );
        return query.getResultList();
    }
    
    @GET
    @Path("findByCurrentjob/{currentjob}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<StudentProfile> findByCurrentjob(@PathParam("currentjob")  String currentjob) {
        Query query = em.createNamedQuery("StudentProfile.findByCurrentjob");
        query.setParameter("currentjob", currentjob );
        return query.getResultList();
    }
    
    @GET
    @Path("findByEmail/{email}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<StudentProfile> findByEmail(@PathParam("email")  String email) {
        Query query = em.createNamedQuery("StudentProfile.findByEmail");
        query.setParameter("email", email );
        return query.getResultList();
    }
    
    @GET
    @Path("findByPassword/{password}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<StudentProfile> findByPassword(@PathParam("password")  String password) {
        Query query = em.createNamedQuery("StudentProfile.findByPassword");
        query.setParameter("password", password );
        return query.getResultList();
    }
    
    @GET
    @Path("findBySubdata/{subdata}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<StudentProfile> findBySubdata(@PathParam("subdata")  Date subdata) {
        Query query = em.createNamedQuery("StudentProfile.findBySubdata");
        query.setParameter("subdata", subdata );
        return query.getResultList();
    }
    
    @GET
    @Path("findBySubtime/{subtime}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<StudentProfile> findBySubtime(@PathParam("subtime")  Time subtime) {
        Query query = em.createNamedQuery("StudentProfile.findBySubtime");
        query.setParameter("subtime", subtime );
        return query.getResultList();
    }
    
 
    @GET
    @Path("findByFirstNameAndSurName/{firstname}/{surname}" )
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<StudentProfile> findByFirstNameAndSurName(@PathParam("firstname") String firstname , @PathParam("surname") String surname){
        TypedQuery<StudentProfile> q =  (TypedQuery<StudentProfile>) em.createQuery("SELECT s FROM StudentProfile s WHERE s.firstname = :firstname AND s.surname = :surname");
        q.setParameter("firstname", firstname);
        q.setParameter("surname", surname);
        return q.getResultList();
    }
    
//    @GET
//    @Path("findByTest")
//    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
//    public List<StudentProfile> findByTest() {
//        TypedQuery<StudentProfile>q = (TypedQuery<StudentProfile>) em.createQuery("SELECT * from student_profile s , friendship f \n" +
//"where s.ID = f.FSTU1_ID And f.FRIENDSHIPSTATUS = true ") ;
//        return q.getResultList();
//    }
//     
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
