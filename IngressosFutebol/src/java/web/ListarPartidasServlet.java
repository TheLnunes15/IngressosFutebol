/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 *
 * @author Lucas Nunes
 */
@WebServlet(urlPatterns = {"/ListarPartidasServlet"})
public class ListarPartidasServlet extends HttpServlet {
    static final String DRIVER="com.mysql.jdbc.Driver";
    static final String CAMINHO= "jdbc:mysql://localhost/futebol";
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
           Connection conect;
           Class.forName( DRIVER );
	            conect = (Connection) DriverManager.getConnection( CAMINHO, 
                            "root", "admin" );
	            Statement st =  (Statement) conect.createStatement();
            ResultSet prox = st.executeQuery(
	                "SELECT * " +
	                "FROM jogos " +
	                "ORDER BY numJogo");
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
        out.println("<style type=\"text/css\">\n" +
"* {\n" +
"padding: 0px;\n" +
"margin: 0px;\n" +
"}\n" +
"\n" +
"html, body {\n" +
"height: 100%;\n" +
"}\n" +
"\n" +
"#page {\n" +
"min-height: 100%;\n" +
"position: relative;\n" +
"}\n" +
"\n" +
"#footer {\n" +
"width: 100%;\n" +
"bottom: 0px;\n" +                    
"position: absolute;\n" +
"}"+"body {background-color:beige; color:white;font-weight: bold;}\n" +
"   td   {font-size: 90%; background-color:white; color: black;} \n" +
"   input {background-color:white}"+
"</style>");
            out.println("<title>Partidas</title>");            
            out.println("</head>");

            out.println("<body background=\"imagens/campo_futebol.jpg\"><div id=\"page\"> <div id=\"content\">");
            out.println("<h1>Clique em Detalhes para selecionar a partida</h1>");
            while(prox.next()){
                 out.println("<br/><center><form name='form1' action='CompraIngressosServlet' method='post'>");
                 out.println("<input type='hidden' name='jogo' value='"+prox.getInt(1)+"'>");
              
                 out.println("<table bgcolor='beige' cellspacing='4' width='40%' border='1'>");
             
                 out.println("<td valign='top' align='left' width='40%'><center>" + 
                          "<font size='2' face='Tahoma'>");
                 out.println("<b>Código do jogo: " + prox.getInt(1) + 
                             "<br/>Partida: " + prox.getString(2)+"  x  "+ prox.getString(3) +
                             "<br/>Local: " + prox.getString(4)+
                             "<br/>Horário: " +prox.getString(5) +" horas" +
                             "<br/>Data: " + prox.getString(6));
                 out.println("<br/><input type='hidden' value='Comprar'></form></center>");
                                  
                 out.println("<center><form name='form2' action='PartidaDetalhes' method='post'>"
                         + "<input type='hidden' name='jogo' value='"+prox.getInt(1)+"'>"+
                         "<input type='submit' value='Detalhes'>");            
                 out.println("</b></center></td></tr>");
                 out.println("</table></br>");
            }
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
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ListarPartidasServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ListarPartidasServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ListarPartidasServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ListarPartidasServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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
