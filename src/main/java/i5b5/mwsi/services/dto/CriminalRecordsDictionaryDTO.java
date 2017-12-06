package i5b5.mwsi.services.dto;

import i5b5.mwsi.entities.CriminalRecords;
import i5b5.mwsi.entities.CriminalRecordsDictionary;

public class CriminalRecordsDictionaryDTO
{
    private long crDictionaryId;
    private String crDictionaryType;
    private int crDictionaryPoints;

    public CriminalRecordsDictionaryDTO(CriminalRecordsDictionary crd)
    {
        this.crDictionaryId = crd.getCrDictionaryId();
        this.crDictionaryType = crd.getCrDictionaryType();
        this.crDictionaryPoints = crd.getCrDictionaryPoints();
    }
    public long getCrDictionaryId() {
        return crDictionaryId;
    }

    public void setCrDictionaryId(long crDictionaryId) {
        this.crDictionaryId = crDictionaryId;
    }

    public String getCrDictionaryType() {
        return crDictionaryType;
    }

    public void setCrDictionaryType(String crDictionaryType) {
        this.crDictionaryType = crDictionaryType;
    }

    public int getCrDictionaryPoints() {
        return crDictionaryPoints;
    }

    public void setCrDictionaryPoints(int crDictionaryPoints) {
        this.crDictionaryPoints = crDictionaryPoints;
    }
}
