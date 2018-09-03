<%-- 
    Document   : CancelarCompra
    Created on : 11/12/2015, 12:06:46
    Author     : Lucas Nunes
--%>

<%@page import="config.Bilhete"%>
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
    height: 60px; 
}

   body {background-color:beige; color:white;font-weight: bold;}
   input {background-color:white}
   </style>
        <title>Cancelar Bilhete</title>
           <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script>
$(document).ready(function(){
  $('#submit').click(function(event) { 
    var codBilhete = $('#c1').val();
    $.post("CancelaBilhete",
    {
      bilhete:codBilhete
    },
    function(data,status){
        $("#destino").html(data); // exibe a página HTML recebida
    });
  });
});
</script>
    </head>
    <body background="imagens/fila_ingressos.jpg">
        <h1>Digite o número do bilhete para o cancelamento</h1>
     <form>
        Digite o número:<br/>
        <input type="text" name="num" size="30" id="c1"/><br/>
        <br/>
        <input type="button" id="submit" value="Enviar"/>
     </form><br/>
     <div id="destino"></div>
     <form action='index.jsp' method='post'>
        <input type='submit' value='Página inicial'></form>
    </body>  
</html>
