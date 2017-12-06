package i5b5.mwsi.controllers;

import i5b5.mwsi.services.DriverService;
import i5b5.mwsi.services.dto.BasicDriverInfo;
import i5b5.mwsi.services.dto.DriverDetails;
import i5b5.mwsi.services.impl.DriverServiceImpl;
import org.springframework.web.bind.annotation.*;

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
                    method = RequestMethod.GET)
    @CrossOrigin(origins = "http://localhost:9000")
    public List<BasicDriverInfo> getDrivers(){
        List<BasicDriverInfo> drivers;

        drivers = driverService.getDrivers();

        return drivers;
    }

}
