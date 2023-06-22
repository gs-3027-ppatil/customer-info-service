package com.one.abc.customer.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.one.abc.customer.entity.Kyc;

 

public interface KycRepo extends JpaRepository<Kyc, Long>{

}
