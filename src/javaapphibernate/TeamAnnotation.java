package javaapphibernate;

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
import javax.persistence.Table;

/**
 *
 * @author Avk
 */
@Entity
@Table(name="team")
public class TeamAnnotation {

    /*
        GeneratedValues: AUTO, IDENTITY, SEQUENCE, TABLE
    */
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="pk_id_team")
    private long id;
    
    @Column(name="name")
    private String name;

    @ManyToMany(cascade={CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE}, fetch=FetchType.LAZY)
    @JoinTable(
            name="contact_team",
            joinColumns=@JoinColumn(name="fk_id_team", referencedColumnName="pk_id_team"),
            inverseJoinColumns=@JoinColumn(name="fk_id_contact", referencedColumnName="pk_id_contact")
    )
    private Set<ContactAnnotation> contacts = new HashSet<ContactAnnotation>();

    public TeamAnnotation(){
    }

    public TeamAnnotation(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    private void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<ContactAnnotation> getContacts() {
        return contacts;
    }

    public void setContacts(Set<ContactAnnotation> contacts) {
        this.contacts = contacts;
    }
    
    public void addContact(ContactAnnotation contact) {
        this.contacts.add(contact);
    }
    
    public void removeContact(ContactAnnotation contact) {
        this.contacts.remove(contact);
    }
    
    @Override
    public String toString() {
        boolean first=true;
        String r="Team: id:"+id+", name:"+name+", Contacts [";
        for (ContactAnnotation c:contacts) {
            if (!first) r+=", "; else first=false;
            r+=c.getId();
        }
        r+="]";
        return r;
    }   
}
