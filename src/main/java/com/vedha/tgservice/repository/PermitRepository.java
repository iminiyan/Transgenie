package com.vedha.tgservice.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vedha.tgservice.entity.PermitEntity;

@Transactional
public interface PermitRepository extends JpaRepository<PermitEntity,Long> {

	//PermitEntity findByPermitTypeId(long permitTypeId);
}
