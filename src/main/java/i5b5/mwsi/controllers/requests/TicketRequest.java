package i5b5.mwsi.controllers.requests;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.sql.Date;

public class TicketRequest implements Serializable{
    @NotNull
    private Long driverId;
    @NotNull
    private Double cashAmount;
    @NotNull
    private Integer penaltyPoints;
    private Date issueDate;
    private String description;

    public Long getDriverId() {
        return driverId;
    }

    public void setDriverId(Long driverId) {
        this.driverId = driverId;
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
