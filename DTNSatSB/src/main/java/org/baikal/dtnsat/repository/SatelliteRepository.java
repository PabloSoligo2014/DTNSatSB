package org.baikal.dtnsat.repository;

import java.util.List;

import org.baikal.dtnsat.model.Satellite;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SatelliteRepository extends JpaRepository<Satellite, Long>{
	List<Satellite> findById(long Id);
}
