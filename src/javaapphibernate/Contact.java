package javaapphibernate;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Avk
 */
public class Contact {

    private long id;
    private String name;
    private String lastname;
    private String address;
    private Set<Phone> phones = new HashSet<Phone>();
    private Set<Team> teams = new HashSet<Team>();

    public Contact(){

    }

    public Contact(String name, String lastname, String address) {
        this.name = name;
        this.lastname = lastname;
        this.address = address;
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

    public Set<Phone> getPhones() {
        return phones;
    }

    public void setPhones(Set<Phone> phones) {
        this.phones = phones;
    }
    
    public void addPhone(Phone phone) {
        this.phones.add(phone);
    }
    
    public void removePhone(Phone phone) {
        this.phones.remove(phone);
    }

    public Set<Team> getTeams() {
        return teams;
    }

    public void setTeams(Set<Team> teams) {
        this.teams = teams;
    }

    public void addTeam(Team team) {
        this.teams.add(team);
    }
    
    public void removeTeam(Team team) {
        this.teams.remove(team);
    }
    
    @Override
    public String toString() {
        boolean first=true;
        String r="Contact: id:"+id+", name:"+name+", lastName:"+lastname+", address:"+address+", phones [";
        for (Phone p:phones) {
            if (!first) r+=", "; else first=false;
            r+=p.getId();
        }
        r+="], Teams [";
        first=true;
        for (Team g:teams) {
            if (!first) r+=", "; else first=false;
            r+=g.getId();
        }
        r+="]";
        return r;
    }
}
