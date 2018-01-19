package i5b5.mwsi.controllers;

import i5b5.mwsi.controllers.factories.HttpHeaderFactory;
import i5b5.mwsi.services.DriverService;
import i5b5.mwsi.services.dto.BasicDriverInfo;
import i5b5.mwsi.services.dto.DriverDetails;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;


/**
 * Created by daniel on 15.11.17.
 */
@RestController
public class DriverController {
    private final DriverService driverService;
    private final HttpHeaderFactory headerFactory;

    private final Logger logger = Logger.getLogger(DriverController.class);

    @Autowired
    public DriverController(DriverService driverService, HttpHeaderFactory headerFactory) {
        this.driverService = driverService;
        this.headerFactory = headerFactory;
    }

    @RequestMapping(value = "/drivers",
            method = RequestMethod.GET)
    public ResponseEntity<List<BasicDriverInfo>> getDrivers() throws Exception {
        List<BasicDriverInfo> drivers = driverService.getDrivers();

        return new ResponseEntity<>(drivers, headerFactory.getHttpHeader(), HttpStatus.OK);
    }


    @RequestMapping(value = "/driver/{id}",
                    method = RequestMethod.GET
    )
    public ResponseEntity<DriverDetails> getDriverById(@PathVariable("id") long id){
        DriverDetails driverDetails = driverService.getDriverById(id);
        driverDetails.setCategories(driverService.getLicenseCategories(driverDetails.getDrivingLicenseNumber()));


        return new ResponseEntity<>(driverDetails,
                                    headerFactory.getHttpHeader(),
                                    HttpStatus.OK);
    }


    @RequestMapping(value = "/drivers/search",
                    method = RequestMethod.GET)
    public ResponseEntity<List<BasicDriverInfo>> getSpecifiedDrivers(@RequestParam("criteria") String criteria) throws ExecutionException, InterruptedException {
        List<BasicDriverInfo> specifiedDrivers = driverService.getSpecifiedDrivers(criteria);

        return new ResponseEntity<>(specifiedDrivers,headerFactory.getHttpHeader(),HttpStatus.OK);
    }

//    @RequestMapping(value = "/license/{id}/categories")
//    public ResponseEntity<List<LicenseCategoryData>> getCategoriesByLicense(@PathVariable("id") String id){
//        List<LicenseCategoryData> categories = driverService.getLicenseCategories(id);
//
//        return new ResponseEntity<>(categories,headerFactory.getHttpHeader(),HttpStatus.OK);
//    }

}
