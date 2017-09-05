package com.lab.configuration;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.resource.PathResourceResolver;


@Configuration
@ComponentScan
@RestController
@EnableAutoConfiguration(exclude =
{
  DataSourceAutoConfiguration.class
})
public class LabConfiguration extends WebMvcConfigurerAdapter
{

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

}
