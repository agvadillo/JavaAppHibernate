package javaapphibernate;

/**
 *
 * @author Avk
 */
public class Phone {
    private long id;
    private long number;
    private Contact contact;

    public Phone() {
    }
    
    public Phone(long number, Contact contact) {
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

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    @Override
    public String toString() {
        return "Phone: id:"+id+", number:"+number;
    }
}
