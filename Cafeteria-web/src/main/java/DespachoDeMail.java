import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 *
 * @author Lecho
 */
@WebServlet(name = "DespachoDeMail", urlPatterns = {"/DespachoDeMail"})
public class DespachoDeMail extends HttpServlet {
    
    @EJB
    private MailSenderBean mailsender;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        
        String fromEmail = "Lechofa@gmail.com";
        String username = "Lechofa";
        String password = "gerbomaligno00";
        
        
        String ID = "5";
        String nombre = "Pepito";
        String metodoDePago = "Junaeb";
        String calle = "Lo Soprano";
        String numCalle= "6666";
        String ciudad = "Santiago";
        String comuna = "Puente Alto";
        String nroContacto = "90939916";
        String correo = "Lechofa@hotmail.com";
        
        
        
        String toEmail = "Lechofa@hotmail.com"; //GetFrom Campo seleccionado
        String subject = "Orden de comida ID "; //Automatico + ID del pedido
        String message; //Aca añadir toda la cadena de informacion
                        //A medida q se sacan los campos del resto de las paginas pongo Message = Message + info
        
        
        
        
        
        message = "Gracias "+ nombre +" por su compra,\n";
        message += "su pedido posee el ID "+ ID + "\n";
        message += "su pedido ha sido pagado por medio de "+metodoDePago+"\n";
        message += "el destino de su pedido corresponde a : " +calle+" "+numCalle+" "+ciudad+" "+comuna+"\n";
        message += "su número de contacto es el: "+nroContacto+"\n";
        message += "aca se incluye la comida mucha comida c:\n";
        message += "mensaje enviado al correo: "+correo+"\n";
        message += "Muchas gracias por preferirnos c:";
        
        
        
            
        
        
        try (PrintWriter out = response.getWriter()) {
            
            
            mailsender.sendEmail(fromEmail, username, password, toEmail, subject, message);
            
            
            out.println("<?xml version='1.0' encoding='UTF-8' ?>");
            out.println("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">");
            out.println("<html xmlns=\"http://www.w3.org/1999/xhtml\"");
            out.println("xmlns:h=\"http://xmlns.jcp.org/jsf/html\">");
            out.println("<h:head>");
            out.println("<title>Mail Status</title>");
            out.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">");
            out.println("</h:head>");
            out.println("<body>");
            out.println("<h1>Mail Status</h1>");
            out.println("<b>Email con la información de su pedido ha sido enviado exitosamente!!!!!!!!</b><br>");
            out.println("<h:link outcome=\"/index\" value=\"Paginas de prueba\"/>");
            out.println("</body>");
            out.println("</html>");
        }
    }
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
