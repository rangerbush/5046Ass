/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.fit5046;

import java.io.Serializable;
import java.util.Date;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Ranger
 */
@Entity
@Table(name = "RELATIONSHIP")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Relationship.findAll", query = "SELECT r FROM Relationship r")
    , @NamedQuery(name = "Relationship.findByOwnerid", query = "SELECT r FROM Relationship r WHERE r.relationshipPK.ownerid = :ownerid")
    , @NamedQuery(name = "Relationship.findByTargetid", query = "SELECT r FROM Relationship r WHERE r.relationshipPK.targetid = :targetid")
            , @NamedQuery(name = "Relationship.searchUnisexFriends", query = "SELECT r FROM Relationship r JOIN r.student s1 JOIN r.student1 s2 WHERE s1.gender = s2.gender          ")
  ,      
@NamedQuery(name = "Relationship.findByID", query = "SELECT r FROM Relationship r  WHERE r.student1.id = :id OR r.student.id = :id")
 
})

public class Relationship implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected RelationshipPK relationshipPK;
 

    @JoinColumn(name = "TARGETID", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Student student;
    @JoinColumn(name = "OWNERID", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Student student1;

    public Relationship() {
    }

    public Relationship(RelationshipPK relationshipPK) {
        this.relationshipPK = relationshipPK;
    }

    public Relationship(int ownerid, int targetid) {
        this.relationshipPK = new RelationshipPK(ownerid, targetid);
    }

    public RelationshipPK getRelationshipPK() {
        return relationshipPK;
    }

    public void setRelationshipPK(RelationshipPK relationshipPK) {
        this.relationshipPK = relationshipPK;
    }



    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Student getStudent1() {
        return student1;
    }

    public void setStudent1(Student student1) {
        this.student1 = student1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (relationshipPK != null ? relationshipPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Relationship)) {
            return false;
        }
        Relationship other = (Relationship) object;
        if ((this.relationshipPK == null && other.relationshipPK != null) || (this.relationshipPK != null && !this.relationshipPK.equals(other.relationshipPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.fit5046.Relationship[ relationshipPK=" + relationshipPK + " ]";
    }
    
}
