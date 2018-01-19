package i5b5.mwsi.controllers;

import i5b5.mwsi.controllers.requests.SuspendDrivingLicenseRequest;
import i5b5.mwsi.controllers.factories.HttpHeaderFactory;
import i5b5.mwsi.services.DrivingLicenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping
public class DrivingLicenseController {
    @Autowired
    private DrivingLicenseService drivingLicenseService;
    private HttpHeaderFactory httpHeaderFactory;


    public DrivingLicenseController() {
        this.httpHeaderFactory = new HttpHeaderFactory();
    }

    @CrossOrigin
    @RequestMapping(value = "/suspend/license",
            method = RequestMethod.PUT,
            consumes = "application/json")
    public ResponseEntity suspendDrivingLicense(@RequestBody SuspendDrivingLicenseRequest idLicense) {
        try {
            drivingLicenseService.suspendDrivingLicense(idLicense.getIdLicense());
            return new ResponseEntity(httpHeaderFactory.getHttpHeader(), HttpStatus.OK);
        } catch (Throwable e) {
            return new ResponseEntity(httpHeaderFactory.getHttpHeader(), HttpStatus.NOT_FOUND);
        }
    }

}
