package com.vedha.tgservice.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vedha.tgservice.dto.PostLoadDTO;
import com.vedha.tgservice.entity.AddressEntity;
import com.vedha.tgservice.entity.PostLoadEntity;
import com.vedha.tgservice.exception.ApplicationException;
import com.vedha.tgservice.repository.AddressRepository;
import com.vedha.tgservice.repository.PostLoadRepository;
import com.vedha.tgservice.utils.ModelEntityMapper;

import lombok.extern.log4j.Log4j;

@Log4j
@Service
public class PostLoadService {
	
	@Autowired
	PostLoadRepository postloadRepository;
	
	@Autowired
	AddressRepository addressRepository;
	
	@Transactional
	public PostLoadDTO savePostLoad(PostLoadDTO dto) throws ApplicationException{
		
		log.info("PostLoad :: Add Service");
		
		PostLoadEntity postloadEntity = (PostLoadEntity) ModelEntityMapper.converModelToEntity(dto, PostLoadEntity.class);
		AddressEntity pickupEntity=postloadEntity.getPickupPoint();
		AddressEntity deliveryEntity=postloadEntity.getDeliveryPoint();
		
		pickupEntity=addressRepository.save(pickupEntity);
		deliveryEntity=addressRepository.save(deliveryEntity);
		log.info("Input Value PostLoad::::>>>>>"+postloadEntity);
		postloadEntity = postloadRepository.save(postloadEntity);
		return (PostLoadDTO) ModelEntityMapper.converEntityToModel(postloadEntity, PostLoadDTO.class);
		
	}

	@Transactional
	public PostLoadDTO updatePostLoad(PostLoadDTO dto) throws ApplicationException{
		
		log.info("PostLoad :: Modify Service");
		PostLoadEntity postloadEntity = (PostLoadEntity) ModelEntityMapper.converModelToEntity(dto, PostLoadEntity.class);
		AddressEntity pickupEntity=postloadEntity.getPickupPoint();
		AddressEntity deliveryEntity=postloadEntity.getDeliveryPoint();
		
		pickupEntity=addressRepository.save(pickupEntity);
		deliveryEntity=addressRepository.save(deliveryEntity);
		postloadEntity = postloadRepository.saveAndFlush(postloadEntity);
		log.info("PostLoad updated successfully");
		
		return (PostLoadDTO) ModelEntityMapper.converEntityToModel(postloadEntity, PostLoadDTO.class);
		
	}

	@Transactional
	public void deletePostLoad(long id) throws ApplicationException{
		
		postloadRepository.delete(id);
				
	}

	
	@Transactional
	public List<PostLoadDTO> getAllPostLoad() {
		
		List<PostLoadDTO> postloadList = new ArrayList<PostLoadDTO>();
		for (PostLoadEntity postloadEntity : postloadRepository.findAll()) {
			PostLoadDTO postloadDTO = (PostLoadDTO) ModelEntityMapper.converEntityToModel(postloadEntity, PostLoadDTO.class);
			postloadList.add(postloadDTO);
		}
		return postloadList;
	}

	@Transactional
	public PostLoadDTO getPostLoadById(long id) {
		
		PostLoadEntity postloadEntity = postloadRepository.findOne(id);
		if (postloadEntity != null) {
			PostLoadDTO postloadDTO = (PostLoadDTO) ModelEntityMapper.converEntityToModel(postloadEntity, PostLoadDTO.class);
			return postloadDTO;
		}
		return null;
	}
	
	
}
		
	
	

