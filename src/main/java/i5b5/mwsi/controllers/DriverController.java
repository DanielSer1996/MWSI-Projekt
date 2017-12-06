package i5b5.mwsi.controllers;

import i5b5.mwsi.services.DriverService;
import i5b5.mwsi.services.dto.BasicDriverInfo;
import i5b5.mwsi.services.dto.DriverDetails;
import i5b5.mwsi.services.impl.DriverServiceImpl;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * Created by daniel on 15.11.17.
 */
@RestController
public class DriverController {
    private DriverService driverService = new DriverServiceImpl();

    @RequestMapping(value = "/driver/{id}",
                    method = RequestMethod.GET
    )
    public DriverDetails getDriverById(@PathVariable("id") long id){
        return driverService.getDriverById(id);
    }

    @RequestMapping(value = "/drivers",
                    method = RequestMethod.GET
    )
    public List<BasicDriverInfo> getDrivers(){
        List<BasicDriverInfo> drivers;

        drivers = driverService.getDrivers();

        for (BasicDriverInfo driverInfo : drivers)
            System.out.println(driverInfo.getDriverId());

        return drivers;
    }

}
