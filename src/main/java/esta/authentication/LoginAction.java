package esta.authentication;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.mindrot.jbcrypt.BCrypt;


import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(urlPatterns = {"/login"})
public class LoginAction extends HttpServlet {
    /**
     * Perform login request
     * @param request
     * @param response
     * @throws IOException
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String userName = request.getParameter("email");
        String userPassword = request.getParameter("password");
        String sql = "SELECT * FROM shule_yetus WHERE EMAIL = ?";
        PreparedStatement statement = null;
        ResultSet resultSet;
        try{
            statement.setString(1, userName);
            resultSet = statement.executeQuery();
            if(resultSet != null) {
                while (resultSet.next()) {
                    String name = resultSet.getString("NAME");
                    String email = resultSet.getString("EMAIL");
                    String hashedPassword = resultSet.getString("PASSWORD");
                    String role = resultSet.getString("ROLE");
                    if (BCrypt.checkpw(userPassword, hashedPassword)) {
                        HttpSession session = request.getSession();
                        session.setAttribute("name", name);
                        session.setAttribute("email", email);
                        session.setAttribute("password", hashedPassword);
                        session.setAttribute("role", role);
                        response.getWriter().println("authentication_success");
                    } else response.getWriter().println("authentication_failed");
                }
            }
            else response.getWriter().println("authentication_failed");

        }catch (SQLException sqlException){
            sqlException.printStackTrace();
            //TODO handle exception properly
        }finally {
            try {
                if (statement != null) statement.close();
            } catch (Exception e) {
                e.printStackTrace();
                //TODO handle exception properly
            }
        }
    }

    /**
     * Return user login session variables if set
     * @param request
     * @param response
     * @throws IOException
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = "";
        String role = "";
        HttpSession session = request.getSession(false);
        if(session != null) {
            name =(String)session.getAttribute("name");
            role =(String)session.getAttribute("role");
        }
        try {
            // create `ObjectMapper` instance
            ObjectMapper mapper = new ObjectMapper();
            // create a JSON object
            ObjectNode json = mapper.createObjectNode();
            json.put("name", name);
            json.put("role", role);
            // convert `ObjectNode` to pretty-print JSON
            // without pretty-print, use `user.toString()` method
            String data = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(json);
            response.getWriter().println(data);
        } catch (Exception ex) {
            ex.printStackTrace();
            //TODO handle properly
        }
    }
}
