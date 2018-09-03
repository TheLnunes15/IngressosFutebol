/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import config.Bilhete;
import config.Funcional;
import config.Ingressos;
/**
 *
 * @author Lucas Nunes
 */
@WebServlet(name = "GeraBilheteServlet", urlPatterns = {"/GeraBilheteServlet"})
public class GeraBilheteServlet extends HttpServlet {
 
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
           int jogo=0;
           try{
               jogo=Integer.parseInt(request.getParameter("jogo"));
           }catch (Exception EX){
               
           }
    int camarote=0;
            try{camarote=Integer.parseInt(request.getParameter("camarote"));}catch(Exception Ex){
                camarote=0;
            }
    int setorA = 0;
try{
        setorA=Integer.parseInt(request.getParameter("setora"));}catch(Exception Ex){
            setorA=0;
                
                }
    int setorB=0;
    try{
        setorB=Integer.parseInt(request.getParameter("setorb"));}catch(Exception Ex){
            setorB=0;
    };
    int setorC =0;
    try{
    setorC=Integer.parseInt(request.getParameter("setorc"));;}catch(Exception EX){
        setorC=0;
    }
    String time1=request.getParameter("time1");
    String time2=request.getParameter("time2");
    String nome=request.getParameter("nome");
    String cpf=request.getParameter("cpf");    
   
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
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
            out.println("<title>Bilhete</title>");            
            out.println("</head>");
            out.println("<body background=\"imagens/fila_ingressos.jpg\"><div id=\"page\"> <div id=\"content\">");
            if((camarote-Ingressos.getFreeSetor(1,jogo))>0||(setorA-Ingressos.getFreeSetor(2,jogo))>0||(setorB-Ingressos.getFreeSetor(3,jogo))>0||(setorC-Ingressos.getFreeSetor(4,jogo))>0){
                out.println("Compra de ingressos acima do limite. Tente novamente!");
            }else{
                
            Bilhete.setBilhete(nome,cpf,camarote,setorA,setorB,setorC,jogo);
    
            Ingressos.setCamarote(1,jogo,camarote);
            Ingressos.setSetorA(1,jogo,setorA);
            Ingressos.setSetorB(1,jogo,setorB);
            Ingressos.setSetorC(1,jogo,setorC);  
                
            out.println("<h1>"+Funcional.getComprovante()+"</h1>");
            out.println("</br><table border=1 bgcolor=black> ");
            out.println("<tr><th>Dados do bilhete</th></tr><tr><th>");
            out.println("Bilhete nº: "+Bilhete.numeroBilhete(nome));
            out.println("<br/>Nome: "+nome);
            out.println("<br/>CPF: "+cpf);
            out.println("<br/>Código do jogo: " +jogo);
            out.println("<br/>Partida: "+time1+" x "+time2);
            if(camarote!=0)out.println("<br/>"+camarote+" Ingressos no Camarote");
            if(setorA!=0)out.println("<br/>"+setorA+" Ingressos no Setor A");
            if(setorB!=0)out.println("<br/>"+setorB+" Ingressos no Setor B");
            if(setorC!=0)out.println("<br/>"+setorC+" Ingressos no Setor C");       

            out.println("</th></tr>");
            out.println("</table>");}
            
            out.println("</br><form action='index.jsp' method='post'>"
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
            Logger.getLogger(GeraBilheteServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(GeraBilheteServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(GeraBilheteServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(GeraBilheteServlet.class.getName()).log(Level.SEVERE, null, ex);
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
