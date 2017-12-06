package i5b5.mwsi.services.dto;

import i5b5.mwsi.entities.CarReview;

import java.util.Date;

public class CarReviewData
{
    private String reviewId;
    private Date reviewDate;
    private Date expireDate;
    private String comments;
    private CarData reviewedCar;

    public CarReviewData(CarReview carReview)
    {
        this.reviewId = carReview.getReviewId();
        this.reviewDate = carReview.getReviewDate();
        this.expireDate = carReview.getExpireDate();
        this.comments = carReview.getComments();
        this.reviewedCar = new CarData(carReview.getReviewedCar());
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

    public CarData getReviewedCarDTO() {
        return reviewedCar;
    }

    public void setReviewedCarDTO(CarData reviewedCar) {
        this.reviewedCar = reviewedCar;
    }
}
