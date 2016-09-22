package com.vedha.tgservice.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vedha.tgservice.entity.VehicleMstEntity;
@Transactional
public interface VehicleMstRepository extends JpaRepository<VehicleMstEntity,Long> {

}
