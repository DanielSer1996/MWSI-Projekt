package i5b5.mwsi.endpoints;

import i5b5.mwsi.services.DriverService;
import i5b5.mwsi.services.dto.DriverDTO;
import i5b5.mwsi.services.impl.DriverServiceImpl;
import org.springframework.web.bind.annotation.*;


/**
 * Created by daniel on 15.11.17.
 */
@RestController
@RequestMapping("/drivers")
public class DriverController {
    private DriverService driverService = new DriverServiceImpl();

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public DriverDTO getDriverById(@PathVariable long id){
        DriverDTO driverDTO = driverService.getDriverById(id);
        System.out.println(driverDTO.getAddress().getAddressZipcode());
        return driverDTO;
    }
}