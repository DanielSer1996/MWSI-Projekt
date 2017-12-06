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
@CrossOrigin(origins = "localhost:10010", maxAge = 3600)
@RequestMapping(headers = {"Access-Control-Allow-Origin*"})
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
    public List<BasicDriverInfo> getDrivers(){
        List<BasicDriverInfo> drivers;

        drivers = driverService.getDrivers();

        return drivers;
    }

}
