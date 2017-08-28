package com.lab.persistence.mapper.bbdd;

import java.sql.ResultSet;
import java.util.ArrayList;


public interface BBDD
{

  public void conecta() throws Exception;


  public void desconecta() throws Exception;


  public ResultSet consulta(String query) throws Exception;


  public void updates(String query) throws Exception;


  public ArrayList<String> tablas() throws Exception;


  public ArrayList<String> columnas(String tabla) throws Exception;

}
