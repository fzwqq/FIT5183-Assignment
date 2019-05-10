/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Students;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author analysis.jinger
 */
@Entity
@Table(name = "STUDENT_PROFILE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StudentProfile.findAll", query = "SELECT s FROM StudentProfile s")
    , @NamedQuery(name = "StudentProfile.findByFirstname", query = "SELECT s FROM StudentProfile s WHERE s.firstname = :firstname")
    , @NamedQuery(name = "StudentProfile.findBySurname", query = "SELECT s FROM StudentProfile s WHERE s.surname = :surname")
    , @NamedQuery(name = "StudentProfile.findByDob", query = "SELECT s FROM StudentProfile s WHERE s.dob = :dob")
    , @NamedQuery(name = "StudentProfile.findByGender", query = "SELECT s FROM StudentProfile s WHERE s.gender = :gender")
    , @NamedQuery(name = "StudentProfile.findByCourse", query = "SELECT s FROM StudentProfile s WHERE s.course = :course")
    , @NamedQuery(name = "StudentProfile.findByStudymode", query = "SELECT s FROM StudentProfile s WHERE s.studymode = :studymode")
    , @NamedQuery(name = "StudentProfile.findByAddress", query = "SELECT s FROM StudentProfile s WHERE s.address = :address")
    , @NamedQuery(name = "StudentProfile.findBySuburb", query = "SELECT s FROM StudentProfile s WHERE s.suburb = :suburb")
    , @NamedQuery(name = "StudentProfile.findByNationnality", query = "SELECT s FROM StudentProfile s WHERE s.nationnality = :nationnality")
    , @NamedQuery(name = "StudentProfile.findByNativelanguage", query = "SELECT s FROM StudentProfile s WHERE s.nativelanguage = :nativelanguage")
    , @NamedQuery(name = "StudentProfile.findByFsport", query = "SELECT s FROM StudentProfile s WHERE s.fsport = :fsport")
    , @NamedQuery(name = "StudentProfile.findByFmovie", query = "SELECT s FROM StudentProfile s WHERE s.fmovie = :fmovie")
    , @NamedQuery(name = "StudentProfile.findByFunit", query = "SELECT s FROM StudentProfile s WHERE s.funit = :funit")
    , @NamedQuery(name = "StudentProfile.findByCurrentjob", query = "SELECT s FROM StudentProfile s WHERE s.currentjob = :currentjob")
    , @NamedQuery(name = "StudentProfile.findByEmail", query = "SELECT s FROM StudentProfile s WHERE s.email = :email")
    , @NamedQuery(name = "StudentProfile.findByPassword", query = "SELECT s FROM StudentProfile s WHERE s.password = :password")
    , @NamedQuery(name = "StudentProfile.findBySubdata", query = "SELECT s FROM StudentProfile s WHERE s.subdata = :subdata")
    , @NamedQuery(name = "StudentProfile.findBySubtime", query = "SELECT s FROM StudentProfile s WHERE s.subtime = :subtime")
    , @NamedQuery(name = "StudentProfile.findById", query = "SELECT s FROM StudentProfile s WHERE s.id = :id")})
public class StudentProfile implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 50)
    @Column(name = "FIRSTNAME")
    private String firstname;
    @Size(max = 50)
    @Column(name = "SURNAME")
    private String surname;
    @Column(name = "DOB")
    @Temporal(TemporalType.DATE)
    private Date dob;
    @Size(max = 10)
    @Column(name = "GENDER")
    private String gender;
    @Size(max = 30)
    @Column(name = "COURSE")
    private String course;
    @Size(max = 20)
    @Column(name = "STUDYMODE")
    private String studymode;
    @Size(max = 100)
    @Column(name = "ADDRESS")
    private String address;
    @Size(max = 100)
    @Column(name = "SUBURB")
    private String suburb;
    @Size(max = 30)
    @Column(name = "NATIONNALITY")
    private String nationnality;
    @Size(max = 30)
    @Column(name = "NATIVELANGUAGE")
    private String nativelanguage;
    @Size(max = 30)
    @Column(name = "FSPORT")
    private String fsport;
    @Size(max = 30)
    @Column(name = "FMOVIE")
    private String fmovie;
    @Size(max = 20)
    @Column(name = "FUNIT")
    private String funit;
    @Size(max = 20)
    @Column(name = "CURRENTJOB")
    private String currentjob;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 50)
    @Column(name = "EMAIL")
    private String email;
    @Size(max = 30)
    @Column(name = "PASSWORD")
    private String password;
    @Column(name = "SUBDATA")
    @Temporal(TemporalType.DATE)
    private Date subdata;
    @Column(name = "SUBTIME")
    @Temporal(TemporalType.TIME)
    private Date subtime;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @OneToMany(mappedBy = "stuId")
    private Collection<Location> locationCollection;
    @OneToMany(mappedBy = "stu2Id")
    private Collection<Friendship> friendshipCollection;
    @OneToMany(mappedBy = "stu1Id")
    private Collection<Friendship> friendshipCollection1;

    public StudentProfile() {
    }

    public StudentProfile(Integer id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getStudymode() {
        return studymode;
    }

    public void setStudymode(String studymode) {
        this.studymode = studymode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSuburb() {
        return suburb;
    }

    public void setSuburb(String suburb) {
        this.suburb = suburb;
    }

    public String getNationnality() {
        return nationnality;
    }

    public void setNationnality(String nationnality) {
        this.nationnality = nationnality;
    }

    public String getNativelanguage() {
        return nativelanguage;
    }

    public void setNativelanguage(String nativelanguage) {
        this.nativelanguage = nativelanguage;
    }

    public String getFsport() {
        return fsport;
    }

    public void setFsport(String fsport) {
        this.fsport = fsport;
    }

    public String getFmovie() {
        return fmovie;
    }

    public void setFmovie(String fmovie) {
        this.fmovie = fmovie;
    }

    public String getFunit() {
        return funit;
    }

    public void setFunit(String funit) {
        this.funit = funit;
    }

    public String getCurrentjob() {
        return currentjob;
    }

    public void setCurrentjob(String currentjob) {
        this.currentjob = currentjob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getSubdata() {
        return subdata;
    }

    public void setSubdata(Date subdata) {
        this.subdata = subdata;
    }

    public Date getSubtime() {
        return subtime;
    }

    public void setSubtime(Date subtime) {
        this.subtime = subtime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @XmlTransient
    public Collection<Location> getLocationCollection() {
        return locationCollection;
    }

    public void setLocationCollection(Collection<Location> locationCollection) {
        this.locationCollection = locationCollection;
    }

    @XmlTransient
    public Collection<Friendship> getFriendshipCollection() {
        return friendshipCollection;
    }

    public void setFriendshipCollection(Collection<Friendship> friendshipCollection) {
        this.friendshipCollection = friendshipCollection;
    }

    @XmlTransient
    public Collection<Friendship> getFriendshipCollection1() {
        return friendshipCollection1;
    }

    public void setFriendshipCollection1(Collection<Friendship> friendshipCollection1) {
        this.friendshipCollection1 = friendshipCollection1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StudentProfile)) {
            return false;
        }
        StudentProfile other = (StudentProfile) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Students.StudentProfile[ id=" + id + " ]";
    }
    
}
