package com.lab.persistence.service;

import com.lab.persistence.mapper.ItemsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lab.persistence.model.ItemsModel;
import java.util.List;
import java.util.regex.Pattern;

@Service
public class ItemsServiceImpl implements ItemsService
{

  @Autowired
  ItemsMapper iMapper;

  @Override
  public List<ItemsModel> getItemsService(ItemsModel obj) throws Exception
  {
    List<ItemsModel> x = iMapper.getItemsMapper(obj);

    return x;
  }

  @Override
  public List<ItemsModel> searchItemsService(ItemsModel obj) throws Exception
  {
    List<ItemsModel> x = iMapper.searchItemsMapper(obj);

    List<ItemsModel> list = this.replaceSearch(obj, x);

    return list;
  }

  private List<ItemsModel> replaceSearch(ItemsModel obj, List<ItemsModel> x)
  {

    for (ItemsModel item : x)
    {
      item.setNombre(this.pattern(obj.getNombre()).matcher(item.getNombre()).replaceAll(this.patternReplace(obj.getNombre())));
      item.setDescripcion(this.pattern(obj.getDescripcion()).matcher(item.getDescripcion()).replaceAll(this.patternReplace(obj.getDescripcion())));
    }

    return x;
  }

  private Pattern pattern(String x)
  {
    return Pattern.compile("(?i)" + x);
  }

  private String patternReplace(String x)
  {
    return "<strong class=\"found\">" + x + "</strong>";
  }

}
