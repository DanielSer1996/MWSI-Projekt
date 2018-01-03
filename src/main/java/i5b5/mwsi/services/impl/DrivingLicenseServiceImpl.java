package i5b5.mwsi.services.impl;

import i5b5.mwsi.entities.DrivingLicense;
import i5b5.mwsi.entities.LicenseCategory;
import i5b5.mwsi.services.DrivingLicenseService;
import i5b5.mwsi.utility.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;

@Service
public class DrivingLicenseServiceImpl implements DrivingLicenseService{
    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    @Override
    public void suspendDrivingLicense(long id) {
        Session session = sessionFactory.openSession();

        session.beginTransaction();

        DrivingLicense drivingLicense = session.get(DrivingLicense.class,id);
        drivingLicense.setSuspended(true);

        session.update(drivingLicense);

        session.getTransaction().commit();
        session.close();
    }
}
