/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Students.service;

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
@Path("students.location")
public class LocationFacadeREST extends AbstractFacade<Location> {

    

    @PersistenceContext(unitName = "AssignmentsPU")
    private EntityManager em;

    public LocationFacadeREST() {
        super(Location.class);
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
    public void edit(@PathParam("id") String id, Location entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") String id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Location find(@PathParam("id") String id) {
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

    @GET
    @Path("findByLatitude/{latitude}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Location> findByLatitude(@PathParam("latitude")  Integer latitude) {
        Query query = em.createNamedQuery("Location.findByLatitude");
        query.setParameter("latitude", latitude );
        return query.getResultList();
    }
    
    @GET
    @Path("findByLongitude/{longitude}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Location> findByLongitude(@PathParam("longitude")  Integer longitude) {
        Query query = em.createNamedQuery("Location.findByLongitude");
        query.setParameter("longitude", longitude );
        return query.getResultList();
    }
    
    @GET
    @Path("findByData/{data}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Location> findByData(@PathParam("data")  Date data) {
        Query query = em.createNamedQuery("Location.findByData");
        query.setParameter("data", data );
        return query.getResultList();
    }
    
    @GET
    @Path("findByTime/{time}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Location> findByTime(@PathParam("time")  Time time) {
        Query query = em.createNamedQuery("Location.findByTime");
        query.setParameter("time", time );
        return query.getResultList();
    }
    
    @GET
    @Path("findByPlace/{place}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Location> findByPlace(@PathParam("place")  String place) {
        Query query = em.createNamedQuery("Location.findByPlace");
        query.setParameter("place", place );
        return query.getResultList();
    }
    
    @GET
    @Path("findByLstuId/{lstuId}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Location> findByLstuId(@PathParam("lstuId")  Integer lstuId) {
        Query query = em.createNamedQuery("Location.findByLstuId");
        query.setParameter("lstuId", lstuId );
        return query.getResultList();
    }
    
    @GET
    @Path("findByStatus/{status}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Location> findByStatus(@PathParam("status")  Boolean status) {
        Query query = em.createNamedQuery("Location.findByStatus");
        query.setParameter("status", status );
        return query.getResultList();
    }
    
    @GET
    @Path("findByIdDataLl/{idDataLl}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Location> findByIdDataLl(@PathParam("idDataLl")  String idDataLl) {
        Query query = em.createNamedQuery("Location.findByIdDataLl");
        query.setParameter("idDataLl", idDataLl );
        return query.getResultList();
    }
    
    // implict join
    @GET
    @Path("findByFirstName/{firstname}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Location> findByFirstName(@PathParam("firstname") String firstname ) {
        TypedQuery<Location>q = (TypedQuery<Location>) em.createQuery("SELECT l FROM Location l WHERE l.stuId.firstname = :firstname") ;
        q.setParameter("firstname", firstname);
        return q.getResultList();
    }    
    
    @GET
    @Path("Test/{sdata}/{edata}")
//    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public String Test(@PathParam("sdata") Date sdata , @PathParam ("edata") Date edata) {
        Query q =  em.createQuery("SELECT l FROM Location l WHERE l.data <= :edata AND l.data >= :sdata   ") ;
        q.setParameter("sdata", sdata);
        q.setParameter("edata", edata);
        System.out.println(q.getResultList().toString()) ;
        return q.getResultList().toString();
    } 
    
      public  List  TesT() {
        Query q =  em.createQuery("SELECT l FROM Location l WHERE l.data <= :edata AND l.data >= :sdata   ") ;
        q.setParameter("sdata", "2018-01-10");
        q.setParameter("edata", "2019-01-01");
        return q.getResultList();
        }
    
//    @GET
//    @Path("Test2")
//    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
//    public List<Location> Test2() {
//         Query q =  em.createQuery("SELECT l FROM Location l WHERE l.data < ") ;
//         List<Object[]> result = q.getResultList();
//         System.out.println(q.getResultList()) ;
//         Query q2 = em.createQuery("SELECT l FROM Location l");
//           
//        
//        return q2.getResultList();
//    } 
//    
    // statistical
//    @GET
//    @Path("StatisticalStuPalceTime/{sdata}/{edata}/{stuld}")
//    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
//    public List<Location> StatisticalStuPalceTime(@PathParam("sdata") Date sdata , @PathParam ("edata") Date edata, @PathParam("stuld") Integer stuld ) {
//        String query = "SELECT l FROM Location l WHERE l.stuld = :stuld " ;
////        GROUP BY l.place HAVING COUNT(l.place)
//        TypedQuery<Location>q = (TypedQuery<Location>) em.createQuery(query);
//        q.setParameter("sdata", sdata);
//        q.setParameter("edata", edata);
//        q.setParameter("stuld", stuld);
//        
//        List<Location> list = q.getResultList();
//        
//        for (Location L : list){
//            
//            System.out.println(L);
//            
//        }
//        return q.getResultList();
//    }
    

    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}



