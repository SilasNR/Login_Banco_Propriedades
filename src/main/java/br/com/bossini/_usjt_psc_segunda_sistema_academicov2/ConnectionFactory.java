/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.bossini._usjt_psc_segunda_sistema_academicov2;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

/**
 *
 * @author rodrigo
 */
public class ConnectionFactory {
    private String host, port, db, user, password;
    public ConnectionFactory(
        String host,
        String port,
        String db,
        String user,
        String password
    ){
      this.host = host;
      this.port = port;
      this.db = db;
      this.user = user;
      this.password = password;
    }
    
    public Connection conectar() throws Exception{
        return DriverManager.getConnection(
            String.format("jdbc:postgresql://%s;%s/%s",
                    host,
                    port,
                    db
            ),
            user,
            password
        );
    };
    
        
    public static void main(String[] args)throws Exception {
        var properties = new Properties();
        properties.load(
                new FileInputStream(new File("conf.properties"))
        );
        final String DB_HOST = properties.getProperty("DB_HOST");
        final String DB_PORT = properties.getProperty("DB_PORT");
        final String DB_NAME = properties.getProperty("DB_NAME");
        final String DB_USER = properties.getProperty("DB_USER");
        final String DB_PASSWORD = properties.getProperty("DB_PASSWORD");
        var fabrica = new ConnectionFactory(
                DB_HOST,
                DB_PORT,
                 DB_NAME,
                DB_USER,
             DB_PASSWORD);
        
        System.err.println(fabrica.conectar());
    }
        
   
   
}
