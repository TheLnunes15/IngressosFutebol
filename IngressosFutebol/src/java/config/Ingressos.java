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
public class Ingressos {
    static final String DRIVER="com.mysql.jdbc.Driver";
    static final String CAMINHO= "jdbc:mysql://localhost/futebol";
    public static int getFreeSetor(int setor,int numJogo) throws ClassNotFoundException, SQLException{
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
	                "ORDER BY num" );
            prox.next();
            int retorno;
            switch(setor){
                case 1: retorno= 500-prox.getInt(3);break;// camarote
                case 2: retorno= 5000-prox.getInt(4);break;// setor a
                case 3: retorno= 10000-prox.getInt(5);break;// setor b
                case 4: retorno= 15000-prox.getInt(6);break;// setor c
                default: retorno=-1;//erro 
            }
            return retorno;
    }
    public static void setCamarote(int op,int numJogo,int mudar) throws ClassNotFoundException, SQLException{
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
	                "ORDER BY num" );
            prox.next();
            if (op==1){ // soma ingressos
                String sql="UPDATE `futebol`.`ingressos` SET `camarote`='"+(prox.getInt(3)+mudar)+"' WHERE `num`='"+numJogo+"';";
                st.executeUpdate(sql);
            }
            if (op==2){ // subtrai ingressos
                String sql="UPDATE `futebol`.`ingressos` SET `camarote`='"+(prox.getInt(3)-mudar)+"' WHERE `num`='"+numJogo+"';";
                st.executeUpdate(sql);
            }
    }
        public static void setSetorA(int op,int numJogo,int mudar) throws ClassNotFoundException, SQLException{
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
	                "ORDER BY num" );
            prox.next();
            if (op==1){
                String sql="UPDATE `futebol`.`ingressos` SET `setor a`='"+(prox.getInt(4)+mudar)+"' WHERE `num`='"+numJogo+"';";
                st.executeUpdate(sql);
            }
            if (op==2){
                String sql="UPDATE `futebol`.`ingressos` SET `setor a`='"+(prox.getInt(4)-mudar)+"' WHERE `num`='"+numJogo+"';";
                st.executeUpdate(sql);
            }
    }
        public static void setSetorB(int op,int numJogo,int mudar) throws ClassNotFoundException, SQLException{
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
	                "ORDER BY num" );
            prox.next();
            if (op==1){
                String sql="UPDATE `futebol`.`ingressos` SET `setor b`='"+(prox.getInt(5)+mudar)+"' WHERE `num`='"+numJogo+"';";
                st.executeUpdate(sql);
            }
            if (op==2){
                String sql="UPDATE `futebol`.`ingressos` SET `setor b`='"+(prox.getInt(5)-mudar)+"' WHERE `num`='"+numJogo+"';";
                st.executeUpdate(sql);
            }
    }
                public static void setSetorC(int op,int numJogo,int mudar) throws ClassNotFoundException, SQLException{
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
	                "ORDER BY num" );
            prox.next();
            if (op==1){
                String sql="UPDATE `futebol`.`ingressos` SET `setor c`='"+(prox.getInt(6)+mudar)+"' WHERE `num`='"+numJogo+"';";
                st.executeUpdate(sql);
            }
            if (op==2){
                String sql="UPDATE `futebol`.`ingressos` SET `setor c`='"+(prox.getInt(6)-mudar)+"' WHERE `num`='"+numJogo+"';";
                st.executeUpdate(sql);
            }
    }
     public static void main(String args[]) throws ClassNotFoundException, SQLException{

    }
}
