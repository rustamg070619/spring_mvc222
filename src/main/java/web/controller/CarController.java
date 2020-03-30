package web.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;
import web.service.CarService;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class CarController {

    @RequestMapping(value = "cars", method = RequestMethod.GET)
    public String printCars(@RequestParam(name = "locale", required = false, defaultValue = "en") String locale, ModelMap model) {
        CarService carService = new CarService();
        List<Car> cars = new ArrayList<>();
        cars.add(new Car(new Long(1), "model1", "brand1"));
        cars.add(new Car(new Long(2), "model2", "brand2"));
        cars.add(new Car(new Long(3), "model3", "brand3"));
        carService.setListCars(cars);
        if (locale.equals("ru")) {
            model.addAttribute("locale", "МАШИНЫ");
        } else {
            model.addAttribute("locale", "CARS");
        }
        model.addAttribute("messagesCars", carService.getListCars());
        return "cars";
    }
}
