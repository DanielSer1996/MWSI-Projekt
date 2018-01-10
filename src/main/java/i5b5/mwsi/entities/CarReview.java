package i5b5.mwsi.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "CAR_REVIEW")
public class CarReview implements Serializable {
    @Id
    @Column(name = "REVIEW_ID")
    private String reviewId;
    @Column(name = "REVIEW_DATE")
    private Date reviewDate;
    @Column(name = "REVIEW_EXPIRE_DATE")
    private Date expireDate;
    @Column(name = "REVIEW_COMMENTS")
    private String comments;
    @ManyToOne
    @JoinColumn(name = "CAR_VIN")
    private Car reviewedCar;

    public CarReview(String reviewId, Date reviewDate, Date expireDate) {
        this.reviewId = reviewId;
        this.reviewDate = reviewDate;
        this.expireDate = expireDate;
    }

    public CarReview() {
    }

    public String getReviewId() {
        return reviewId;
    }

    public void setReviewId(String reviewId) {
        this.reviewId = reviewId;
    }

    public Date getReviewDate() {
        return reviewDate;
    }

    public void setReviewDate(Date reviewDate) {
        this.reviewDate = reviewDate;
    }

    public Date getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(Date expireDate) {
        this.expireDate = expireDate;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Car getReviewedCar() {
        return reviewedCar;
    }

    public void setReviewedCar(Car carVin) {
        this.reviewedCar = carVin;
    }
}
