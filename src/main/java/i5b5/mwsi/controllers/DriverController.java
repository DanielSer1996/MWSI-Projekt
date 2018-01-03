package i5b5.mwsi.controllers;

import i5b5.mwsi.controllers.factories.HttpHeaderFactory;
import i5b5.mwsi.services.DriverService;
import i5b5.mwsi.services.dto.BasicDriverInfo;
import i5b5.mwsi.services.dto.DriverDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * Created by daniel on 15.11.17.
 */
@RestController
@RequestMapping
public class DriverController {
    @Autowired
    private DriverService driverService;
    private HttpHeaderFactory headerFactory;

    public DriverController() {
        this.headerFactory = new HttpHeaderFactory();
    }

    @RequestMapping(value = "/driver/{id}",
                    method = RequestMethod.GET
    )
    public ResponseEntity<DriverDetails> getDriverById(@PathVariable("id") long id){
        return new ResponseEntity<>(driverService.getDriverById(id),
                                    headerFactory.getHttpHeader(),
                                    HttpStatus.OK);
    }

    @RequestMapping(value = "/drivers",
                    method = RequestMethod.GET)
    public ResponseEntity<List<BasicDriverInfo>> getDrivers(){
        List<BasicDriverInfo> drivers;
        drivers = driverService.getDrivers();

        return new ResponseEntity<>(drivers, headerFactory.getHttpHeader(), HttpStatus.OK);
    }

    @RequestMapping(value = "/drivers/search",
                    method = RequestMethod.GET)
    public ResponseEntity<List<BasicDriverInfo>> getSpecifiedDrivers(@RequestParam("criteria") String criteria){
        List<BasicDriverInfo> specifiedDrivers = driverService.getSpecifiedDrivers(criteria);

        return new ResponseEntity<>(specifiedDrivers,headerFactory.getHttpHeader(),HttpStatus.OK);
    }

}
