package i5b5.mwsi.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;


@Entity
@Table(name = "CRIMINAL_RECORDS")
public class CriminalRecords implements Serializable{


    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "record_id")
    private long recordId;
    @ManyToOne()
    @JoinColumn(name = "DRIVER_ID")
    private Driver driver;
    @Column(name = "CASH_AMOUNT")
    private Double cashAmount;
    @Column(name = "PENALTY_POINTS")
    private Integer penaltyPoints;
    @Column(name = "ISSUE_DATE")
    private Date issueDate;
    @Column(name = "DESCRIPTION")
    private String description;


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

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public Double getCashAmount() {
        return cashAmount;
    }

    public void setCashAmount(Double cashAmount) {
        this.cashAmount = cashAmount;
    }

    public Integer getPenaltyPoints() {
        return penaltyPoints;
    }

    public void setPenaltyPoints(Integer penaltyPoints) {
        this.penaltyPoints = penaltyPoints;
    }

    public Date getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
