package com.vedha.tgservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.vedha.tgservice.dto.ProductMstDTO;
import com.vedha.tgservice.exception.ApplicationException;
import com.vedha.tgservice.service.ProductMstService;

import lombok.extern.log4j.Log4j;

@Log4j
@RestController
@RequestMapping("/product")
public class ProductMstController {
	
	@Autowired
	ProductMstService productService;
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseStatus(value=HttpStatus.CREATED)
	public ProductMstDTO addProduct(@RequestBody ProductMstDTO productdto) throws ApplicationException {
		log.info("add Product");
		//fillDefaultValue(productdto, ActionMode.CREATE);
		return productService.saveProduct(productdto);
	}
	
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	@ResponseStatus(value=HttpStatus.CREATED)
	public ProductMstDTO modifyProduct(@RequestBody ProductMstDTO productdto) throws ApplicationException {
		log.info("Modify Product");
		//fillDefaultValue(productdto, ActionMode.MODIFY);
		return productService.updateProduct(productdto);
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public void deleteProduct(@PathVariable("id") long id) throws ApplicationException {
		log.info("Delete Product");
		productService.deleteProduct(id);
	}
		
	@RequestMapping(value = "/getAll", method = RequestMethod.GET)
	public List<ProductMstDTO> getAllProduct() throws ApplicationException {
		log.info("Get All Product");
		return productService.getAllProduct();
	}
	
	@RequestMapping(value = "/getByID/{id}", method = RequestMethod.GET)
	public ProductMstDTO getProductByID(@PathVariable("id") long id) throws ApplicationException {
		log.info("Get Product By ID");
		return productService.getProductById(id);
	}
	
	
	
}
