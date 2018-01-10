package i5b5.mwsi.services.dto;

import i5b5.mwsi.entities.LicenseCategory;

public class LicenseCategoryData
{
    private String categoryType;

    public LicenseCategoryData(LicenseCategory lc)
    {
        categoryType = lc.getCategoryType();
    }

    public String getCategoryType() {
        return categoryType;
    }

    public void setCategoryType(String categoryType) {
        this.categoryType = categoryType;
    }
}
