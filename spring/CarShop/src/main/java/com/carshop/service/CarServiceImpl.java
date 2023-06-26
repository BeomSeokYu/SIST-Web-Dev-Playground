package com.carshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carshop.domain.CarDTO;
import com.carshop.persistance.CarRepository;

@Service
public class CarServiceImpl implements CarService {
	
	@Autowired
	private CarRepository carRepository;

	@Override
	public List<CarDTO> getAllCarList() {
		return carRepository.getAllCarList();
	}

	@Override
	public List<CarDTO> getCarListByCategoty(String cate) {
		return carRepository.getCarListByCategoty(cate);
	}

	@Override
	public CarDTO getCarById(String carId) {
		return carRepository.getCarById(carId);
	}

	@Override
	public void setNewCar(CarDTO car) {
		carRepository.setNewCar(car);
	}

}