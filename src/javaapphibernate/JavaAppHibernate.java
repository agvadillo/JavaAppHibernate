package javaapphibernate;

import java.util.List;

/*
------------------------------------------------------
    Schema code generator
------------------------------------------------------
create schema javaapphibernate;

use javaapphibernate;

create table javaapphibernate.contact (
    `pk_id_contact` bigint auto_increment,
    `name` varchar (50),
    `lastname` varchar (50),
    `address` varchar(100),
    primary key (`pk_id_contact`)
);

create table javaapphibernate.phone (
    `pk_id_phone` bigint auto_increment,
    `number` bigint,
    `fk_id_contact` bigint,
    primary key (`pk_id_phone`),
    foreign key (fk_id_contact) references javaapphibernate.contact(pk_id_contact) on update cascade
);

create table javaapphibernate.team (
    `pk_id_team` bigint auto_increment,
    `name` varchar(50),
    primary key (`pk_id_team`)
);

create table javaapphibernate.contact_team (
    `fk_id_contact` bigint,
    `fk_id_team` bigint,
    primary key (`fk_id_contact`,`fk_id_team`),
    foreign key (fk_id_contact) references javaapphibernate.contact(pk_id_contact) on update cascade,
    foreign key (fk_id_team) references javaapphibernate.team(pk_id_team) on update cascade
);

/**
 *
 * @author Avk
 */
public class JavaAppHibernate {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        HibernateUtil.loadResource("mappers/Contact.hbm.xml");
        HibernateUtil.loadResource("mappers/Phone.hbm.xml");
        HibernateUtil.loadResource("mappers/Team.hbm.xml");

        Manager manager=new Manager();

        Contact c1=new Contact("c1Name2", "c1Lastname", "c1Address");
        Phone p11=new Phone(111111, c1);
        c1.addPhone(p11);
        Phone p12=new Phone(111112, c1);
        c1.addPhone(p12);
        manager.insert(c1);

        c1.removePhone(p12);
        manager.update(c1);

        Team t11=new Team("Team11");
        c1.addTeam(t11);
        Team t12=new Team("Team12");
        c1.addTeam(t12);
        manager.update(c1);
        
        c1.removeTeam(t11);
        manager.update(c1);

        Contact c2=new Contact("c2Name", "c2Lastname", "c2Address");
        manager.insert(c2);

        Phone p21=new Phone(111111, c2);
        c2.addPhone(p21);
        Phone p22=new Phone(222222, c2);
        c2.addPhone(p22);
        manager.update(c2);
        
        c2.setName("c3Name");
        c2.setLastname("c3Lastname");
        manager.update(c2);
        
        List<Contact> contacts=manager.getContacts(true);
        System.out.println("--------------------------------------------------");
        for (Contact c:contacts){
            System.out.println(c);
        }
        
        HibernateUtil.closeSession();
        System.out.print("\nExecution successful!\n");
    }
}
