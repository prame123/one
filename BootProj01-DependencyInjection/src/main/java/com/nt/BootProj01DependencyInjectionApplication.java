package com.nt;

import java.time.LocalDate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import com.nt.sbeans.SeasonFinder;

@SpringBootApplication
//spring boot Application internally working as @configuration annotation to configure the target class object 
//and also it works @commponent scan also to scan the all spring bean class objects to ioc container
public class BootProj01DependencyInjectionApplication {
  @Bean(name="ld")
	public LocalDate createDate(){
	  return LocalDate.now();
  }
	public static void main(String[] args) {
 ApplicationContext ctx=SpringApplication.run(BootProj01DependencyInjectionApplication.class, args);
	//get target spring bean class obj
 SeasonFinder finder=ctx.getBean("sf",SeasonFinder.class);
 String seasonName= finder.findSeason();
 System.out.println("Season Name::"+seasonName);
 //close the IOC container
 ((ConfigurableApplicationContext)ctx).close();
	}

}
