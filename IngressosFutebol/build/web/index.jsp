<%-- 
    Document   : index
    Created on : 11/12/2015, 12:02:11
    Author     : Lucas Nunes
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
          <style type="text/css">
	footer {
    position: absolute; 
    bottom: 0px; 
    width: 100%; 
    height: 50px; 
}

   body {background-color:beige; color:white;font-weight: bold;}
   input {background-color:white}
   </style>
        <title>Ingressos de futebol</title>
    </head>
    <body background="imagens/campo_futebol.jpg">
        <h1>Venda de ingressos para os jogos do Campeonato Brasileiro 2015</h1>
        <br/> Selecione uma das opções:
        <table bgcolor='beige' cellspacing='8' width='100%' border='1'>
            <tr><td><center><form action="ListarPartidasServlet" method="post">
                    <input type="submit" value="Deseja solicitar a compra?"></form></center></td>              
                <td><center><form action="CancelarCompra.jsp" method="post">
                    <input type="submit" value="Deseja cancelar a compra?"></form></center></td></tr>
        </table>
    </body>
</html>
