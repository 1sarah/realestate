package esta.fixs.database;

import esta.hibernate.example.Contact;
import esta.hibernate.example.Gender;
import esta.hibernate.example.Landlord;
import esta.hibernate.example.Person;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/create-tables"})
public class servlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Session session = HibernateHelper.getSessionFactory().openSession();
        Transaction tx = session.getTransaction();
        tx.begin();
        Landlord landlord = new  Landlord();
        landlord.setPerson(new Person());
        landlord.setContact(new Contact());
        landlord.getPerson().setName("Eugenia");
        landlord.getPerson().setGender(Gender.FEMALE);
        landlord.getContact().setEmail("eugenia@mail.com");
        landlord.getPerson().setIdNo("4234325");
        landlord.getContact().setAddress("dwfaef");
        landlord.getContact().setCountry("Kenya");
        landlord.getContact().setPhoneNo("45436363");
        landlord.getContact().setTown("fhhgewfef");
        landlord.getPerson().setIdNo("232425");
        session.save(landlord);
    }

//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        Session session = HibernateHelper.getSessionFactory().getCurrentSession();
//        Transaction tx = session.getTransaction();
//        try {
//            tx.begin();
//            Tenants tenants = new Tenants();
//            tenants.getContact().setEmail("sarah@tracom.com");
//            tenants.getPerson().setName("Sarah");
//
//            session.save(tenants);
//            response.getWriter().println("Data saved successfully!!");
//            tx.commit();
//        }catch (Exception e){
//            // TODO: handle exception properly
//            response.getWriter().println("An error has occurred");
//            e.printStackTrace();
//        }
//    }
}
