package javaapphibernate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Avk
 */
@Entity
@Table(name="phone")
public class PhoneAnnotation {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="pk_id_phone")
    private long id;
    
    @Column(name="number")
    private long number;
    
    @ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
    @JoinColumn(name = "fk_id_contact")
    private ContactAnnotation contact;

    public PhoneAnnotation() {
    }
    
    public PhoneAnnotation(long number, ContactAnnotation contact) {
        this.number=number;
        this.contact=contact;
    }
    
    public long getId() {
        return id;
    }

    private void setId(long id) {
        this.id = id;
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public ContactAnnotation getContact() {
        return contact;
    }

    public void setContact(ContactAnnotation contact) {
        this.contact = contact;
    }

    @Override
    public String toString() {
        return "Phone: id:"+id+", number:"+number;
    }
}
