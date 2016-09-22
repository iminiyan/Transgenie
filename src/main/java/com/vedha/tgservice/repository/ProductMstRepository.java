package com.vedha.tgservice.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vedha.tgservice.entity.ProductMstEntity;

@Transactional
public interface ProductMstRepository extends JpaRepository<ProductMstEntity, Long>{

	
}
