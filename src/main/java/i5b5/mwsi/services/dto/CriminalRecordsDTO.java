package i5b5.mwsi.services.dto;

import i5b5.mwsi.entities.CriminalRecords;
import i5b5.mwsi.entities.CriminalRecordsDictionary;
import i5b5.mwsi.entities.Driver;

public class CriminalRecordsDTO
{
    private long recordId;
    private DriverDetails driver;
    private CriminalRecordsDictionaryDTO type;

    public CriminalRecordsDTO(CriminalRecords cr)
    {
        this.recordId = cr.getRecordId();
        this.driver = new DriverDetails(cr.getDriver());
        this.type = new CriminalRecordsDictionaryDTO(cr.getType());
    }

    public long getRecordId() {
        return recordId;
    }

    public void setRecordId(long recordId) {
        this.recordId = recordId;
    }

    public DriverDetails getDriver() {
        return driver;
    }

    public void setDriver(DriverDetails driver) {
        this.driver = driver;
    }

    public CriminalRecordsDictionaryDTO getType() {
        return type;
    }

    public void setType(CriminalRecordsDictionaryDTO type) {
        this.type = type;
    }
}
