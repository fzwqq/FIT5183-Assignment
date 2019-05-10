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
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "LOCATION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Location.findAll", query = "SELECT l FROM Location l")
    , @NamedQuery(name = "Location.findByLatitude", query = "SELECT l FROM Location l WHERE l.latitude = :latitude")
    , @NamedQuery(name = "Location.findByLongitude", query = "SELECT l FROM Location l WHERE l.longitude = :longitude")
    , @NamedQuery(name = "Location.findByData", query = "SELECT l FROM Location l WHERE l.data = :data")
    , @NamedQuery(name = "Location.findByTime", query = "SELECT l FROM Location l WHERE l.time = :time")
    , @NamedQuery(name = "Location.findByPlace", query = "SELECT l FROM Location l WHERE l.place = :place")
    , @NamedQuery(name = "Location.findByLstuId", query = "SELECT l FROM Location l WHERE l.lstuId = :lstuId")
    , @NamedQuery(name = "Location.findByStatus", query = "SELECT l FROM Location l WHERE l.status = :status")
    , @NamedQuery(name = "Location.findByIdDataLl", query = "SELECT l FROM Location l WHERE l.idDataLl = :idDataLl")})
public class Location implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Column(name = "LATITUDE")
    private int latitude;
    @Basic(optional = false)
    @NotNull
    @Column(name = "LONGITUDE")
    private int longitude;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DATA_")
    @Temporal(TemporalType.DATE)
    private Date data;
    @Column(name = "TIME_")
    @Temporal(TemporalType.TIME)
    private Date time;
    @Size(max = 50)
    @Column(name = "PLACE")
    private String place;
    @Basic(optional = false)
    @NotNull
    @Column(name = "LSTU_ID")
    private int lstuId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "STATUS")
    private Boolean status;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "ID_DATA_LL")
    private String idDataLl;
    @JoinColumn(name = "STU_ID", referencedColumnName = "ID")
    @ManyToOne
    private StudentProfile stuId;

    public Location() {
    }

    public Location(String idDataLl) {
        this.idDataLl = idDataLl;
    }

    public Location(String idDataLl, int latitude, int longitude, Date data, int lstuId, Boolean status) {
        this.idDataLl = idDataLl;
        this.latitude = latitude;
        this.longitude = longitude;
        this.data = data;
        this.lstuId = lstuId;
        this.status = status;
    }

    public int getLatitude() {
        return latitude;
    }

    public void setLatitude(int latitude) {
        this.latitude = latitude;
    }

    public int getLongitude() {
        return longitude;
    }

    public void setLongitude(int longitude) {
        this.longitude = longitude;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public int getLstuId() {
        return lstuId;
    }

    public void setLstuId(int lstuId) {
        this.lstuId = lstuId;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getIdDataLl() {
        return idDataLl;
    }

    public void setIdDataLl(String idDataLl) {
        this.idDataLl = idDataLl;
    }

    public StudentProfile getStuId() {
        return stuId;
    }

    public void setStuId(StudentProfile stuId) {
        this.stuId = stuId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDataLl != null ? idDataLl.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Location)) {
            return false;
        }
        Location other = (Location) object;
        if ((this.idDataLl == null && other.idDataLl != null) || (this.idDataLl != null && !this.idDataLl.equals(other.idDataLl))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Students.Location[ idDataLl=" + idDataLl + " ]";
    }
    
}
