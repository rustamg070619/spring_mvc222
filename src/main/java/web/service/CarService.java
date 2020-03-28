package web.service;

import web.model.Car;

import java.util.List;

public class CarService {

    private List<Car> listCars;

    public List<Car> getListCars() {
        return listCars;
    }

    public void setListCars(List<Car> listCars) {
        this.listCars = listCars;
    }
}
