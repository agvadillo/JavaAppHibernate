package javaapphibernate;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Avk
 */
public class Team {
    private long id;
    private String name;
    private Set<Contact> contacts = new HashSet<Contact>();

    public Team(){
    }

    public Team(String name) {
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

    public Set<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(Set<Contact> contacts) {
        this.contacts = contacts;
    }
    
    public void addContact(Contact contact) {
        this.contacts.add(contact);
    }
    
    public void removeContact(Contact contact) {
        this.contacts.remove(contact);
    }
    
    @Override
    public String toString() {
        boolean first=true;
        String r="Department: id:"+id+", name:"+name+", Contacts [";
        for (Contact c:contacts) {
            if (!first) r+=", "; else first=false;
            r+=c.getId();
        }
        r+="], contacts [";
        first=true;
        for (Contact c:contacts) {
            if (!first) r+=", "; else first=false;
            r+=c.getId();
        }
        r+="]";
        return r;
    }
}
