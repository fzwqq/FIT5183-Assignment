package Students;

import Students.Friendship;
import Students.Location;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-04-06T09:12:48")
@StaticMetamodel(StudentProfile.class)
public class StudentProfile_ { 

    public static volatile SingularAttribute<StudentProfile, String> firstname;
    public static volatile SingularAttribute<StudentProfile, String> address;
    public static volatile SingularAttribute<StudentProfile, Date> subtime;
    public static volatile SingularAttribute<StudentProfile, String> gender;
    public static volatile SingularAttribute<StudentProfile, String> nativelanguage;
    public static volatile SingularAttribute<StudentProfile, String> fmovie;
    public static volatile SingularAttribute<StudentProfile, String> studymode;
    public static volatile SingularAttribute<StudentProfile, Date> subdata;
    public static volatile CollectionAttribute<StudentProfile, Friendship> friendshipCollection1;
    public static volatile SingularAttribute<StudentProfile, String> password;
    public static volatile SingularAttribute<StudentProfile, String> currentjob;
    public static volatile SingularAttribute<StudentProfile, String> surname;
    public static volatile SingularAttribute<StudentProfile, Date> dob;
    public static volatile SingularAttribute<StudentProfile, String> nationnality;
    public static volatile SingularAttribute<StudentProfile, String> course;
    public static volatile SingularAttribute<StudentProfile, String> suburb;
    public static volatile SingularAttribute<StudentProfile, String> fsport;
    public static volatile SingularAttribute<StudentProfile, Integer> id;
    public static volatile CollectionAttribute<StudentProfile, Location> locationCollection;
    public static volatile SingularAttribute<StudentProfile, String> funit;
    public static volatile SingularAttribute<StudentProfile, String> email;
    public static volatile CollectionAttribute<StudentProfile, Friendship> friendshipCollection;

}