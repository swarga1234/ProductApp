package com.swarga.project.productapp.util;

import java.io.Serializable;
import java.util.Properties;

import org.hibernate.HibernateException;
import org.hibernate.MappingException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.Configurable;
import org.hibernate.id.IdentifierGenerator;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.type.Type;

public class CustomProductIDGenerator implements IdentifierGenerator, Configurable{

	private String prefix;
	public void configure(Type type, Properties params, ServiceRegistry serviceRegistry) throws MappingException {
		// TODO Auto-generated method stub
		prefix = params.getProperty("prefix");
	}

	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
		
		String query = "select max(productId) from Product";
		String maxProductIdString = (String) session.createQuery(query).getSingleResult();
		Long lastProductId=0L;
		if(null!=maxProductIdString)
		{
			maxProductIdString=maxProductIdString.replace(prefix+"_", "");

		}
		else
		{
			maxProductIdString="";
		}
		if(null!=maxProductIdString && maxProductIdString.matches("\\d+") && !maxProductIdString.startsWith("-"))
		{
			lastProductId=Long.parseLong(maxProductIdString);
		}
		
		return prefix+"_"+(lastProductId+1);
		

	}

}
