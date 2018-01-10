package i5b5.mwsi.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "DRIVING_LICENSE")
public class DrivingLicense implements Serializable{
    @Id
    @Column(name = "LICENSE_ID")
    private Long licenseId;
    @Column(name = "ISSUE_DATE")
    private Date issueDate;
    @Column(name = "EXPIRE_DATE")
    private Date expireDate;
    @Column(name = "IS_SUSPENDED")
    private Boolean isSuspended;
    @Column(name = "LICENSE_NO")
    private String licenseNumber;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "DRIVING_LICENSE_CATEGORY_REL",
    joinColumns = {@JoinColumn(name = "LICENSE_ID")},
    inverseJoinColumns = {@JoinColumn(name = "CATEGORY_ID")})
    private List<LicenseCategory> categories = new ArrayList<>();

    public DrivingLicense() {
    }

    public DrivingLicense(Long licenseId, Date issueDate, Date expireDate, String licenseNumber , boolean isSuspended) {
        this.licenseId = licenseId;
        this.issueDate = issueDate;
        this.expireDate = expireDate;
        this.licenseNumber = licenseNumber;
        this.isSuspended = isSuspended;
    }

    public Long getLicenseId() {
        return licenseId;
    }

    public void setLicenseId(Long licenseId) {
        this.licenseId = licenseId;
    }

    public Date getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    public Date getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(Date expireDate) {
        this.expireDate = expireDate;
    }

    public List<LicenseCategory> getCategories() {
        return categories;
    }

    public void setCategories(List<LicenseCategory> categories) {
        this.categories = categories;
    }

    public Boolean getSuspended() {
        return isSuspended;
    }

    public void setSuspended(Boolean suspended) {
        isSuspended = suspended;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }
}
