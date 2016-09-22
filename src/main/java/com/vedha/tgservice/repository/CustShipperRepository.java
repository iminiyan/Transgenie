package com.vedha.tgservice.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vedha.tgservice.entity.CustShipperEntity;

@Transactional
public interface CustShipperRepository extends JpaRepository<CustShipperEntity, Long> {

	CustShipperEntity findByCustID(long id);

}
