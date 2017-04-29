/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.fit5046;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Ranger
 */
@Embeddable
public class RelationshipPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "OWNERID")
    private int ownerid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TARGETID")
    private int targetid;

    public RelationshipPK() {
    }

    public RelationshipPK(int ownerid, int targetid) {
        this.ownerid = ownerid;
        this.targetid = targetid;
    }

    public int getOwnerid() {
        return ownerid;
    }

    public void setOwnerid(int ownerid) {
        this.ownerid = ownerid;
    }

    public int getTargetid() {
        return targetid;
    }

    public void setTargetid(int targetid) {
        this.targetid = targetid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) ownerid;
        hash += (int) targetid;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RelationshipPK)) {
            return false;
        }
        RelationshipPK other = (RelationshipPK) object;
        if (this.ownerid != other.ownerid) {
            return false;
        }
        if (this.targetid != other.targetid) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.fit5046.RelationshipPK[ ownerid=" + ownerid + ", targetid=" + targetid + " ]";
    }
    
}
