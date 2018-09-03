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
import config.Ingressos;
/**
 *
 * @author Lucas Nunes
 */
@WebServlet(name = "CompraIngressosServlet", urlPatterns = {"/CompraIngressosServlet"})
public class CompraIngressosServlet extends HttpServlet {
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
     * @throws java.sql.SQLException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ClassNotFoundException {
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
            out.println("<title>Compra do ingresso</title>");            
            out.println("</head>");
            out.println("<body background=\"imagens/fila_ingressos.jpg\"><div id=\"page\"> <div id=\"content\">");
            out.println("<h1>Digite o seu nome, CPF e o número de ingressos que deseja comprar</h1>");
            out.println("</br><form name='form1' action='GeraBilheteServlet' method='post'>");
            out.println("Nome: <input type='text' name='nome'>");
            out.println("<br/>CPF: <input type='text' name='cpf'><br/>");
            out.println("</br><table border=1 bgcolor=black> \n" +
"<TR>\n" +
"<TH>Preços</TH>\n" +
"</TR>\n" +
"<TH> Camarote: R$300.00 reais<br/> Setor A: R$150.00 reais<br/> Setor B: R$100.00 reais<br/> Setor C: R$50.00 reais</TH>"+
"</TR>");
            out.println("<table bgcolor='beige' cellspacing='2' width='40%' border='1'><center>");
            prox.next();
                 out.println("<td valign='top' align='left' width='86%'>" + 
                          "<font size='2' face='Tahoma'>");
                 out.println("<b>Código do jogo: " + prox.getInt(1) + 
                             "<br/>Partida: " + prox.getString(2)+"  x  "+ prox.getString(3) +
                             "<br/>Local: " + prox.getString(4)+
                             "<br/>Horário: " + prox.getString(5) +" horas" +
                             "<br/>Data: " + prox.getString(6));            
                  
                  out.println("<input type='hidden' name='jogo' value='"+prox.getInt(1)+"'>"+
                          "<input type='hidden' name='time1' value='"+prox.getString(2)+"'>"+
                          "<input type='hidden' name='time2' value='"+prox.getString(3)+"'>"+
                  "<br/>Camarote: <input type='text' name='camarote'> ("+ Ingressos.getFreeSetor(1,jogo)+ "disponiveis)"+
                   "<br/>Setor A: <input  type='text' name='setora'> ("+ Ingressos.getFreeSetor(2,jogo)+ "disponiveis)"+
                    "<br/>Setor B: <input  type='text' name='setorb'>("+ Ingressos.getFreeSetor(3,jogo)+ "disponiveis)"+
                    "<br/>Setor C: <input  type='text' name='setorc'>(" + Ingressos.getFreeSetor(4,jogo)+ "disponiveis)"+
                   "<br/><br /><input type='submit' value='Comprar'>"+
                 "</form>");
                  
                 out.println("</center></table>");
            out.println("<br/><form name='form2' action='ListarPartidasServlet' method='post'>"+
                    "<input type='submit' value='Selecionar outra partida'>");
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
    } catch (SQLException ex) {
        Logger.getLogger(CompraIngressosServlet.class.getName()).log(Level.SEVERE, null, ex);
    } catch (ClassNotFoundException ex) {
        Logger.getLogger(CompraIngressosServlet.class.getName()).log(Level.SEVERE, null, ex);
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
    } catch (SQLException ex) {
        Logger.getLogger(CompraIngressosServlet.class.getName()).log(Level.SEVERE, null, ex);
    } catch (ClassNotFoundException ex) {
        Logger.getLogger(CompraIngressosServlet.class.getName()).log(Level.SEVERE, null, ex);
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
