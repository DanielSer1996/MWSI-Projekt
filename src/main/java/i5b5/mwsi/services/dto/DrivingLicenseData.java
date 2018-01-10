package i5b5.mwsi.services.dto;

import i5b5.mwsi.entities.DrivingLicense;
import i5b5.mwsi.entities.LicenseCategory;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DrivingLicenseData
{
    private Long licenseId;
    private Date issueDate;
    private Date expireDate;
    private String licenseNumber;
    private List<LicenseCategoryData> categories = new ArrayList<LicenseCategoryData>();

    public DrivingLicenseData(DrivingLicense dl)
    {
        licenseId = dl.getLicenseId();
        issueDate = dl.getIssueDate();
        expireDate = dl.getExpireDate();
        for(LicenseCategory lc : dl.getCategories())
        {
            categories.add(new LicenseCategoryData(lc));
        }
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

    public List<LicenseCategoryData> getCategories() {
        return categories;
    }

    public void setCategories(List<LicenseCategoryData> categories) {
        this.categories = categories;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }
}
