package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;
import web.service.CarService;

import java.util.List;

@Controller
public class CarController {

    private final CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/cars")
    public String printCars(ModelMap model, @RequestParam(value = "count", required = false) Integer count) {
        List<Car> cars = carService.getAllCars();
        model.addAttribute("cars", carService.getCarsByCount(cars,
                count != null ? count : cars.size()));
        return "cars";
    }
}
