package com.lab.persistence.service;

import com.lab.persistence.mapper.ItemsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lab.persistence.model.ItemsModel;
import java.util.List;


@Service
public class ItemsServiceImpl implements ItemsService
{

  @Autowired
  ItemsMapper iMapper;


  @Override
  public List<ItemsModel> testService(ItemsModel obj) throws Exception
  {
    List<ItemsModel> x = iMapper.testMapper(obj);

    return x;
  }

}
