package com.lab.persistence.service;

import com.lab.persistence.model.TestModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lab.persistence.mapper.TestMapper;
import java.util.List;


@Service
public class TestServiceImpl implements TestService
{

  @Autowired
  TestMapper iMapper;


  @Override
  public List<TestModel> testService(TestModel obj) throws Exception
  {
    List<TestModel> x = iMapper.testMapper(obj);
    
    return x;
  }

}
