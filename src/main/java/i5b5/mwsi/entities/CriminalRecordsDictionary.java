package i5b5.mwsi.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "CRIMINAL_RECORDS_DICTIONARY")
public class CriminalRecordsDictionary implements Serializable{
    @Id
    @Column(name = "CR_DICTIONARY_ID")
    private long crDictionaryId;
    @Column(name = "CR_DICTIONARY_TYPE")
    private String crDictionaryType;
    @Column(name = "CR_DICTIONARY_POINTS")
    private int crDictionaryPoints;

    public CriminalRecordsDictionary() {
    }

    public CriminalRecordsDictionary(long crDictionaryId, String crDictionaryType, int crDictionaryPoints) {
        this.crDictionaryId = crDictionaryId;
        this.crDictionaryType = crDictionaryType;
        this.crDictionaryPoints = crDictionaryPoints;
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
