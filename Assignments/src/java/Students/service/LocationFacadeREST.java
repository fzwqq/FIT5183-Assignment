/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Students.service;

import Students.Location;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
   
//     statistical
    @GET
    @Path("StatisticalStuPalceTime/{sdata}/{edata}/{lstuId}")
//    @Produces({MediaType.APPLICATION_XML})
    public String StatisticalStuPalceTime(@PathParam("sdata")  Date sdata, @PathParam("edata")  Date edata, @PathParam("lstuId")  Integer lstuId) {
        TypedQuery<Location>q = (TypedQuery<Location>) em.createQuery( "SELECT l FROM Location l  WHERE l.data >= :sdata AND  l.data <= :edata AND l.lstuId = :lstuId" );
        q.setParameter("sdata", sdata);
        q.setParameter("edata", edata);
        q.setParameter("lstuId", lstuId);
        StringBuilder stringBuilder = new StringBuilder();
        List<Location>  results = q.getResultList();
        Map<String, Integer> map = new HashMap<String, Integer>() ;
        map.clear();
        for (Location result : results) {
            String place_ = result.getPlace();
            if (map.containsKey(place_) == false){
                map.put(place_,  1 ) ;
            }
            else{
                 Integer value = map.get(place_) + 1;
                 map.put(place_,  value+1 ) ; 
            }
        }
        for (String key: map.keySet()){
             stringBuilder.append(key);
             stringBuilder.append(" : ");
             Integer value = map.get(key);
             stringBuilder.append(value.toString());
        }        
        return stringBuilder.toString();
    }
    
    @GET
    @Path("GetNearestByStuIdAndCurLatitudeAndLongitude/{latitude}/{longitude}/{lstuId}")
//    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public String GetNearestByStuIdAndCurLatitudeAndLongitude(@PathParam("lstuId")  Integer lstuId ,@PathParam("longitude")  Integer longitude ,@PathParam("latitude")  Integer latitude) {
        TypedQuery<Location>q = (TypedQuery<Location>) em.createQuery( "SELECT l FROM Location l, StudentProfile s WHERE l.lstuId = s.id AND l.status = true "  );
//        StringBuilder stringBuilder = new StringBuilder();
        List<Location> results  = q.getResultList();
        Integer counts = results.size();
        // to store (latitude1, longitude1 , id , dis)
        Integer dis_array[][];
        dis_array = new Integer[counts+10][4];
        Integer cnt = 0;
        Map<Integer , String> map = new HashMap<Integer, String>();
        map.clear();
       
        for (Location result: results){
            dis_array[cnt][0] = result.getLatitude();
            dis_array[cnt][1] = result.getLongitude();
            dis_array[cnt][2] = result.getLstuId();
//            <name : firstnameSurname> 
//              map<id : name>
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(result.getStuId().getFirstname());
            stringBuilder.append(result.getStuId().getSurname()); 
            try{
                map.put(dis_array[cnt][2] , stringBuilder.toString()) ;
            } catch (Exception e) {
                return "error1";
            } 
                dis_array[cnt][3] = 0;
                cnt = cnt + 1;
        }
         // cal distance
         
        for(int i = 0 ; i < counts; ++i ){
            if(dis_array[i][2] == lstuId) {
                continue;
            }
            dis_array[i][3] = (dis_array[i][0] - latitude) *(dis_array[i][0] - latitude) + (dis_array[i][1] - longitude)*(dis_array[i][1] - longitude) ;
        }
        //sort by distance
//        try{
//        Arrays.sort(dis_array , new Comparator<Integer[]>() {
//			
//                        //arguments to this method represent the arrays to be sorted   
//			public dddint compare(Integer[] o1, Integer[] o2) {
//                                //get the item ids which are at index 0 of the array
//				return o1[3].compareTo(o2[3]);
//			}
//                            });    } 
//        catch (Exception e){
//                    return "error sort";
//         }
        
//        try {          
//        Arrays.sort(dis_array, (a, b) -> Integer.compare(a[3], b[3]));
//        } catch( Exception e) {
//            return "error2" ;
//        }
        // print ans : long , lat,  name
         StringBuilder ans = new StringBuilder();
        for (int i=0 ; i < counts; ++i){
            if ( dis_array[i][2] == lstuId ){
                continue;
            }
            
            ans.append("Latitude : ");
            ans.append(dis_array[i][0].toString());
            ans.append(" Longitude :");
            ans.append(dis_array[i][1].toString());
            ans.append(" Name : ");
            try{
                ans.append(map.get(dis_array[i][2]).toString());
                ans.append(" ");
            } catch (Exception e){
                return "error3"; 
            }
        }
        
//       1 .longtide and latitude to cal dis ,  
//       2. sort by dis
//       3. print lat and log and name by the id 
//               1. map<id , name>
//                2. Array(id , Latitude , Longitude) 
//                  3 result(dis, id) = cmp(latitude1, longitude1,  lat,log)) id != given_id
//                     4. sort(result(dis,id) by dis) 
//                          5 print
        return ans.toString();
//            return "true" ;
// 
    }
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}



