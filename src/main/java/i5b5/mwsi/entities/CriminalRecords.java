package i5b5.mwsi.entities;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "CRIMINAL_RECORDS")
public class CriminalRecords implements Serializable{


    @Id
    @Column(name = "record_id")
    private long recordId;
    @ManyToOne
    @JoinColumn(name = "DRIVER_ID")
    private Driver driver;
    @ManyToOne
    @JoinColumn(name = "CR_DICTIONARY_ID")
    private CriminalRecordsDictionary type;


    public CriminalRecords(long recordId){
        this.recordId = recordId;
    }

    public CriminalRecords(){

    }

    public long getRecordId() {
        return recordId;
    }

    public void setRecordId(long recordId) {
        this.recordId = recordId;
    }

    public CriminalRecordsDictionary getType() {
        return type;
    }

    public void setType(CriminalRecordsDictionary type) {
        this.type = type;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }
}
