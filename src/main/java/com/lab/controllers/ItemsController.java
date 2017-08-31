package com.lab.controllers;


import com.lab.persistence.model.ItemsModel;
import com.lab.persistence.service.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;


@Controller
public class ItemsController
{

  @Autowired
  ItemsService iService;


  @ResponseBody
  @RequestMapping(value = "/getItems",
                  method = RequestMethod.POST,
                  produces = MediaType.APPLICATION_JSON_VALUE)
  public List<ItemsModel> getItems(@RequestBody ItemsModel obj) throws Exception
  {
    List<ItemsModel> x = iService.getItemsService(obj);

    return x;
  }


  @ResponseBody
  @RequestMapping(value = "/searchItems",
                  method = RequestMethod.POST,
                  produces = MediaType.APPLICATION_JSON_VALUE)
  public List<ItemsModel> searchItems(@RequestBody ItemsModel obj) throws Exception
  {
    List<ItemsModel> x = iService.searchItemsService(obj);

    return x;
  }

}
