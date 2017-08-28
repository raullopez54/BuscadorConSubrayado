/**
 * LICENCIA...: CC BY-NC-ND 4.0 | Atribucion-NoComercial-SinDerivar 4.0 Inter.
 * PROYECTO...: CONEXION JAVA.
 * FECHA......: V.1.0.0 | 12/04/2016.
 * AUTOR......: Alfonso
 * _____________________________________________________________________________
 *
 * TITULO.....:   CONEXION A BBDD CON JAVA JDBC.
 * DESCRIPCION: - Conceptos basicos para conectar JAVA a una base de datos.
 *              - Es necesario incluir la libreria MySQL JDBC Driver.
 *              - Es necesario incluir la libreria mariadb-java-client-1.1.7.jar
 */
package com.lab.persistence.mapper.bbdd;


import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import org.springframework.stereotype.Repository;


@Repository
public class BBDDImpl implements BBDD
{

  private Connection conx;
  private DatabaseMetaData dbmd;
  private String bbdd;
  private String user;
  private String clave;


  /**
   * Constructor parametrizado.
   */
  public BBDDImpl()
  {
    try
    {
      this.bbdd = "jdbc:mysql://localhost/spring";
      this.user = "root";
      this.clave = "";

//      Class.forName("org.mariadb.jdbc.Driver");
    }
    catch (Exception e)
    {
//      JOptionPane.showMessageDialog(null, "ERROR DE CONEXION");
    }

  }


  /**
   * Realiza una conexion a la base de datos.
   */
  @Override
  public void conecta() throws SQLException
  {
    this.conx = DriverManager.getConnection(this.bbdd, this.user, this.clave);
    this.dbmd = this.conx.getMetaData();
  }


  /**
   * Finaliza una conexion a la base de datos.
   */
  @Override
  public void desconecta() throws SQLException
  {
    this.conx.close();
  }


  /**
   * Consulta estandar a la base de datos.
   *
   * @param query Cadena con la consulta SQL.
   *
   * @return Datos de la consulta SQL.
   */
  @Override
  public ResultSet consulta(String query) throws SQLException
  {
    return this.conx.createStatement().executeQuery(query);
  }


  /**
   * Consulta para insertar, actualizar y borrar en la base de datos.
   *
   * @param query Cadena con la consulta SQL.
   */
  @Override
  public void updates(String query) throws SQLException
  {
    this.conx.createStatement().executeUpdate(query);
  }


  /**
   * @return Tablas de la base de datos.
   */
  @Override
  public ArrayList<String> tablas() throws SQLException
  {
    String[] table = new String[]
    {
      "TABLE"
    };
    ArrayList<String> tablas = new ArrayList<>();
    ResultSet rs = this.dbmd.getTables(null, null, null, table);

    while (rs.next())
    {
      tablas.add(rs.getString("TABLE_NAME"));
    }

    return tablas;
  }


  /**
   * @param tabla Nombre de la tabla a consultar.
   *
   * @return Columnas por las que esta formada la tabla.
   */
  @Override
  public ArrayList<String> columnas(String tabla) throws SQLException
  {
    ArrayList<String> columnas = new ArrayList<>();
    ResultSet rs = this.dbmd.getColumns(null, null, tabla, null);

    while (rs.next())
    {
      columnas.add(rs.getString("COLUMN_NAME"));
    }

    return columnas;
  }


}
