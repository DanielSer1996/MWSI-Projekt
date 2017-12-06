package i5b5.mwsi.services.dto;

import i5b5.mwsi.entities.Insurance;

import java.util.Date;

public class InsuranceData
{
    private long insuranceId;
    private Date beginDate;
    private Date expireDate;
    private String type;

    public InsuranceData(Insurance in)
    {
        insuranceId = in.getInsuranceId();
        beginDate = in.getBeginDate();
        expireDate = in.getExpireDate();
        type = in.getType();
    }

    public long getInsuranceId() {
        return insuranceId;
    }

    public void setInsuranceId(long insuranceId) {
        this.insuranceId = insuranceId;
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Date getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(Date expireDate) {
        this.expireDate = expireDate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
