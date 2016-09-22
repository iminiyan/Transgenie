package com.vedha.tgservice.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vedha.tgservice.entity.CustTransporterEntity;

@Transactional
public interface CustTransporterRepository extends JpaRepository<CustTransporterEntity, Long> {

	CustTransporterEntity findByCustID(long id);

}
