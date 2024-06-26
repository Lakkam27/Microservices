package Hero.ReviewMan.Review;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;
@Service
public class ReviewServiceImpl implements ReviewService {
    private final ReviewRepository reviewRepository;

    public ReviewServiceImpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public List<Review> getAllReviews(Long companyId) {
        return reviewRepository.findByCompanyId(companyId);
    }

    @Override
    public boolean addReview(Long companyId, Review review) {
        if (companyId != null) {
            review.setCompanyId(companyId);
            reviewRepository.save(review);
            return true;
        }
        return false;
    }

    @Override
    public Review getReview(long reviewId) {
        return reviewRepository.findById(reviewId).orElse(null);
    }

    @Override
    public boolean updateReview(long reviewId, Review updateReview) {
        Review review = reviewRepository.findById(reviewId).orElse(null);
        if (review != null) {
            review.setCompanyId(updateReview.getCompanyId());
            review.setTitle(updateReview.getTitle());
            review.setDescription(updateReview.getDescription());
            review.setRating(updateReview.getRating());
            reviewRepository.save(review);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteReview(long reviewId) {
        Review review = reviewRepository.findById(reviewId).orElse(null);
        if (review != null) {
            reviewRepository.delete(review);
            return true;
        }
        return false;
    }
}
