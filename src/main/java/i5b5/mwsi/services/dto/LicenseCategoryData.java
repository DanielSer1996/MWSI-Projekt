package i5b5.mwsi.services.dto;

import i5b5.mwsi.entities.LicenseCategory;

public class LicenseCategoryData
{
    private long categoryId;
    private String categoryType;
    private String description;

    public LicenseCategoryData(LicenseCategory lc)
    {
        categoryId = lc.getCategoryId();
        categoryType = lc.getCategoryType();
        description = lc.getDescription();
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
}
