package i5b5.mwsi.controllers.requests;

import java.io.Serializable;

public class SuspendDrivingLicenseRequest implements Serializable{
    private long idLicense;

    public long getIdLicense() {
        return idLicense;
    }

    public void setIdLicense(long idLicense) {
        this.idLicense = idLicense;
    }
}
