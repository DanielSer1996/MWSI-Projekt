package i5b5.mwsi.services.impl;

import i5b5.mwsi.entities.DrivingLicense;
import i5b5.mwsi.services.DrivingLicenseService;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@EnableAsync
@Service
public class DrivingLicenseServiceImpl implements DrivingLicenseService {

    @PersistenceContext
    private EntityManager entityManager;

    @Async
    @Override
    public void suspendDrivingLicense(long id) {
        DrivingLicense drivingLicense = entityManager.find(DrivingLicense.class, id);
        drivingLicense.setSuspended(true);
        entityManager.merge(drivingLicense);
    }
}
