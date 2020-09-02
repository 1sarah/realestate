package esta.fixs.database;

import esta.hibernate.example.*;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/save"})
public class servlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Session session = HibernateHelper.getSessionFactory().openSession();
        Transaction tx = session.getTransaction();
        tx.begin();
//        Landlord landlord = new  Landlord();
//        landlord.setPerson(new Person());
//        landlord.setContact(new Contact());
//        landlord.getPerson().setName("Eugenia");
//        landlord.getPerson().setGender(Gender.FEMALE);
//        landlord.getContact().setEmail("eugenia@mail.com");
//        landlord.getPerson().setIdNo("4234325");
//        landlord.getContact().setAddress("dwfaef");
//        landlord.getContact().setCountry("Kenya");
//        landlord.getContact().setPhoneNo("45436363");
//        landlord.getContact().setTown("fhhgewfef");
//        landlord.getPerson().setIdNo("232425");
//        session.save(landlord);
//
//        Tenant tenant = new  Tenant();
//        tenant.setPerson(new Person());
//        tenant.setContact(new Contact());
//        tenant.getPerson().setName("Mbuya");
//        tenant.getPerson().setGender(Gender.FEMALE);
//        tenant.getContact().setEmail("eugenias@mail.com");
//        tenant.getPerson().setIdNo("423425");
//        tenant.getContact().setAddress("dwfaf");
//        tenant.getContact().setCountry("Kinya");
//        tenant.getContact().setPhoneNo("4543363");
//        tenant.getContact().setTown("fhhgwfef");
//        tenant.getPerson().setIdNo("22425");
//        session.save(tenant);
//
//
//        House house = new House();
//        house.setContact(new Contact());
//        house.getContact().setEmail("eugenias@mail.com");
//        house.getContact().setAddress("dwfaf");
//        house.getContact().setCountry("Kinya");
//        house.getContact().setPhoneNo("4543363");
//        house.getContact().setTown("fhhgwfef");
//       session.save(house);
//
//
//        Plot plot = new  Plot();
//        plot.setContact(new Contact());
//        plot.getContact().setEmail("eugnias@mail.com");
//        plot.getContact().setAddress("dfaf");
//        plot.getContact().setCountry("Kiya");
//        plot.getContact().setPhoneNo("443363");
//        plot.getContact().setTown("fhgwfef");
//        plot.getPlot_no("001");
//        session.save( plot);


        Payment payment = new Payment();
        String names = request.getParameter("sname");
        String card = request.getParameter("scard");
        String location = request.getParameter("slocation");
        String price = request.getParameter("sprice");

        payment.setNames(names);
        payment.setCard_no(card);
        payment.setLand_location(location);
        payment.setPrice(price);
        session.save(payment);
        tx.commit();
        response.getWriter().println("Your payments details has been received please chech you email for verification");
    }

//    catch (Exception e){
//        // TODO: handle exception properly
//        response.getWriter().println("An error has occurred..Try again");
//        e.printStackTrace();
//    }
}
//    }

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
//}
