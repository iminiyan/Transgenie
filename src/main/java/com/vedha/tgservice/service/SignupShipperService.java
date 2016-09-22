package com.vedha.tgservice.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import lombok.extern.log4j.Log4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vedha.tgservice.dto.CustShipperDTO;
import com.vedha.tgservice.dto.ProductMstDTO;
import com.vedha.tgservice.entity.CustShipperEntity;
import com.vedha.tgservice.entity.ProductMstEntity;
import com.vedha.tgservice.repository.CustShipperRepository;
import com.vedha.tgservice.repository.ProductMstRepository;
import com.vedha.tgservice.utils.ModelEntityMapper;
import com.vedha.tgservice.utils.Converter;

@Log4j
@Service
public class SignupShipperService {
	
	@Autowired
	CustShipperRepository shipperRepository;
	
	@Autowired
	ProductMstRepository productRepository;
    
	@Transactional
	public CustShipperDTO add(CustShipperDTO customerDto) {
		CustShipperEntity shipperEntity = (CustShipperEntity) ModelEntityMapper.converModelToEntity(customerDto, CustShipperEntity.class);
		shipperEntity = shipperRepository.save(shipperEntity);
		List<ProductMstEntity> productEntity= shipperEntity.getProductList();
        for (ProductMstEntity productEntityValue : productEntity) {
			productEntityValue=productRepository.save(productEntityValue);
		}
		
		log.info("Shipper Data Inserted Sucessfully");
		return (CustShipperDTO) ModelEntityMapper.converEntityToModel(shipperEntity, CustShipperDTO.class);
	}
    
	@Transactional
	public CustShipperDTO update(CustShipperDTO customerdto) {
		
		log.info("Update Input :: "+customerdto);
		CustShipperEntity shipperEntity = (CustShipperEntity) ModelEntityMapper.converModelToEntity(customerdto, CustShipperEntity.class);
		
		List<ProductMstEntity> productEntity= shipperEntity.getProductList();
        for (ProductMstEntity productEntityValue : productEntity) {
			productEntityValue=productRepository.save(productEntityValue);
		}
		
		shipperEntity = shipperRepository.saveAndFlush(shipperEntity);
		
		
		log.info("Shipper Data Updated Sucessfully");
		return (CustShipperDTO) Converter.shipperEntityToDTO(shipperEntity);
	}
    
	@Transactional
	public void delete(long id) {
		shipperRepository.delete(id);
		productRepository.delete(id);
	}
    
	@Transactional
	public List<CustShipperDTO> getAll() {
		List<CustShipperDTO> shipperList = new ArrayList<CustShipperDTO>();
		for (CustShipperEntity shipperEntity :shipperRepository.findAll()) {
			CustShipperDTO shipperDTO = (CustShipperDTO) Converter.shipperEntityToDTO(shipperEntity);
			shipperList.add(shipperDTO);
		
		}
	    
		log.info("Shipper getAll Sucessfully");
		return shipperList;
		
	}

	@Transactional
	public List<CustShipperDTO> getByID(long id) {
		
		List<CustShipperDTO> shipperList = new ArrayList<CustShipperDTO>();
		log.info("custID captured value is : "+id);
		
		CustShipperDTO shipperDTO = null;
		
		CustShipperEntity shipperEntity = shipperRepository.findByCustID(id);
		
		//CustShipperEntity shipperEntity = shipperRepository.findOne(id);
		if (shipperEntity != null) {
			shipperDTO = (CustShipperDTO) Converter.shipperEntityToDTO(shipperEntity);
			log.info("Shipper get by id Sucessfully");
			shipperList.add(shipperDTO);
			return shipperList;
		}
		
		return new ArrayList<CustShipperDTO>();
	}

}
