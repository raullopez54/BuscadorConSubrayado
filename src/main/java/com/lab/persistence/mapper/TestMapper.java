package com.lab.persistence.mapper;

import com.lab.persistence.model.TestModel;
import java.util.List;


public interface TestMapper
{
  public List<TestModel> testMapper(TestModel obj) throws Exception;
}