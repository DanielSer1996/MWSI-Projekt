package i5b5.mwsi.services;

import i5b5.mwsi.services.dto.BasicDriverInfo;
import i5b5.mwsi.services.dto.DriverDetails;
import i5b5.mwsi.services.dto.LicenseCategoryData;
import org.springframework.stereotype.Service;

import java.util.List;


public interface DriverService {
    List<BasicDriverInfo> getDrivers();
    DriverDetails getDriverById(long id);
    List<BasicDriverInfo> getSpecifiedDrivers(String criteria);
    List<LicenseCategoryData> getLicenseCategories(String licenseId);
}
