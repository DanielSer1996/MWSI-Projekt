package i5b5.mwsi.services;

import i5b5.mwsi.services.dto.DriverDTO;

import java.util.List;

public interface DriverService {
    List<DriverDTO> getDrivers();
    DriverDTO getDriverById(long id);

}
