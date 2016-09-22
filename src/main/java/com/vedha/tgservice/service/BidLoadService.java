package com.vedha.tgservice.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vedha.tgservice.dto.BidLoadDTO;
import com.vedha.tgservice.entity.AddressEntity;
import com.vedha.tgservice.entity.BidLoadEntity;
import com.vedha.tgservice.exception.ApplicationException;
import com.vedha.tgservice.repository.AddressRepository;
import com.vedha.tgservice.repository.BidLoadRepository;
import com.vedha.tgservice.utils.ModelEntityMapper;

import lombok.extern.log4j.Log4j;


@Log4j
@Service
public class BidLoadService  {
	
	@Autowired
	BidLoadRepository bidloadRepository;
	
	@Autowired
	AddressRepository addressRepository;
	
	@Transactional
	public BidLoadDTO saveBid(BidLoadDTO dto) throws ApplicationException{
		
		BidLoadEntity bidloadEntity = (BidLoadEntity) ModelEntityMapper.converModelToEntity(dto, BidLoadEntity.class);
		AddressEntity pickupEntity=bidloadEntity.getPickupPoint();
		AddressEntity deliveryEntity=bidloadEntity.getDeliveryPoint();
		pickupEntity=addressRepository.save(pickupEntity);
		deliveryEntity=addressRepository.save(deliveryEntity);
		log.info("Trying save in the Repository");
		bidloadEntity = bidloadRepository.saveAndFlush(bidloadEntity);
		return (BidLoadDTO) ModelEntityMapper.converEntityToModel(bidloadEntity, BidLoadDTO.class);
	}

	
	@Transactional
	public BidLoadDTO updateBid(BidLoadDTO dto) throws ApplicationException{
		
		BidLoadEntity bidloadEntity = (BidLoadEntity) ModelEntityMapper.converModelToEntity(dto, BidLoadEntity.class);
		AddressEntity pickupEntity=bidloadEntity.getPickupPoint();
		AddressEntity deliveryEntity=bidloadEntity.getDeliveryPoint();
		pickupEntity=addressRepository.save(pickupEntity);
		deliveryEntity=addressRepository.save(deliveryEntity);
		bidloadEntity = bidloadRepository.saveAndFlush(bidloadEntity);
		return (BidLoadDTO) ModelEntityMapper.converEntityToModel(bidloadEntity, BidLoadDTO.class);
	}

	
	@Transactional
	public void deleteBid(long id) throws ApplicationException{
		
		bidloadRepository.delete(id);
	}

	
	@Transactional
	public List<BidLoadDTO> getAllBid() throws ApplicationException {
		
		List<BidLoadDTO> bidloadList = new ArrayList<BidLoadDTO>();
		for (BidLoadEntity bidloadEntity : bidloadRepository.findAll()) {
			BidLoadDTO bidloadDTO = (BidLoadDTO) ModelEntityMapper.converEntityToModel(bidloadEntity, BidLoadDTO.class);
			bidloadList.add(bidloadDTO);
		}
		return bidloadList;
	}

	
	@Transactional
	public BidLoadDTO getBidBybidLoadID(long id) throws ApplicationException{
		
		BidLoadEntity bidloadEntity = bidloadRepository.findOne(id);
		if (bidloadEntity != null) {
			BidLoadDTO bidloadDTO = (BidLoadDTO) ModelEntityMapper.converEntityToModel(bidloadEntity, BidLoadDTO.class);
			return bidloadDTO;
		}
		return null;
	}

}
