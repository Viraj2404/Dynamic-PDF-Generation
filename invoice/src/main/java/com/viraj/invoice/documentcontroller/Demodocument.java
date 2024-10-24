package com.viraj.invoice.documentcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring6.SpringTemplateEngine;

import com.viraj.invoice.document.DocumentGenerator;
import com.viraj.invoice.mapper.DataMapper;
import com.viraj.invoice.model.SellerBuyer;

@RestController
public class Demodocument {
	
	
	@Autowired
	private DocumentGenerator documentGenerator;
	
	@Autowired
	private SpringTemplateEngine springTemplateEngine;
	
	@Autowired
	private DataMapper dataMapper;
	
	@PostMapping(value = "/generate/document")
	public String generateDocument(@RequestBody SellerBuyer employeeList) {
		
		dataMapper.saveinfo(employeeList);
		
		String finalHtml = null;
		
		Context dataContext = dataMapper.setData(employeeList);
		
		finalHtml = springTemplateEngine.process("template", dataContext);
		
		documentGenerator.htmlToPdf(finalHtml);
		
		return "Success";
	}
}
