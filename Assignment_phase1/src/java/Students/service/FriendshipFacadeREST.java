/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Students.service;

import Students.Friendship;
import Students.FriendshipPK;
import Students.Location;
import java.sql.Date;
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
import javax.ws.rs.core.PathSegment;

/**
 *
 * @author analysis.jinger
 */
@Stateless
@Path("students.friendship")
public class FriendshipFacadeREST extends AbstractFacade<Friendship> {

    @PersistenceContext(unitName = "AssignmentsPU")
    private EntityManager em;

    private FriendshipPK getPrimaryKey(PathSegment pathSegment) {
        /*
         * pathSemgent represents a URI path segment and any associated matrix parameters.
         * URI path part is supposed to be in form of 'somePath;fstu1Id=fstu1IdValue;fstu2Id=fstu2IdValue'.
         * Here 'somePath' is a result of getPath() method invocation and
         * it is ignored in the following code.
         * Matrix parameters are used as field names to build a primary key instance.
         */
        Students.FriendshipPK key = new Students.FriendshipPK();
        javax.ws.rs.core.MultivaluedMap<String, String> map = pathSegment.getMatrixParameters();
        java.util.List<String> fstu1Id = map.get("fstu1Id");
        if (fstu1Id != null && !fstu1Id.isEmpty()) {
            key.setFstu1Id(new java.lang.Integer(fstu1Id.get(0)));
        }
        java.util.List<String> fstu2Id = map.get("fstu2Id");
        if (fstu2Id != null && !fstu2Id.isEmpty()) {
            key.setFstu2Id(new java.lang.Integer(fstu2Id.get(0)));
        }
        return key;
    }

    public FriendshipFacadeREST() {
        super(Friendship.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Friendship entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") PathSegment id, Friendship entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") PathSegment id) {
        Students.FriendshipPK key = getPrimaryKey(id);
        super.remove(super.find(key));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Friendship find(@PathParam("id") PathSegment id) {
        Students.FriendshipPK key = getPrimaryKey(id);
        return super.find(key);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Friendship> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Friendship> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }
    
    @GET
    @Path("findByStu1Email/{stu1email}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Friendship> findByStu1Email(@PathParam("stu1email")  String stu1email) {
        Query query = em.createNamedQuery("Friendship.findByStu1Email");
        query.setParameter("stu1email", stu1email );
        return query.getResultList();
    }
  
    @GET
    @Path("findByStu2Email/{stu2email}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Friendship> findByStu2Email(@PathParam("stu2email")  String stu2email) {
        Query query = em.createNamedQuery("Friendship.findByStu2Email");
        query.setParameter("stu2email", stu2email );
        return query.getResultList();
    }
    
    @GET
    @Path("findBySdate/{sdate}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Friendship> findBySdate(@PathParam("sdate")  Date sdate) {
        Query query = em.createNamedQuery("Friendship.findBySdate");
        query.setParameter("sdate", sdate );
        return query.getResultList();
    }
    
    @GET
    @Path("findByEdate/{edate}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Friendship> findByEdate(@PathParam("edate")  Date edate) {
        Query query = em.createNamedQuery("Friendship.findByEdate");
        query.setParameter("edate", edate );
        return query.getResultList();
    }
    
    @GET
    @Path("findByFriendshipstatus/{friendshipstatus}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Friendship> findByFriendshipstatus(@PathParam("friendshipstatus")  Boolean friendshipstatus) {
        Query query = em.createNamedQuery("Friendship.findByFriendshipstatus");
        query.setParameter("friendshipstatus", friendshipstatus );
        return query.getResultList();
    }
    
    @GET
    @Path("findByFstu2Id/{fstu2Id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Friendship> findByFstu2Id(@PathParam("fstu2Id")  String fstu2Id) {
        Query query = em.createNamedQuery("Friendship.findByFstu2Id");
        query.setParameter("fstu2Id", fstu2Id );
        return query.getResultList();
    }
    
    @GET
    @Path("findByFstu1Id/{fstu1Id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Friendship> findByFstu1Id(@PathParam("fstu1Id")  String fstu1Id) {
        Query query = em.createNamedQuery("Friendship.findByFstu1Id");
        query.setParameter("fstu1Id", fstu1Id );
        return query.getResultList();
    }
    
    // explict join
    @GET
    @Path("findByfirstname/{firstname}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Friendship> findByFirstName(@PathParam("firstname") String firstname ) {
        TypedQuery<Friendship>q = (TypedQuery<Friendship>) em.createQuery("SELECT f FROM Friendship f JOIN f.stu1Id a WHERE a.firstname = :firstname") ;
        q.setParameter("firstname", firstname);
        return q.getResultList();
    }    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
