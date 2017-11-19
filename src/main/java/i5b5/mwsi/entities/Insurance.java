package i5b5.mwsi.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "INSURANCE")
public class Insurance implements Serializable{
    @Id
    @Column(name = "INSURANCE_ID")
    private long insuranceId;
    @Column(name = "INSURANCE_BEGIN_DATE")
    private Date beginDate;
    @Column(name = "INSURANCE_EXPIRE_DATE")
    private Date expireDate;
    @Column(name = "INSURANCE_TYPE")
    private String type;

    public Insurance() {
    }

    public Insurance(long insuranceId, Date beginDate, Date expireDate, String type) {
        this.insuranceId = insuranceId;
        this.beginDate = beginDate;
        this.expireDate = expireDate;
        this.type = type;
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
