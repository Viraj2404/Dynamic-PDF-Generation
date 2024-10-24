package com.viraj.invoice;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.thymeleaf.context.Context;

import com.viraj.invoice.documentcontroller.Demodocument;
import com.viraj.invoice.mapper.DataMapper;
import com.viraj.invoice.model.SellerBuyer;

@SpringBootTest
class InvoiceApplicationTests {
	
	@Autowired
	private DataMapper datamapper;
	
	@Autowired
	private Demodocument demodocument;
	

	 @Test
	    public void testSetData() {
	       
	        // Set values for employeeList
	        SellerBuyer sellerBuyer= new SellerBuyer();
	        sellerBuyer.setSeller("XYZ Pvt. Ltd.");
	        sellerBuyer.setSellerGstin("29AABBCCDD121ZD");
	        sellerBuyer.setSellerAddress("New Delhi, India");
	        sellerBuyer.setBuyer("Vedant Computers");
	        sellerBuyer.setBuyerGstin("29AABBCCDD131ZD");
	        sellerBuyer.setBuyerAddress("New Delhi, India");
	        sellerBuyer.setItemName("Product 1");
	        sellerBuyer.setQuantity("12 Nos");
	        sellerBuyer.setRate(123.00);
	        sellerBuyer.setAmount(1476.00);

	        Context context = datamapper.setData(sellerBuyer);

	        assertNotNull(context);
	        assertEquals(sellerBuyer, context.getVariable("employees"));
	    }

	    @Test
	    public void testGenerateDocumentSuccess() {
	       
	        // Set values for employeeList
	        SellerBuyer sellerBuyer= new SellerBuyer();
	        sellerBuyer.setSeller("XYZ Pvt. Ltd.");
	        sellerBuyer.setSellerGstin("29AABBCCDD121ZD");
	        sellerBuyer.setSellerAddress("New Delhi, India");
	        sellerBuyer.setBuyer("Vedant Computers");
	        sellerBuyer.setBuyerGstin("29AABBCCDD131ZD");
	        sellerBuyer.setBuyerAddress("New Delhi, India");
	        sellerBuyer.setItemName("Product 1");
	        sellerBuyer.setQuantity("12 Nos");
	        sellerBuyer.setRate(123.00);
	        sellerBuyer.setAmount(1476.00);

	        String result = demodocument.generateDocument(sellerBuyer);

	     // Verify PDF generation
	        assertEquals("Success", result);
	        
	    }

}
