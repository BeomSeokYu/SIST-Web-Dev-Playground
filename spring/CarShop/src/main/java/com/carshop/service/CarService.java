package com.carshop.service;

import java.util.List;

import com.carshop.domain.CarDTO;

public interface CarService {
	
	List<CarDTO> getAllCarList();

	List<CarDTO> getCarListByCategoty(String cate);
	
	CarDTO getCarById(String carId);
	
	void setNewCar(CarDTO car);
}