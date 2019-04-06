package Students;

import Students.FriendshipPK;
import Students.StudentProfile;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-04-06T09:12:48")
@StaticMetamodel(Friendship.class)
public class Friendship_ { 

    public static volatile SingularAttribute<Friendship, FriendshipPK> friendshipPK;
    public static volatile SingularAttribute<Friendship, Date> sdate;
    public static volatile SingularAttribute<Friendship, String> stu1Email;
    public static volatile SingularAttribute<Friendship, Boolean> friendshipstatus;
    public static volatile SingularAttribute<Friendship, StudentProfile> stu2Id;
    public static volatile SingularAttribute<Friendship, Date> edate;
    public static volatile SingularAttribute<Friendship, StudentProfile> stu1Id;
    public static volatile SingularAttribute<Friendship, String> stu2Email;

}