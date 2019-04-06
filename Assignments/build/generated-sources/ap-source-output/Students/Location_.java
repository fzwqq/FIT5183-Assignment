package Students;

import Students.StudentProfile;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-04-06T09:12:48")
@StaticMetamodel(Location.class)
public class Location_ { 

    public static volatile SingularAttribute<Location, Date> data;
    public static volatile SingularAttribute<Location, String> idDataLl;
    public static volatile SingularAttribute<Location, StudentProfile> stuId;
    public static volatile SingularAttribute<Location, Integer> lstuId;
    public static volatile SingularAttribute<Location, Integer> latitude;
    public static volatile SingularAttribute<Location, Date> time;
    public static volatile SingularAttribute<Location, String> place;
    public static volatile SingularAttribute<Location, Integer> longitude;
    public static volatile SingularAttribute<Location, Boolean> status;

}