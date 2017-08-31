package com.lab.persistence.service;

import com.lab.persistence.model.ItemsModel;
import java.util.List;


public interface ItemsService
{

  /**
   * OBTIENE TODOS LOS ITEMS ALMACENADOS.
   *
   * @param obj Objeto tipo ItemsModel.
   *
   * @return Lista de objetos tipo ItemsModel.
   */
  public List<ItemsModel> getItemsService(ItemsModel obj) throws Exception;


  /**
   * OBTIENE TODOS LOS ITEMS ALMACENADOS BASADOS EN UN CRITERIO DE BUSQUEDA.
   *
   * @param obj Objeto tipo ItemsModel.
   *
   * @return Lista de objetos tipo ItemsModel.
   */
  public List<ItemsModel> searchItemsService(ItemsModel obj) throws Exception;

}
