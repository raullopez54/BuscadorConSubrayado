package com.lab.configuration;

import javax.sql.DataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.ResourcePatternUtils;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.resource.PathResourceResolver;


@Configuration
//@ComponentScan
@RestController
@EnableTransactionManagement
@EnableAutoConfiguration(exclude =
{
  DataSourceAutoConfiguration.class
})
@MapperScan("com.lab.persistence.mapper")
@ComponentScan(
        {
          "com.lab.configuration",
          "com.lab.persistence.service"
        })
public class LabConfiguration extends WebMvcConfigurerAdapter
{

  @Autowired
  private ResourceLoader resourceLoader;

  
  

  @Override
  public void configurePathMatch(PathMatchConfigurer configurer)
  {
    configurer.setUseSuffixPatternMatch(false);
  }


  @Override
  public void addResourceHandlers(final ResourceHandlerRegistry registry)
  {
    registry.addResourceHandler("/resources/**").
            addResourceLocations("/resources/").setCachePeriod(0).
            resourceChain(true).
            addResolver(new PathResourceResolver());

    registry.addResourceHandler("/webjars/**").
            addResourceLocations("/webjars/").setCachePeriod(0).
            resourceChain(true).
            addResolver(new PathResourceResolver());

  }


  @Bean
  public DataSource dataSource()
  {

//    System.out.println("---> " + env.getProperty("controller"));
    DriverManagerDataSource dataSource = new DriverManagerDataSource();

    try
    {
      dataSource.setDriverClassName("com.mysql.jdbc.Driver");
      dataSource.setUrl("jdbc:mysql//localhost:3306/spring");
      dataSource.setUsername("root");
      dataSource.setPassword("");
    }
    catch (Exception e)
    {
      System.out.print("-------------->");
    }
    return dataSource;
  }


  @Bean
  public DataSourceTransactionManager transactionManager()
  {
    return new DataSourceTransactionManager(dataSource());
  }


  @Bean
  public SqlSessionFactoryBean sqlSessionFactory() throws Exception
  {
    SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
    sessionFactory.setDataSource(dataSource());

//    sessionFactory.setTypeAliasesPackage("com.lab.domain");
    sessionFactory.setMapperLocations(ResourcePatternUtils.
            getResourcePatternResolver(resourceLoader).
            getResources("classpath:com/lab/persistence/mapper/*.xml"));
    return sessionFactory;
  }

}
