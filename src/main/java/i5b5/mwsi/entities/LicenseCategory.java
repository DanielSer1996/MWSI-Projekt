package i5b5.mwsi.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "LICENSE_CATEGORY")
public class LicenseCategory implements Serializable{
    @Id
    @Column(name = "CATEGORY_ID")
    private long categoryId;
    @Column(name = "CATEGORY_TYPE")
    private String categoryType;
    @Column(name = "CATEGORY_DESCRIPTION")
    private String description;

    @ManyToMany(mappedBy = "categories",fetch = FetchType.EAGER)
    @JsonIgnore
    private List<DrivingLicense> licenses = new ArrayList<>();

    public LicenseCategory() {
    }

    public LicenseCategory(long categoryId, String categoryType, String description) {
        this.categoryId = categoryId;
        this.categoryType = categoryType;
        this.description = description;
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
