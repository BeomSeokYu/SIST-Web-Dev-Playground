package com.carshop.persistance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.carshop.domain.CarDTO;

@Repository
public class CarRepositoryImpl implements CarRepository {

	private List<CarDTO> listOfCars = new ArrayList<CarDTO>();
	
	public CarRepositoryImpl() {
		
		CarDTO car1 = new CarDTO("c0001","소나타","2500","소형","거의 새거");
		CarDTO car2 = new CarDTO("c0002","그랜저","3500","중형","아주 새거");
		CarDTO car3 = new CarDTO("c0003","아반테","2000","중형","극히 새거");
		CarDTO car4 = new CarDTO("c0004","버스","10000","대형","극히 새거");
		
		listOfCars.add(car1);
		listOfCars.add(car2);
		listOfCars.add(car3);
		listOfCars.add(car4);
		
	}
	
	@Override
	public List<CarDTO> getAllCarList() {
		
		return listOfCars;
	}

	@Override
	public List<CarDTO> getCarListByCategoty(String cate) {
		List<CarDTO> listOfCarsByCategory = new ArrayList<CarDTO>();
		listOfCars.forEach(s -> {
			if (s.getCcate().equals(cate)) {
				listOfCarsByCategory.add(s);
			}
		});
		
		return listOfCarsByCategory;
	}

	@Override
	public CarDTO getCarById(String carId) {
		
		CarDTO carInfo = null;
		
		for (int i = 0 ; i < listOfCars.size() ; i++) {
			CarDTO carDTO = listOfCars.get(i);
			if(carDTO != null && carDTO.getCid() != null && carDTO.getCid().equals(carId)) {
				carInfo = carDTO;
			}
		}
		
		if (carInfo == null) {
			throw new IllegalArgumentException("자동차 ID 가 " + carId + "인 자동차는 없습니다. ");
		}
		
		return carInfo;
	}

	@Override
	public void setNewCar(CarDTO car) {
		listOfCars.add(car);
	}

}