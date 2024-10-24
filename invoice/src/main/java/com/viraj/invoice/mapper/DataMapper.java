package com.viraj.invoice.mapper;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;

import com.viraj.invoice.model.SellerBuyer;
import com.viraj.invoice.repository.Documentrepo;



@Service
public class DataMapper {
	
	@Autowired
	private Documentrepo documentrepo;
	
	public void saveinfo(SellerBuyer sb) {
		documentrepo.save(sb);
	}

	public Context setData(SellerBuyer empolyeeList) {
		
		Context context = new Context();
		
		Map<String, Object> data = new HashMap<>();
		
		data.put("employees", empolyeeList);
		
		context.setVariables(data);
		
		return context;
	}
}