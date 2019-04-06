### 1. Java ee vs se vs me 

* Java SE(Java Platform,Standard Edition)，应该先说这个，因为这个是标准版本。
* Java EE (Java Platform，Enterprise Edition)，java 的企业版本
* Java ME(Java Platform，Micro Edition)，java的微型版本。

> Java EE 重点用在web 开发, 在se 基础上定义了多一些标准和规范

* 其中, JAX-RS 是 Java EE 一部分. 

---

### 2. JAX-RS 介绍

> stands for *JAVA API for RESTful Web Services*.

### 背景

* **发展**

1. 起初,Java servlets 常被用来开发 RESTful 应用程序;

   * Java Servlet : 

     定义: 指用Java语言实现了这个Servlet接口的类.

     > **广义的Servlet 是指任何实现了这个Servlet接口的类.**

   * 实现上: 绝大多数情况只相应HTTP协议的web服务器[WIKI](https://zh.wikipedia.org/wiki/Java_Servlet)
   * **工作模式:**
     * 客户端发送请求至服务器
     * 服务器启动并调用Servlet，Servlet根据客户端请求生成响应内容并将其传给服务器
     * 服务器将响应返回客户端
     * etc

2. 接着,由于REST 架构广受认可, Java Community Process (JCP)  在 Java EE 6 中对其正式支持.

3. **优点 JAX-RS** 
   * 与 servlet 模型相比，JAX-RS **注释(标注)**能集中于资源和数据对象,不必再开发通讯层（通过 servlet）
   * 可以轻松创建部署到Java应用程序服务器的RESTful服务器:e.g.GlassFish, WebLogic , WebSphere, JBoss etc.

---

### JAX-RS 注释/标注

* @PATH

* @PUT

* @GET

* @POST

* @DELETE

* @PROduce

* @Consume

* QueryParam

* etc

* ---

* ![image-20190404191131014](/Users/analysis.jinger/Library/Application%20Support/typora-user-images/image-20190404191131014.png)

  ![image-20190404191206321](/Users/analysis.jinger/Library/Application%20Support/typora-user-images/image-20190404191206321.png)

---

### Task-1

#### section-1 建立表格

```sql
create table Student_Profile(

    FirstName VARCHAR(50),

    Surname  VARCHAR(50),

    DoB DATE,

    Gender VARCHAR(10),

    Course VARCHAR(30),

    StudyMode VARCHAR(20),

    Address VARCHAR(100),

    Suburb VARCHAR(100),

    Nationnality VARCHAR(30),

    NativeLanguage VARCHAR(30),

    FSport VARCHAR(30),

    FMovie VARCHAR(30),

    FUnit VARCHAR(20),

    CurrentJob VARCHAR(20),
-- {Y:"employed", N:"unemployed"}

    Email VARCHAR(50),

    Password VARCHAR(30),

    SubData DATE,

    SubTime TIME,

    ID INTEGER NOT NULL,

    PRIMARY KEY (ID)
-- set email as pri-key
);


create table Location(

    Latitude  INTEGER,

    Longitude INTEGER,

    Data_ Date,

    Time_ Time,

    Place VARCHAR(50),

    Email VARCHAR(50) NOT NULL,

    StudentID INTEGER,

    PRIMARY KEY (Email)
);
--     e.g. Caulfield campus, Clayton campus, Chadstone shopping centre 

create table Friendship(
    
    Stu1_Id INTEGER,

    Stu2_Id INTEGER,

    Stu1_email VARCHAR(50) NOT NULL,

    Stu2_email VARCHAR(50) NOT NULL,

    SDate DATE,

    EDate DATE DEFAULT NULL ,
   
    EdgeId INTEGER NOT NULL,
---
-- 设置双主键或者UNIAUE 索引保证数据唯一性
-- UNIQUE(column1,column2)
---
    PRIMARY KEY (Stu1_email,Stu2_email)
);

--student's location  to student_profile  —— 1 : 1 

ALTER TABLE Location

ADD CONSTRAINT fk_student_id

FOREIGN KEY (StudentId)

REFERENCES Student_Profile(ID)

--student's friendship to student_profile —— n : 1


ALTER TABLE Friendship

ADD CONSTRAINT fk_Friendship_id1

FOREIGN KEY (Stu1_Id)

REFERENCES Student_Profile(ID);


ALTER TABLE Friendship

ADD CONSTRAINT fk_Friendship_id2

FOREIGN KEY (Stu2_Id)

REFERENCES Student_Profile(ID)

---因为email 同时也是LOCATION 的主键， 所以不需要设置对于student's location 的外键

```

#### section-2 插入数据

1. Table1-Student_profile

```sql
INSERT INTO STUDENT_PROFILE (FIRSTNAME, SURNAME, DOB, GENDER, COURSE, STUDYMODE,
                                               ADDRESS,  SUBURB, NATIONNALITY, NATIVELANGUAGE, FSPORT, FMOVIE, FUNIT,
                                               CURRENTJOB, EMAIL,  PASSWORD, SUBDATA, SUBTIME, ID)
VALUES('Jin', 'Jiang', '1995-12-22', 'Male', 'MIT', 'Full-Time', 'suzhou', 'China-Guangdong', 'China', 'Chinese', 'golf',
            'Western World', 'FIT5183', 'employed' ,'Jiangjin@monash.student.edu', '123456', '2018-09-01', '00:00', 1 );

INSERT INTO STUDENT_PROFILE (FIRSTNAME, SURNAME, DOB, GENDER, COURSE, STUDYMODE,
                                               ADDRESS,  SUBURB, NATIONNALITY, NATIVELANGUAGE, FSPORT, FMOVIE, FUNIT,
                                               CURRENTJOB, EMAIL,  PASSWORD, SUBDATA, SUBTIME, ID)
VALUES('Juxiang', 'Zhao', '1995-12-20', 'Male', 'MBIS', 'Full-Time', 'suzhou', 'China-Guangdong', 'China', 'Chinese', 'golf',
            'Western World', 'FIT5183', 'employed' ,'zhaojuxiang@monash.student.edu', '123456', '2018-09-01', '00:00', 2 );

INSERT INTO STUDENT_PROFILE (FIRSTNAME, SURNAME, DOB, GENDER, COURSE, STUDYMODE,
                                               ADDRESS,  SUBURB, NATIONNALITY, NATIVELANGUAGE, FSPORT, FMOVIE, FUNIT,
                                               CURRENTJOB, EMAIL,  PASSWORD, SUBDATA, SUBTIME, ID)
VALUES('Wenchao', 'Li', '1995-12-21', 'Male', 'MNS', 'Full-Time', 'suzhou', 'China-Guangdong', 'China', 'Chinese', 'golf',
            'Western World', 'FIT5187', 'employed' ,'liwenchao@monash.student.edu', '123456', '2018-09-01', '00:00', 3 )

```

2. Table2-Location

```sql
INSERT INTO LOCATION (LATITUDE, LONGITUDE, DATA_, TIME_, PLACE, EMAIL, STUDENTID) 
VALUES(12, 21, '2018-09-01', '12:00' , 'china' , 'Jiangjin@monash.student.edu', 1 );

INSERT INTO LOCATION (LATITUDE, LONGITUDE, DATA_, TIME_, PLACE, EMAIL, STUDENTID) 
VALUES(12, 21, '2018-09-01', '12:00' , 'china' , 'liwenchao@monash.student.edu', 3 );

INSERT INTO LOCATION (LATITUDE, LONGITUDE, DATA_, TIME_, PLACE, EMAIL, STUDENTID) 
VALUES(12, 21, '2018-09-01', '12:00' , 'china' , 'zhaojuxiang@monash.student.edu', 2 );
```

3. Table3- Friendship

```sql

INSERT INTO FRIENDSHIP (STU1_ID, STU2_ID, STU1_EMAIL , STU2_EMAIL, SDATE ) 
VALUES (1, 2, 'Jiangjin@student.moansh.edu', 'zhaojuxiang@student.monash.edu', '2018-09-01' );

INSERT INTO FRIENDSHIP (STU1_ID, STU2_ID, STU1_EMAIL , STU2_EMAIL, SDATE ) 
VALUES (1, 3, 'Jiangjin@student.moansh.edu', 'liwenchao@student.monash.edu', '2018-09-01' );


INSERT INTO FRIENDSHIP (STU1_ID, STU2_ID, STU1_EMAIL , STU2_EMAIL, SDATE ) 
VALUES (3, 2, 'liwenchao@student.moansh.edu', 'zhaojuxiang@student.monash.edu', '2018-09-01' );

```



---

### Task-2

#### *a)* b)

![image-20190405120019064](/Users/analysis.jinger/Library/Application Support/typora-user-images/image-20190405120019064.png)

![image-20190405120118385](/Users/analysis.jinger/Library/Application Support/typora-user-images/image-20190405120118385.png)

![image-20190405120126459](/Users/analysis.jinger/Library/Application Support/typora-user-images/image-20190405120126459.png)

#### c) - 1) GET method implementation 

* Template: 

* ```java
  @GET
      @Path("****/{@@@}")
      @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
      public List<StudentProfile> ****(@PathParam("@@@")  String @@@) {
          Query query = em.createNamedQuery("StudentProfile.****");
          query.setParameter("@@@", @@@ );
          return query.getResultList();
      }
  ```

  * **tips**: with clipboard-workflow and curl+F command to replace the curl+C and then curl + V one by one 

* 1. **FREIENDS_PROFILE Get**

* ```java
  import java.sql.Date;
  import java.sql.Time;
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
      
  ```

* template

  1. ```java
     @GET
         @Path("****/{@@@}")
         @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
         public List<Location> ****(@PathParam("@@@")  String @@@) {
             Query query = em.createNamedQuery("StudentProfile.****");
             query.setParameter("@@@", @@@ );
             return query.getResultList();
         }
     ```

  * **Location method & queries**

  ```java
  import java.sql.Date;
  import java.sql.Time;
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
          Query query = em.createNamedQuery("StudentProfile.findByLongitude");
          query.setParameter("longitude", longitude );
          return query.getResultList();
      }
      
      @GET
      @Path("findByData/{data}")
      @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
      public List<Location> findByData(@PathParam("data")  Date data) {
          Query query = em.createNamedQuery("StudentProfile.findByData");
          query.setParameter("data", data );
          return query.getResultList();
      }
      
      @GET
      @Path("findByTime/{time}")
      @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
      public List<Location> findByTime(@PathParam("time")  Time time) {
          Query query = em.createNamedQuery("StudentProfile.findByTime");
          query.setParameter("time", time );
          return query.getResultList();
      }
      
      @GET
      @Path("findByPlace/{place}")
      @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
      public List<Location> findByPlace(@PathParam("place")  String place) {
          Query query = em.createNamedQuery("StudentProfile.findByPlace");
          query.setParameter("place", place );
          return query.getResultList();
      }
      
      @GET
      @Path("findByEmail/{email}")
      @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
      public List<Location> findByEmail(@PathParam("email")  String email) {
          Query query = em.createNamedQuery("StudentProfile.findByEmail");
          query.setParameter("email", email );
          return query.getResultList();
      }
  ```

* template

  * ```java
    @GET
        @Path("****/{@@@}")
        @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
        public List<Friendship> ****(@PathParam("@@@")  String @@@) {
            Query query = em.createNamedQuery("StudentProfile.****");
            query.setParameter("@@@", @@@ );
            return query.getResultList();
        }
    ```

  * **GET method & Queries**

  * ```java
    import java.sql.Date;
    @GET
        @Path("findByStu1Email/{stu1email}")
        @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
        public List<Friendship> findByStu1Email(@PathParam("stu1email")  String stu1email) {
            Query query = em.createNamedQuery("StudentProfile.findByStu1Email");
            query.setParameter("stu1email", stu1email );
            return query.getResultList();
        }
      
        @GET
        @Path("findByStu2Email/{stu2email}")
        @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
        public List<Friendship> findByStu2Email(@PathParam("stu2email")  String stu2email) {
            Query query = em.createNamedQuery("StudentProfile.findByStu2Email");
            query.setParameter("stu2email", stu2email );
            return query.getResultList();
        }
        
        @GET
        @Path("findBySdate/{sdate}")
        @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
        public List<Friendship> findBySdate(@PathParam("sdate")  Date sdate) {
            Query query = em.createNamedQuery("StudentProfile.findBySdate");
            query.setParameter("sdate", sdate );
            return query.getResultList();
        }
        
        @GET
        @Path("findByEdate/{edate}")
        @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
        public List<Friendship> findByEdate(@PathParam("edate")  Date edate) {
            Query query = em.createNamedQuery("StudentProfile.findByEdate");
            query.setParameter("edate", edate );
            return query.getResultList();
        }
    ```

#### c) - 2)

* ```java
  //    Task2 - c) - 2) 
  import javax.persistence.TypedQuery;
      @GET
      @Path("findByFirstNameAndLastName/{firstname}/{lastname}" )
      @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
      public List<StudentProfile> findByFirstNameAndLastName(@PathParam("firstname") String firstname , @PathParam("lastname") String lastname){
          TypedQuery<StudentProfile> q = (TypedQuery<StudentProfile>) em.createQuery("SELECT s FROM StudentProfile s WHERE s.firstname = :firstname AND s.lastname = :lastname");
          q.setParameter("firstname", firstname);
          q.setParameter("lastname", lastname);
          return q.getResultList();
      }
  ```

* 



---

#### Some Issues

* 试过通过sql 语句,修改column类型失败

  > 问题原因:可能跟 netbeans 设置有关

* 设置双主键或者UNIQUE来保证数据唯一性

* 由于设置了多个外键,且都指向同一主键, 若要通过外键查询数据,可参考https://blog.csdn.net/YYZZHC999/article/details/78638602 

* 有个地方被英文恶心到了

  * Task1- 提到location 的update , 其实不是sql的update , 还是插入新数据行才行… 到了Task3发现...

---

SQL 语法

* 删除列
  * ALTER TABLE FRIENDSHIP DROP COLUMN EDGEID
* 删除行
  * DELETE FROM table Where columname = '?'

