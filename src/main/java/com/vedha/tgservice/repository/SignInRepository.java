package com.vedha.tgservice.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.vedha.tgservice.entity.SignUpEntity;


@Transactional
public interface SignInRepository extends JpaRepository<SignUpEntity, Long>{

	@Query(value ="select * from cust_signup where email = :email and password = :password",nativeQuery=true)
	List<SignUpEntity> findByEmail(@Param("email")String email,@Param("password") String password);
	
	

}
