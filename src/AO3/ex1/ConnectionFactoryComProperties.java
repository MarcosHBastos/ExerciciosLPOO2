/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package AO3.ex1;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rafae
 */
public class ConnectionFactoryComProperties {

  public Connection getConnection() throws SQLException {
      try {
          Properties prop = new Properties();
          
          prop.load(getClass().getResourceAsStream("/AO3/ex1/bancoDeDados.properties"));
          String dbDriver = prop.getProperty("db.driver");
          String dbUrl = prop.getProperty("db.url");
          String dbUser = prop.getProperty("db.user");
          String dbPwd = prop.getProperty("db.pwd");
          Class.forName(dbDriver);
          return DriverManager.getConnection(dbUrl, dbUser, dbPwd);
      } catch (ClassNotFoundException ex) {
          throw new RuntimeException(ex);
      } catch (IOException ex) {
          throw new RuntimeException(ex);
      }
  }
}
