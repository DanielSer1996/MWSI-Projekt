package i5b5.mwsi.services.dto;

import i5b5.mwsi.entities.DrivingLicense;
import i5b5.mwsi.entities.LicenseCategory;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DrivingLicenseDTO
{
    private long licenseId;
    private Date issueDate;
    private Date expireDate;
    private List<LicenseCategoryDTO> categories = new ArrayList<LicenseCategoryDTO>();

    public DrivingLicenseDTO(DrivingLicense dl)
    {
        licenseId = dl.getLicenseId();
        issueDate = dl.getIssueDate();
        expireDate = dl.getExpireDate();
        for(LicenseCategory lc : dl.getCategories())
        {
            categories.add(new LicenseCategoryDTO(lc));
        }
    }

    public long getLicenseId() {
        return licenseId;
    }

    public void setLicenseId(long licenseId) {
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

    public List<LicenseCategoryDTO> getCategories() {
        return categories;
    }

    public void setCategories(List<LicenseCategoryDTO> categories) {
        this.categories = categories;
    }
}
