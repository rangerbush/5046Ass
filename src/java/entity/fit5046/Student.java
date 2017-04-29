/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.fit5046;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
 * @author Ranger
 */
@Entity
@Table(name = "STUDENT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Student.findAll", query = "SELECT s FROM Student s")
    , @NamedQuery(name = "Student.findById", query = "SELECT s FROM Student s WHERE s.id = :id")
    , @NamedQuery(name = "Student.findByFirstname", query = "SELECT s FROM Student s WHERE s.firstname = :firstname")
    , @NamedQuery(name = "Student.findByLastname", query = "SELECT s FROM Student s WHERE s.lastname = :lastname")
    , @NamedQuery(name = "Student.findByDob", query = "SELECT s FROM Student s WHERE s.dob = :dob")
    , @NamedQuery(name = "Student.findByGender", query = "SELECT s FROM Student s WHERE s.gender = :gender")
    , @NamedQuery(name = "Student.findByCourse", query = "SELECT s FROM Student s WHERE s.course = :course")
    , @NamedQuery(name = "Student.findByIsfulltime", query = "SELECT s FROM Student s WHERE s.isfulltime = :isfulltime")
    , @NamedQuery(name = "Student.findByAddress", query = "SELECT s FROM Student s WHERE s.address = :address")
    , @NamedQuery(name = "Student.findBySurburb", query = "SELECT s FROM Student s WHERE s.surburb = :surburb")
    , @NamedQuery(name = "Student.findByNationality", query = "SELECT s FROM Student s WHERE s.nationality = :nationality")
    , @NamedQuery(name = "Student.findByNativelanguage", query = "SELECT s FROM Student s WHERE s.nativelanguage = :nativelanguage")
    , @NamedQuery(name = "Student.findByFavoritesport", query = "SELECT s FROM Student s WHERE s.favoritesport = :favoritesport")
    , @NamedQuery(name = "Student.findByFavoritemovie", query = "SELECT s FROM Student s WHERE s.favoritemovie = :favoritemovie")
    , @NamedQuery(name = "Student.findByFavoriteunit", query = "SELECT s FROM Student s WHERE s.favoriteunit = :favoriteunit")
    , @NamedQuery(name = "Student.findByCurrentjob", query = "SELECT s FROM Student s WHERE s.currentjob = :currentjob")
    , @NamedQuery(name = "Student.findByMail", query = "SELECT s FROM Student s WHERE s.mail = :mail")
    , @NamedQuery(name = "Student.findByPassword", query = "SELECT s FROM Student s WHERE s.password = :password")
    , @NamedQuery(name = "Student.findByRegdate", query = "SELECT s FROM Student s WHERE s.regdate = :regdate")

})
public class Student implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "FIRSTNAME")
    private String firstname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "LASTNAME")
    private String lastname;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DOB")
    @Temporal(TemporalType.DATE)
    private Date dob;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "GENDER")
    private String gender;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "COURSE")
    private String course;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ISFULLTIME")
    private Boolean isfulltime;
    @Size(max = 50)
    @Column(name = "ADDRESS")
    private String address;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "SURBURB")
    private String surburb;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "NATIONALITY")
    private String nationality;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "NATIVELANGUAGE")
    private String nativelanguage;
    @Size(max = 40)
    @Column(name = "FAVORITESPORT")
    private String favoritesport;
    @Size(max = 50)
    @Column(name = "FAVORITEMOVIE")
    private String favoritemovie;
    @Size(max = 50)
    @Column(name = "FAVORITEUNIT")
    private String favoriteunit;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "CURRENTJOB")
    private String currentjob;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 99)
    @Column(name = "MAIL")
    private String mail;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "PASSWORD")
    private String password;
    @Basic(optional = false)
    @NotNull
    @Column(name = "REGDATE")
    @Temporal(TemporalType.DATE)
    private Date regdate;
    @OneToMany(mappedBy = "uid")
    private Collection<Visit> visitCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "student")
    private Collection<Relationship> relationshipCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "student1")
    private Collection<Relationship> relationshipCollection1;

    public Student() {
    }

    public Student(Integer id) {
        this.id = id;
    }

    public Student(Integer id, String firstname, String lastname, Date dob, String gender, String course, Boolean isfulltime, String surburb, String nationality, String nativelanguage, String currentjob, String mail, String password, Date regdate) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.dob = dob;
        this.gender = gender;
        this.course = course;
        this.isfulltime = isfulltime;
        this.surburb = surburb;
        this.nationality = nationality;
        this.nativelanguage = nativelanguage;
        this.currentjob = currentjob;
        this.mail = mail;
        this.password = password;
        this.regdate = regdate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
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

    public Boolean getIsfulltime() {
        return isfulltime;
    }

    public void setIsfulltime(Boolean isfulltime) {
        this.isfulltime = isfulltime;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSurburb() {
        return surburb;
    }

    public void setSurburb(String surburb) {
        this.surburb = surburb;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getNativelanguage() {
        return nativelanguage;
    }

    public void setNativelanguage(String nativelanguage) {
        this.nativelanguage = nativelanguage;
    }

    public String getFavoritesport() {
        return favoritesport;
    }

    public void setFavoritesport(String favoritesport) {
        this.favoritesport = favoritesport;
    }

    public String getFavoritemovie() {
        return favoritemovie;
    }

    public void setFavoritemovie(String favoritemovie) {
        this.favoritemovie = favoritemovie;
    }

    public String getFavoriteunit() {
        return favoriteunit;
    }

    public void setFavoriteunit(String favoriteunit) {
        this.favoriteunit = favoriteunit;
    }

    public String getCurrentjob() {
        return currentjob;
    }

    public void setCurrentjob(String currentjob) {
        this.currentjob = currentjob;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getRegdate() {
        return regdate;
    }

    public void setRegdate(Date regdate) {
        this.regdate = regdate;
    }

    @XmlTransient
    public Collection<Visit> getVisitCollection() {
        return visitCollection;
    }

    public void setVisitCollection(Collection<Visit> visitCollection) {
        this.visitCollection = visitCollection;
    }

    @XmlTransient
    public Collection<Relationship> getRelationshipCollection() {
        return relationshipCollection;
    }

    public void setRelationshipCollection(Collection<Relationship> relationshipCollection) {
        this.relationshipCollection = relationshipCollection;
    }

    @XmlTransient
    public Collection<Relationship> getRelationshipCollection1() {
        return relationshipCollection1;
    }

    public void setRelationshipCollection1(Collection<Relationship> relationshipCollection1) {
        this.relationshipCollection1 = relationshipCollection1;
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
        if (!(object instanceof Student)) {
            return false;
        }
        Student other = (Student) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.fit5046.Student[ id=" + id + " ]";
    }
    
}
