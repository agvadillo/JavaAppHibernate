package javaapphibernate;

import java.util.List;

/**
 *
 * @author Avk
 */
public class JavaAppHibernateAnnotation {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        HibernateUtil.loadResource(ContactAnnotation.class);
        HibernateUtil.loadResource(PhoneAnnotation.class);
        HibernateUtil.loadResource(TeamAnnotation.class);

        Manager manager=new Manager();

        ContactAnnotation c1=new ContactAnnotation("c1Name2", "c1Lastname", "c1Address");
        PhoneAnnotation p11=new PhoneAnnotation(111111, c1);
        c1.addPhone(p11);
        PhoneAnnotation p12=new PhoneAnnotation(111112, c1);
        c1.addPhone(p12);
        TeamAnnotation g11=new TeamAnnotation("Team11");
        c1.addTeam(g11);
        manager.insert(c1);

        c1.removePhone(p12);
        manager.update(c1);
        
        TeamAnnotation g12=new TeamAnnotation("Team12");
        c1.addTeam(g12);
        manager.update(c1);
        
        c1.removeTeam(g11);
        manager.update(c1);

        ContactAnnotation c2=new ContactAnnotation("c2Name", "c2Lastname", "c2Address");
        manager.insert(c2);

        PhoneAnnotation p21=new PhoneAnnotation(111111, c2);
        c2.addPhone(p21);
        PhoneAnnotation p22=new PhoneAnnotation(222222, c2);
        c2.addPhone(p22);
        manager.update(c2);
        
        c2.setName("c3Name");
        c2.setLastname("c3Lastname");
        manager.update(c2);
        
        List<ContactAnnotation> contacts=manager.getContactsAnnotation();
        System.out.println("--------------------------------------------------");
        for (ContactAnnotation c:contacts){
            System.out.println(c);
        }
        
        HibernateUtil.closeSession();
        System.out.print("\nExecution successful!\n");
    }
}
