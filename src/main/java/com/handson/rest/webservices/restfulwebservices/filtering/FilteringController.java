package com.handson.rest.webservices.restfulwebservices.filtering;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class FilteringController {

	@GetMapping("/somebean/filtering")
	public SomeBean getSomeBeanData()
	{
		return new SomeBean("val1","val2","val3");
	}
	
	@GetMapping("/somebean/filtering-list")
	public List<SomeBean> getSomeBeanList()
	{
		return Arrays.asList(new SomeBean("val1","val2","val3"),new SomeBean("val11","val12","val13"));
	}
	
	//only show field1 and field2
	@GetMapping("/anotherbean/filtering")
	public MappingJacksonValue getAnotherBeanData()
	{
		AnotherBean anotherBean = new AnotherBean("val1","val2","val3");
		MappingJacksonValue mapping=new MappingJacksonValue(anotherBean);
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field1", "field2");
		FilterProvider filters = new SimpleFilterProvider().addFilter("AnotherBeanFilter",filter);
		mapping.setFilters(filters);
		
		return mapping;
	}
	
	//only show field1 and field3
	@GetMapping("/anotherbean/filtering-list")
	public MappingJacksonValue getAnotherBeanList()
	{
		List<AnotherBean> list = Arrays.asList(new AnotherBean("val1","val2","val3"),new AnotherBean("val11","val12","val13"));
		MappingJacksonValue mapping=new MappingJacksonValue(list);
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field2", "field3");
		FilterProvider filters = new SimpleFilterProvider().addFilter("AnotherBeanFilter",filter);
		mapping.setFilters(filters);
		
		return mapping;
	}
}
