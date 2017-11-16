package i5b5.mwsi.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "CRIMINAL_RECORDS")
public class CriminalRecords {


    @Id
    @Column(name = "RECORD_ID")
    private long recordId;
    @Column(name = "DRIVER_ID")
    private long driverId;
    @Column(name = "CR_DICTIONARY_ID")
    private long crDictionaryId;

    public CriminalRecords(long recordId, long driverId, long crDictionaryId){

        this.recordId = recordId;
        this.driverId = driverId;
        this.crDictionaryId = crDictionaryId;

    }

    public CriminalRecords(){

    }

    public long getRecordId() {
        return recordId;
    }

    public long getDriverId() {
        return driverId;
    }

    public long getCrDictionaryId() {
        return crDictionaryId;
    }

    public void setRecordId(long recordId) {
        this.recordId = recordId;
    }

    public void setDriverId(long driverId) {
        this.driverId = driverId;
    }

    public void setCrDictionaryId(long crDictionaryId) {
        this.crDictionaryId = crDictionaryId;
    }
}
