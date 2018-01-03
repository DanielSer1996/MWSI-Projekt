package i5b5.mwsi.services;


import i5b5.mwsi.services.dto.CarData;

import java.util.List;

public interface CarService {
    List<CarData> listCars();
    List<CarData> getSpecifiedCars(String criteria);
}
