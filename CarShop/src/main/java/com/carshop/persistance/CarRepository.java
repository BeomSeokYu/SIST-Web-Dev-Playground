package com.carshop.persistance;

import java.util.List;

import com.carshop.domain.CarDTO;

public interface CarRepository {
	
	List<CarDTO> getAllCarList();

}