package com.carshop.persistance;

import java.util.List;

import com.carshop.domain.CarDTO;

public interface CarRepository {
	
	List<CarDTO> getAllCarList();

	List<CarDTO> getCarListByCategoty(String cate);
	
	CarDTO getCarById(String carId);
	
	void setNewCar(CarDTO car);

}