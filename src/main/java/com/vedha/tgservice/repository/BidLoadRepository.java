package com.vedha.tgservice.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vedha.tgservice.entity.BidLoadEntity;

@Transactional
public interface BidLoadRepository extends JpaRepository<BidLoadEntity, Long> {

}
