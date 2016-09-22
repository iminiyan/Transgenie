package com.vedha.tgservice.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vedha.tgservice.entity.SignUpEntity;

@Transactional
public interface SignUpRepository extends JpaRepository<SignUpEntity, Long> {

}
