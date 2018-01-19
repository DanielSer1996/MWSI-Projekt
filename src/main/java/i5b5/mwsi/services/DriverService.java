package i5b5.mwsi.services;

import i5b5.mwsi.services.dto.BasicDriverInfo;
import i5b5.mwsi.services.dto.DriverDetails;
import i5b5.mwsi.services.dto.LicenseCategoryData;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;


public interface DriverService {
    List<BasicDriverInfo> getDrivers();
    DriverDetails getDriverById(long id);
    List<BasicDriverInfo> getSpecifiedDrivers(String criteria) throws ExecutionException, InterruptedException;
    List<String> getLicenseCategories(String licenseId);
}
