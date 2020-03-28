package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import web.model.Car;
import web.service.CarService;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class HelloController {

    @RequestMapping(value = "hello", method = RequestMethod.GET)
    public String printWelcome(ModelMap model) {
        List<String> messages = new ArrayList<>();
        messages.add("Hello!");
        messages.add("I'm Spring MVC application");
        messages.add("5.2.0 version by sep'19 ");
        model.addAttribute("messages", messages);
        return "hello";
    }

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

