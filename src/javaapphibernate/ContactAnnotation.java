package javaapphibernate;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Avk
 */
@Entity
@Table(name="contact")
public class ContactAnnotation implements Serializable {
    
    /*
        GeneratedValues: AUTO, IDENTITY, SEQUENCE, TABLE
    */
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="pk_id_contact")
    private long id;
    
    @Column(name="name")
    private String name;

    @Column(name="lastname")
    private String lastname;

    @Column(name="address")
    private String address;

    @OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
    @JoinColumn(name = "fk_id_contact", nullable = true)
    private Set<PhoneAnnotation> phones = new HashSet<PhoneAnnotation>();

    @ManyToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
    @JoinTable(
            name="contact_team",
            joinColumns=@JoinColumn(name="fk_id_contact", referencedColumnName="pk_id_contact"),
            inverseJoinColumns=@JoinColumn(name="fk_id_team", referencedColumnName="pk_id_team")
    )
    private Set<TeamAnnotation> teams = new HashSet<TeamAnnotation>();

    
    public ContactAnnotation(){
    }

    public ContactAnnotation(String name, String lastname, String address) {
        this.name = name;
        this.lastname = lastname;
        this.address = address;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    public Set<PhoneAnnotation> getPhones() {
        return phones;
    }

    public void setPhones(Set<PhoneAnnotation> phones) {
        this.phones = phones;
    }
    
    public void addPhone(PhoneAnnotation phone) {
        this.phones.add(phone);
    }
    
    public void removePhone(PhoneAnnotation phone) {
        this.phones.remove(phone);
    }
    
    public Set<TeamAnnotation> getTeams() {
        return teams;
    }

    public void setTeams(Set<TeamAnnotation> teams) {
        this.teams = teams;
    }

    public void addTeam(TeamAnnotation teams) {
        this.teams.add(teams);
    }
    
    public void removeTeam(TeamAnnotation teams) {
        this.teams.remove(teams);
    }
    
    @Override
    public String toString() {
        boolean first=true;
        String r="Contact: id:"+id+", name:"+name+", lastName:"+lastname+", address:"+address+", phones [";
        for (PhoneAnnotation p:phones) {
            if (!first) r+=", "; else first=false;
            r+=p.getId();
        }
        r+="], Teams [";
        first=true;
        for (TeamAnnotation d:teams) {
            if (!first) r+=", "; else first=false;
            r+=d.getId();
        }
        r+="]";
        return r;
    }
}
