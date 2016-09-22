package com.vedha.tgservice.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vedha.tgservice.entity.AddressEntity;

@Transactional
public interface AddressRepository extends JpaRepository<AddressEntity, Long>{

}
