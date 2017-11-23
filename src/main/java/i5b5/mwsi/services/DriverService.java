package i5b5.mwsi.services;

import i5b5.mwsi.services.dto.DriverDTO;

import java.util.Set;

public interface DriverService {
    Set<DriverDTO> getDrivers();
    DriverDTO getDriverById(long id);

}
