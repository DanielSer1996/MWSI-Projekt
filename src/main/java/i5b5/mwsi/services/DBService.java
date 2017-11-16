package i5b5.mwsi.services;

import i5b5.mwsi.entities.Driver;

import java.util.Set;

public interface DBService {
    Set<Driver> getDrivers();
    Driver getDriverById(long id);

}
