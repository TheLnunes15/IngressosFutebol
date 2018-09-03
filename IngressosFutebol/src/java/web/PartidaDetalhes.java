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
import config.Funcional;
import config.Ingressos;
/**
 *
 * @author Lucas Nunes
 */
@WebServlet(name = "PartidaDetalhes", urlPatterns = {"/PartidaDetalhes"})
public class PartidaDetalhes extends HttpServlet {
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
        int jogo=Integer.parseInt(request.getParameter("jogo"));
        try (PrintWriter out = response.getWriter()) {
                        Connection conect;
           Class.forName( DRIVER );
	            conect = (Connection) DriverManager.getConnection( CAMINHO, 
                            "root", "admin" );
	            Statement st =  (Statement) conect.createStatement();
            ResultSet prox = st.executeQuery(
	                "SELECT * " +
	                "FROM jogos " +
                       "WHERE" +
                        "(numJogo='"+jogo+"')" +  
	                "ORDER BY numJogo" );
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
            out.println("<title>Detalhes da partida</title>");            
            out.println("</head>");
            out.println("<body background=\"imagens/campo_futebol.jpg\"><div id=\"page\"> <div id=\"content\">");
            out.println("<h1>Público e renda atual da partida</h1>");
            out.println("<br/><br/><table bgcolor='beige' cellspacing='2' width='40%' border='1'>");
            prox.next();
                 out.println("<tr>");
                 out.println("<td valign='top' align='left' width='40%'><center>" + 
                          "<font size='2' face='Tahoma'>");
                 out.println("<b>Código do jogo: " + prox.getInt(1) + 
                             "<br/>Partida: " + prox.getString(2)+"  x  "+ prox.getString(3) +
                             "<br/>Local: " + prox.getString(4)+
                             "<br/>Horário: " + prox.getString(5) +" horas" +
                             "<br/>Data: " + prox.getString(6));            
                  out.println("<br/>Camarote: "+ (500-Ingressos.getFreeSetor(1,jogo))+ " pagante(s) com renda de R$"+Funcional.getRenda(1, jogo)+" reais." +
                   "<br/>Setor A: "+(5000-Ingressos.getFreeSetor(2,jogo))+ " pagante(s) com renda de R$"+Funcional.getRenda(2, jogo)+" reais." +
                    "<br/>Setor B: "+(10000-Ingressos.getFreeSetor(3,jogo))+" pagante(s) com renda de R$"+Funcional.getRenda(3, jogo)+" reais." +
                    "<br/>Setor C: "+(15000-Ingressos.getFreeSetor(4,jogo))+" pagante(s) com renda de R$"+Funcional.getRenda(4, jogo)+" reais." +
                      "<br/> Renda total: R$"+ Funcional.getRenda(0, jogo) +" reais." );
                  
                 out.println("</b></center></td></tr>");
                 out.println("</table>");
                 out.println("</div><br/><form name='form1' action='CompraIngressosServlet' method='post'>"
                         + "<input type='hidden' name='jogo' value='"+jogo+"'>"
                         + "<input type='submit'  value='Comprar ingresso'>"
                         + "</form></br>");
                 out.println("<form action='index.jsp' method='post'>"
                    + "<input type='submit' value='Página inicial'></form>");
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
        Logger.getLogger(PartidaDetalhes.class.getName()).log(Level.SEVERE, null, ex);
    } catch (SQLException ex) {
        Logger.getLogger(PartidaDetalhes.class.getName()).log(Level.SEVERE, null, ex);
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
        Logger.getLogger(PartidaDetalhes.class.getName()).log(Level.SEVERE, null, ex);
    } catch (SQLException ex) {
        Logger.getLogger(PartidaDetalhes.class.getName()).log(Level.SEVERE, null, ex);
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
