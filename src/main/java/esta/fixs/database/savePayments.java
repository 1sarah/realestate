//package esta.fixs.database;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import esta.hibernate.example.Payment;
//import org.hibernate.Session;
//import org.hibernate.Transaction;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.util.List;
//
//@WebServlet(urlPatterns = { "/payments" })
//public class savePayments {
//    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        Session session = HibernateHelper.getSessionFactory().openSession();
//        Transaction tx = session.getTransaction();
//        try {
//            tx.begin();
//            Payment payment = new Payment();
//            int id = Integer.parseInt(request.getParameter("sid"));
//            String names = request.getParameter("sname");
//            String card = request.getParameter("scard");
//            String location = request.getParameter("slocation");
//            String price = request.getParameter("sprice");
//            payment.setId(id);
//            payment.setNames(names);
//            payment.setCard_no(card);
//            payment.setLand_location(location);
//            payment.setPrice(price);
//            session.save(payment);
//            response.getWriter().println("Your payments details has been received please chech you email for verification");
//            tx.commit();
//        }catch (Exception e){
//            // TODO: handle exception properly
//            response.getWriter().println("An error has occurred..Try again");
//            e.printStackTrace();
//        }
//
//    }

//    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        Session session = HibernateHelper.getSessionFactory().getCurrentSession();
//        Transaction tx = session.getTransaction();
//        try {
//            tx.begin();
//            List<Student> students = session.createQuery("From Student r").getResultList();
//            //List<Student> students = session.createCriteria(Student.class).list();
//            ObjectMapper json = new ObjectMapper();
//            response.getWriter().println(json.writeValueAsString(students));
//            tx.commit();
//        }catch (Exception e){
//            // TODO: handle exception properly
//            response.getWriter().println("An error has occurred");
//            e.printStackTrace();
//        }
//    }


//}


