package com.vedha.tgservice.repository;



import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vedha.tgservice.entity.PostLoadEntity;
@Transactional
public interface PostLoadRepository extends JpaRepository<PostLoadEntity, Long> {

	//PostLoadEntity findByPostLoadId(Long postLoadId);
	

}
