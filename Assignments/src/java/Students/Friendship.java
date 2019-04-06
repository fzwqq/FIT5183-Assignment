/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Students;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author analysis.jinger
 */
@Entity
@Table(name = "FRIENDSHIP")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Friendship.findAll", query = "SELECT f FROM Friendship f")
    , @NamedQuery(name = "Friendship.findByFstu1Id", query = "SELECT f FROM Friendship f WHERE f.friendshipPK.fstu1Id = :fstu1Id")
    , @NamedQuery(name = "Friendship.findByFstu2Id", query = "SELECT f FROM Friendship f WHERE f.friendshipPK.fstu2Id = :fstu2Id")
    , @NamedQuery(name = "Friendship.findByFriendshipstatus", query = "SELECT f FROM Friendship f WHERE f.friendshipstatus = :friendshipstatus")
    , @NamedQuery(name = "Friendship.findByStu1Email", query = "SELECT f FROM Friendship f WHERE f.stu1Email = :stu1Email")
    , @NamedQuery(name = "Friendship.findByStu2Email", query = "SELECT f FROM Friendship f WHERE f.stu2Email = :stu2Email")
    , @NamedQuery(name = "Friendship.findBySdate", query = "SELECT f FROM Friendship f WHERE f.sdate = :sdate")
    , @NamedQuery(name = "Friendship.findByEdate", query = "SELECT f FROM Friendship f WHERE f.edate = :edate")})
public class Friendship implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected FriendshipPK friendshipPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FRIENDSHIPSTATUS")
    private Boolean friendshipstatus;
    @Size(max = 50)
    @Column(name = "STU1_EMAIL")
    private String stu1Email;
    @Size(max = 50)
    @Column(name = "STU2_EMAIL")
    private String stu2Email;
    @Column(name = "SDATE")
    @Temporal(TemporalType.DATE)
    private Date sdate;
    @Column(name = "EDATE")
    @Temporal(TemporalType.DATE)
    private Date edate;
    @JoinColumn(name = "STU2_ID", referencedColumnName = "ID")
    @ManyToOne
    private StudentProfile stu2Id;
    @JoinColumn(name = "STU1_ID", referencedColumnName = "ID")
    @ManyToOne
    private StudentProfile stu1Id;

    public Friendship() {
    }

    public Friendship(FriendshipPK friendshipPK) {
        this.friendshipPK = friendshipPK;
    }

    public Friendship(FriendshipPK friendshipPK, Boolean friendshipstatus) {
        this.friendshipPK = friendshipPK;
        this.friendshipstatus = friendshipstatus;
    }

    public Friendship(int fstu1Id, int fstu2Id) {
        this.friendshipPK = new FriendshipPK(fstu1Id, fstu2Id);
    }

    public FriendshipPK getFriendshipPK() {
        return friendshipPK;
    }

    public void setFriendshipPK(FriendshipPK friendshipPK) {
        this.friendshipPK = friendshipPK;
    }

    public Boolean getFriendshipstatus() {
        return friendshipstatus;
    }

    public void setFriendshipstatus(Boolean friendshipstatus) {
        this.friendshipstatus = friendshipstatus;
    }

    public String getStu1Email() {
        return stu1Email;
    }

    public void setStu1Email(String stu1Email) {
        this.stu1Email = stu1Email;
    }

    public String getStu2Email() {
        return stu2Email;
    }

    public void setStu2Email(String stu2Email) {
        this.stu2Email = stu2Email;
    }

    public Date getSdate() {
        return sdate;
    }

    public void setSdate(Date sdate) {
        this.sdate = sdate;
    }

    public Date getEdate() {
        return edate;
    }

    public void setEdate(Date edate) {
        this.edate = edate;
    }

    public StudentProfile getStu2Id() {
        return stu2Id;
    }

    public void setStu2Id(StudentProfile stu2Id) {
        this.stu2Id = stu2Id;
    }

    public StudentProfile getStu1Id() {
        return stu1Id;
    }

    public void setStu1Id(StudentProfile stu1Id) {
        this.stu1Id = stu1Id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (friendshipPK != null ? friendshipPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Friendship)) {
            return false;
        }
        Friendship other = (Friendship) object;
        if ((this.friendshipPK == null && other.friendshipPK != null) || (this.friendshipPK != null && !this.friendshipPK.equals(other.friendshipPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Students.Friendship[ friendshipPK=" + friendshipPK + " ]";
    }
    
}
