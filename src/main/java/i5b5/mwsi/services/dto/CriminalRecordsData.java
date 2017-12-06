package i5b5.mwsi.services.dto;

import i5b5.mwsi.entities.CriminalRecords;

public class CriminalRecordsData
{
    private long recordId;
    private DriverDetails driver;
    private CriminalRecordsDictionaryData type;

    public CriminalRecordsData(CriminalRecords cr)
    {
        this.recordId = cr.getRecordId();
        this.driver = new DriverDetails(cr.getDriver());
        this.type = new CriminalRecordsDictionaryData(cr.getType());
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

    public CriminalRecordsDictionaryData getType() {
        return type;
    }

    public void setType(CriminalRecordsDictionaryData type) {
        this.type = type;
    }
}
