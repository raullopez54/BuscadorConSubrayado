package com.lab.persistence.mapper;

import com.lab.persistence.model.ItemsModel;
import java.util.List;


public interface ItemsMapper
{

  /**
   * OBTIENE TODOS LOS ITEMS ALMACENADOS.
   *
   * @param obj Objeto tipo ItemsModel.
   *
   * @return Lista de objetos tipo ItemsModel.
   */
  public List<ItemsModel> getItemsMapper(ItemsModel obj) throws Exception;


  /**
   * OBTIENE TODOS LOS ITEMS ALMACENADOS BASADOS EN UN CRITERIO DE BUSQUEDA.
   *
   * @param obj Objeto tipo ItemsModel.
   *
   * @return Lista de objetos tipo ItemsModel.
   */
  public List<ItemsModel> searchItemsMapper(ItemsModel obj) throws Exception;

}
