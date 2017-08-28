package com.lab.persistence.service;

import com.lab.persistence.model.TestModel;
import java.util.List;


public interface TestService
{

  public List<TestModel> testService(TestModel obj) throws Exception;

}
