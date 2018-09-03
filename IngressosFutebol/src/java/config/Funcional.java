/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
/**
 *
 * @author Lucas Nunes
 */
public class Funcional {
    static final String DRIVER="com.mysql.jdbc.Driver";
    static final String CAMINHO= "jdbc:mysql://localhost/futebol";
    public static int getRenda(int setor,int numJogo) throws ClassNotFoundException, SQLException{
        int retorno=0;   
        Connection conect;
           Class.forName( DRIVER );
	   conect = (Connection) DriverManager.getConnection( CAMINHO, 
                            "root", "admin" );
	            Statement st =  (Statement) conect.createStatement();
            ResultSet prox = st.executeQuery(
	                "SELECT * " +
	                "FROM ingressos " +
                       "WHERE" +
                        "(codjogo='"+ numJogo+"')" +  
	                "ORDER BY num" );prox.next();
            switch(setor){
                case 0: retorno=(prox.getInt(3)*300)+(prox.getInt(4)*150)+(prox.getInt(5)*100)+(prox.getInt(6)*50);break;//renda total
                case 1: retorno = prox.getInt(3)*300;break;//camarote
                case 2: retorno = prox.getInt(4)*150;break;//setor A
                case 3: retorno = prox.getInt(5)*100;break;// setor B
                case 4: retorno = prox.getInt(6)*50;break;// setor C
                default: retorno = -1;// erro
            }
    return retorno;
    }
      public static String getComprovante(){
      String temp,retorno;
      Date dataAtual = new Date();
      temp=dataAtual.toLocaleString();
      retorno = "Bilhete emitido em: " + temp.substring(0,temp.indexOf(" "))+" - "+temp.substring(temp.indexOf(" "));
      return retorno;
  }
    public static void main(String args[]) throws ClassNotFoundException, SQLException{
        System.out.println(getComprovante());
       
    }
}
