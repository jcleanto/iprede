package org.isgh.iprede.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;

@Configuration
public class JacksonConfig
{
	@Bean
	public Module hibernate5Module()
	{
		return new Hibernate5Module();
	}
}