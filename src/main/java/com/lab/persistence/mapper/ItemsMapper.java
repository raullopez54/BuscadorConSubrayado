package com.lab.persistence.mapper;

import com.lab.persistence.model.ItemsModel;
import java.util.List;


public interface ItemsMapper
{
  public List<ItemsModel> testMapper(ItemsModel obj) throws Exception;
}