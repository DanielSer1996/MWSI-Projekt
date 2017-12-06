package i5b5.mwsi.services.dto;

import i5b5.mwsi.entities.DrivingLicense;
import i5b5.mwsi.entities.LicenseCategory;

import java.util.ArrayList;
import java.util.List;

public class LicenseCategoryDTO
{
    private long categoryId;
    private String categoryType;
    private String description;
    private List<DrivingLicenseDTO> licenses = new ArrayList<DrivingLicenseDTO>();

    public LicenseCategoryDTO(LicenseCategory lc)
    {
        categoryId = lc.getCategoryId();
        categoryType = lc.getCategoryType();
        description = lc.getDescription();
        for(DrivingLicense dl : lc.getLicenses())
        {
            licenses.add(new DrivingLicenseDTO(dl));
        }
    }

    public long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryType() {
        return categoryType;
    }

    public void setCategoryType(String categoryType) {
        this.categoryType = categoryType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<DrivingLicenseDTO> getLicenses() {
        return licenses;
    }

    public void setLicenses(List<DrivingLicenseDTO> licenses) {
        this.licenses = licenses;
    }
}
