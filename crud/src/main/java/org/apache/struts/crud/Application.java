package org.apache.struts.crud;

import com.opensymphony.sitemesh.webapp.SiteMeshFilter;
import org.apache.struts2.dispatcher.filter.StrutsPrepareAndExecuteFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import javax.servlet.Filter;

import java.util.Arrays;
import java.util.List;


@SpringBootApplication
public class Application {
public static void main(String... args) {
        SpringApplication.run(Application.class, args);
        }

@Bean
public FilterRegistrationBean filterDispatch() {
        return buildFilterRegistration(1, new StrutsPrepareAndExecuteFilter(),
                Arrays.asList("/", "/index.action", "/inputPerson.action",
        "/deletePerson.action", "/savePerson.action"));
        }


private FilterRegistrationBean buildFilterRegistration(int order, Filter filter, List<String> urlPatterns) {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(filter);
        registration.setUrlPatterns(urlPatterns);
        registration.setOrder(order);
        return registration;
        }
 }
