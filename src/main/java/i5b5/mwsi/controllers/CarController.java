package i5b5.mwsi.controllers;

import i5b5.mwsi.controllers.factories.HttpHeaderFactory;
import i5b5.mwsi.services.CarService;
import i5b5.mwsi.services.dto.BasicDriverInfo;
import i5b5.mwsi.services.dto.CarData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping
public class CarController {
    @Autowired
    private CarService carService;
    private HttpHeaderFactory httpHeaderFactory;

    public CarController() {
        this.httpHeaderFactory = new HttpHeaderFactory();
    }

    @RequestMapping(value = "/cars",
    method = RequestMethod.GET)
    public ResponseEntity<List<CarData>> getCars(){
        List<CarData> cars;
        cars = carService.listCars();

        return new ResponseEntity<>(cars, httpHeaderFactory.getHttpHeader(), HttpStatus.OK);
    }

    @RequestMapping("/cars/search")
    public ResponseEntity<List<CarData>> getCarById(@RequestParam("criteria") String criteria){
        List<CarData> specifiedCars;
        specifiedCars = carService.getSpecifiedCars(criteria);

        return new ResponseEntity<>(specifiedCars,httpHeaderFactory.getHttpHeader(),HttpStatus.OK);
    }
}
