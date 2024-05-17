package web.service;

import org.springframework.stereotype.Component;
import web.model.Car;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class CarServiceImpl implements CarService {

    private List<Car> cars = new ArrayList<>() {{
        add(new Car("BMW", "Black", 2010));
        add(new Car("Mercedes", "Yellow", 2011));
        add(new Car("Toyota", "White", 2012));
        add(new Car("Honda", "Red", 2013));
        add(new Car("Hyundai", "Pink", 2014));
    }};

    @Override
    public List<Car> getAllCars() {
        return cars;
    }

    @Override
    public List<Car> getCarsByCount(List<Car> cars, int count) {
        if (count < 0)
            return Collections.emptyList();
        else if (count >= cars.size())
            return cars;
        else
            return cars.subList(0, count);
    }
}
