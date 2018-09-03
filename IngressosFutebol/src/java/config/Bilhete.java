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
/**
 *
 * @author Lucas Nunes
 */
public class Bilhete {
    static final String DRIVER="com.mysql.jdbc.Driver";
    static final String CAMINHO= "jdbc:mysql://localhost/futebol";
    public Bilhete(String nome,String cpf,int camarote,int setorA,  int setorB,int setorC,int numJogo) throws ClassNotFoundException, SQLException{
        setBilhete(nome,cpf,camarote,setorA,setorB,setorC,numJogo);
        if(camarote!=0) Ingressos.setCamarote(1, numJogo, camarote);
        if(setorA!=0) Ingressos.setSetorA(1,numJogo, setorA);
        if(setorB!=0) Ingressos.setSetorB(1,numJogo, setorB);
        if(setorC!=0) Ingressos.setSetorC(1,numJogo, setorC);
    }
    public static void setBilhete(String nome,String cpf,int camarote,int setora,  int setorb,int setorc,int numJogo) throws ClassNotFoundException, SQLException{
                        Connection conect;
           Class.forName( DRIVER );
	            conect = (Connection) DriverManager.getConnection( CAMINHO, 
                            "root", "admin" );
	            Statement st =  (Statement) conect.createStatement();
          String  sql = "INSERT INTO futebol.bilhete (`nome`, `cpf`, `camarote`, `setora`, `setorb`, `setorc`,`jogo`)  VALUES ('" +nome+"','"+cpf +"','"+camarote + "','"+setora+"','"+setorb+"','"+setorc+"','"+numJogo+"')";
          st.executeUpdate(sql);
          
    }
    public static void removerBilhete(int codbilhete) throws ClassNotFoundException, SQLException{
                        Connection conect;
           Class.forName( DRIVER );
	            conect = (Connection) DriverManager.getConnection( CAMINHO, 
                            "root", "admin" );
	            Statement st =  (Statement) conect.createStatement();
            ResultSet prox = st.executeQuery(
	                "SELECT * " +
	                "FROM bilhete " +
                        "WHERE" +
                        "(idbilhete='"+codbilhete+"')" +  
	                "ORDER BY nome" );prox.next();
                    if(prox.getInt(4)!=0) Ingressos.setCamarote(2,prox.getInt(8) , prox.getInt(4));
        if(prox.getInt(5)!=0) Ingressos.setSetorA(2,prox.getInt(8), prox.getInt(5));
        if(prox.getInt(6)!=0) Ingressos.setSetorB(2,prox.getInt(8), prox.getInt(6));
        if(prox.getInt(7)!=0) Ingressos.setSetorC(2,prox.getInt(8), prox.getInt(7));
            String sql = "DELETE FROM `futebol`.`bilhete` WHERE `idbilhete`='"+prox.getInt(1)+"';";
            st.executeUpdate(sql);
    }
    public static int numeroBilhete(String nome) throws ClassNotFoundException, SQLException{
                                Connection conect;
           Class.forName( DRIVER );
	            conect = (Connection) DriverManager.getConnection( CAMINHO, 
                            "root", "admin" );
	            Statement st =  (Statement) conect.createStatement();
            ResultSet prox = st.executeQuery(
	                "SELECT * " +
	                "FROM bilhete " +
                        "WHERE (nome ='"+nome+"')"+
	                "ORDER BY idbilhete" );
            int i=0;while(prox.next()){
                 i=prox.getInt(1);
            }
            return i;
    }
    public static void main(String Args[]) throws ClassNotFoundException, SQLException{
       
    }
    
}
