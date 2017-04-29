/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.fit5046;

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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Ranger
 */
@Entity
@Table(name = "VISIT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Visit.findAll", query = "SELECT v FROM Visit v")
    , @NamedQuery(name = "Visit.findByVid", query = "SELECT v FROM Visit v WHERE v.vid = :vid")
    , @NamedQuery(name = "Visit.findByLid", query = "SELECT v FROM Visit v WHERE v.lid.id = :lid")
    , @NamedQuery(name = "Visit.findByUid", query = "SELECT v FROM Visit v WHERE v.uid.id = :uid")
    , @NamedQuery(name = "Visit.findByDate", query = "SELECT v FROM Visit v WHERE v.date = :date")})
public class Visit implements Serializable {

    private static long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "VID")
    private Integer vid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DATE")
    @Temporal(TemporalType.DATE)
    private Date date;
    @JoinColumn(name = "LID", referencedColumnName = "ID")
    @ManyToOne
    private Location lid;
    @JoinColumn(name = "UID", referencedColumnName = "ID")
    @ManyToOne
    private Student uid;
    public Visit() {
    }

    public Visit(Integer vid) {
        this.vid = vid;
    }

    public Visit(Integer vid, Date date) {
        this.vid = vid;
        this.date = date;
    }

    public Integer getVid() {
        return vid;
    }

    public void setVid(Integer vid) {
        this.vid = vid;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Location getLid() {
        return lid;
    }

    public void setLid(Location lid) {
        this.lid = lid;
    }

    public Student getUid() {
        return uid;
    }

    public void setUid(Student uid) {
        this.uid = uid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (vid != null ? vid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Visit)) {
            return false;
        }
        Visit other = (Visit) object;
        if ((this.vid == null && other.vid != null) || (this.vid != null && !this.vid.equals(other.vid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.fit5046.Visit[ vid=" + vid + " ]";
    }



    
}
