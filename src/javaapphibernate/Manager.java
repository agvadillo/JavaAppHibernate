package javaapphibernate;

import java.util.List;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Avk
 */
public class Manager {
    
    private Session session=null;
    private Transaction tx=null;
    
    private void beginTransaction() throws HibernateException {
        session = HibernateUtil.getOpenSession();
        tx = session.beginTransaction();
    }

    private void successTransaction() throws HibernateException {
        tx.commit();
    }

    private void failedTransaction() throws HibernateException {
        tx.rollback();
    }

    public void insert(Contact c) { 
        try { 
            beginTransaction();
            session.save(c);
            successTransaction();
        } catch(HibernateException e) { 
           failedTransaction();
           System.out.println(e);
        }  
    }
 
    public void insert(Team d) { 
        try { 
            beginTransaction();
            session.save(d);
            successTransaction();
        } catch(HibernateException e) { 
           failedTransaction();
           System.out.println(e);
        }  
    }
 
    public void insert(ContactAnnotation c) { 
        try { 
            beginTransaction();
            session.save(c);
            successTransaction();
        } catch(HibernateException e) { 
           failedTransaction();
           System.out.println(e);
        }  
    }
 
    public void update(Contact c) { 
        try { 
            beginTransaction();            
            session.update(c);
            successTransaction();
        } catch(HibernateException e) { 
           failedTransaction();
           System.out.println(e);
        }
    }
 
    public void update(TeamAnnotation d) { 
        try { 
            beginTransaction();            
            session.update(d);
            successTransaction();
        } catch(HibernateException e) { 
           failedTransaction();
           System.out.println(e);
        }
    }
 
    public void update(ContactAnnotation c) { 
        try { 
            beginTransaction();            
            session.update(c);
            successTransaction();
        } catch(HibernateException e) { 
           failedTransaction();
           System.out.println(e);
        }
    }
 
    public void delete(Contact c) { 
        try { 
            beginTransaction();            
            session.delete(c);
            successTransaction();
        } catch(HibernateException e) { 
           failedTransaction();
           System.out.println(e);
        } 
    }
 
    public void delete(ContactAnnotation c) { 
        try { 
            beginTransaction();            
            session.delete(c);
            successTransaction();
        } catch(HibernateException e) { 
           failedTransaction();
           System.out.println(e);
        } 
    }
 
    public void delete(TeamAnnotation d) { 
        try { 
            beginTransaction();            
            session.delete(d);
            successTransaction();
        } catch(HibernateException e) { 
           failedTransaction();
           System.out.println(e);
        } 
    }
 
    public void delete(Phone p) { 
        try { 
            beginTransaction();            
            session.delete(p);
            successTransaction();
        } catch(HibernateException e) { 
           failedTransaction();
           System.out.println(e);
        } 
    }
 
    public Contact getContact(long idContact, boolean lazy) { 
        Contact c=null;
        try { 
            beginTransaction();            
            c=session.get(Contact.class, idContact);
            successTransaction();
        } catch(HibernateException e) { 
           failedTransaction();
           System.out.println(e);
        }
        return c;
    }
 
    public Contact getContact(long idContact) { 
        return getContact(idContact, false);
    }
 
    public Phone getPhone(long idPhone) { 
        Phone p=null;
        try { 
            beginTransaction();            
            p=session.get(Phone.class, idPhone);
            successTransaction();
        } catch(HibernateException e) { 
           failedTransaction();
           System.out.println(e);
        }
        return p;
    }
 
    public TeamAnnotation getGroup(long idGroup, boolean lazy) { 
        TeamAnnotation g=null;
        try { 
            beginTransaction();            
            g=session.get(TeamAnnotation.class, idGroup);
            if (lazy) {
                Hibernate.initialize(g.getContacts());
            }

            successTransaction();
        } catch(HibernateException e) { 
           failedTransaction();
           System.out.println(e);
        }
        return g;
    }
 
    public List<Contact> getContacts(boolean lazy) { 
        List<Contact> contacts=null;
        try { 
            beginTransaction();
            contacts=session.createQuery(" from javaapphibernate.Contact ").list();
            if (lazy) {
                for (Contact c:contacts){
                    Hibernate.initialize(c.getPhones());
                }
            }

            successTransaction();
        } catch(HibernateException e) { 
           failedTransaction();
           System.out.println(e);
        }
        return contacts;
    }
    
    public List<Contact> getContacts() { 
        return getContacts(false);
    }
    
    public List<ContactAnnotation> getContactsAnnotation() { 
        List<ContactAnnotation> contacts=null;
        try { 
            beginTransaction();
            contacts=session.createQuery(" from javaapphibernate.ContactAnnotation ").list();
            successTransaction();
        } catch(HibernateException e) { 
           failedTransaction();
           System.out.println(e);
        }
        return contacts;
    }    
}
