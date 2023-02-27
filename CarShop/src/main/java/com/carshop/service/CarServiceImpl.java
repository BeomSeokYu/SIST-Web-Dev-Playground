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
		// TODO Auto-generated method stub
		return carRepository.getAllCarList();
	}

}