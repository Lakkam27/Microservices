package Hero.ReviewMan.Review;

import java.util.List;

public interface ReviewService {
    List<Review> getAllReviews(Long companyId);
    boolean addReview(Long companyId, Review review);
    Review getReview(long reviewId);
    boolean updateReview(long reviewId, Review review);
    boolean deleteReview(long reviewId);
}