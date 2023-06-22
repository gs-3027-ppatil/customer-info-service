package com.one.abc.customer.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.one.abc.customer.entity.OccupationType;

 

public interface OccupationTypeRepo extends JpaRepository<OccupationType, Long>   {

}
