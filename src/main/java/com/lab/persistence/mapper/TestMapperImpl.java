package com.lab.persistence.mapper;

import com.lab.persistence.mapper.bbdd.BBDD;
import com.lab.persistence.model.TestModel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class TestMapperImpl implements TestMapper
{

  @Autowired
  BBDD db;


  @Override
  public List<TestModel> testMapper(TestModel obj) throws Exception
  {

    System.out.println("\n\rPARAMETRO RECIBIDO: " + obj.getTable());

    List<TestModel> x = new ArrayList<>();

    /**
     * CONECTANDO A LA BBDD.
     */
    db.conecta();

    /**
     * RECORRIENDO LAS TABLAS.
     */
    for (int i = 0; i < db.tablas().size(); i++)
    {
      TestModel table = new TestModel();

      table.setTable(db.tablas().get(i).toUpperCase());

      System.out.println();
      System.out.printf("___%-12s", table.getTable());
      System.out.println();

      /**
       * RECORRIENDO LAS COLUMNAS DE LA TABLA SELECCIONADA.
       */
      for (int j = 0; j < db.columnas(db.tablas().get(i)).size(); j++)
      {
        System.out.printf("| %-16s", db.columnas(table.getTable()).get(j));
        /**
         * CONSULTANDO LOS VALORES DE LA COLUMNA SELECCIONADA.
         */
        String sql = "SELECT " + db.columnas(table.getTable()).get(j) + " FROM " + table.
                     getTable();

        ResultSet rs = db.consulta(sql);
        while (rs.next())
        {
          System.out.print(" ");
          System.out.printf("| %-20s", rs.getString(db.columnas(db.tablas().
                            get(i)).get(j)));
        }

        System.out.println();
      }
      System.out.println();

      x.add(table);
    }
    /**
     * DESCONECTANDO A LA BBDD.
     */
    db.desconecta();

    return x;
  }

}
