package com.vedha.tgservice.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vedha.tgservice.dto.ProductMstDTO;
import com.vedha.tgservice.entity.ProductMstEntity;
import com.vedha.tgservice.repository.ProductMstRepository;
import com.vedha.tgservice.utils.ModelEntityMapper;

@Service
public class ProductMstService {

	@Autowired
	ProductMstRepository productRepository;
    
	@Transactional
	public ProductMstDTO saveProduct(ProductMstDTO productdto) {
		
		ProductMstEntity productEntity = (ProductMstEntity) ModelEntityMapper.converModelToEntity(productdto, ProductMstEntity.class);
		productEntity = productRepository.saveAndFlush(productEntity);
		return (ProductMstDTO) ModelEntityMapper.converEntityToModel(productEntity, ProductMstDTO.class);
	}
	@Transactional
	public ProductMstDTO updateProduct(ProductMstDTO productdto) {
		
		ProductMstEntity productEntity = (ProductMstEntity) ModelEntityMapper.converModelToEntity(productdto, ProductMstEntity.class);
		productEntity = productRepository.saveAndFlush(productEntity);
		return (ProductMstDTO) ModelEntityMapper.converEntityToModel(productEntity, ProductMstDTO.class);
	}
	@Transactional
	public void deleteProduct(long id) {
		productRepository.delete(id);
		
	}
	@Transactional
	public List<ProductMstDTO> getAllProduct() {
		List<ProductMstDTO> productList = new ArrayList<ProductMstDTO>();
		for (ProductMstEntity productEntity : productRepository.findAll()) {
			ProductMstDTO productDTO = (ProductMstDTO) ModelEntityMapper.converEntityToModel(productEntity, ProductMstDTO.class);
			productList.add(productDTO);
		}
		return productList;
	}
	@Transactional
	public ProductMstDTO getProductById(long id) {
		
		ProductMstEntity productEntity = productRepository.findOne(id);
		if (productEntity != null) {
			ProductMstDTO productDTO = (ProductMstDTO) ModelEntityMapper.converEntityToModel(productEntity, ProductMstDTO.class);
			return productDTO;
		}
		return null;
	}
	
	
	
	
	

	
	



}
