/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Students;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author analysis.jinger
 */
@Embeddable
public class FriendshipPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "FSTU1_ID")
    private int fstu1Id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FSTU2_ID")
    private int fstu2Id;

    public FriendshipPK() {
    }

    public FriendshipPK(int fstu1Id, int fstu2Id) {
        this.fstu1Id = fstu1Id;
        this.fstu2Id = fstu2Id;
    }

    public int getFstu1Id() {
        return fstu1Id;
    }

    public void setFstu1Id(int fstu1Id) {
        this.fstu1Id = fstu1Id;
    }

    public int getFstu2Id() {
        return fstu2Id;
    }

    public void setFstu2Id(int fstu2Id) {
        this.fstu2Id = fstu2Id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) fstu1Id;
        hash += (int) fstu2Id;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FriendshipPK)) {
            return false;
        }
        FriendshipPK other = (FriendshipPK) object;
        if (this.fstu1Id != other.fstu1Id) {
            return false;
        }
        if (this.fstu2Id != other.fstu2Id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Students.FriendshipPK[ fstu1Id=" + fstu1Id + ", fstu2Id=" + fstu2Id + " ]";
    }
    
}
