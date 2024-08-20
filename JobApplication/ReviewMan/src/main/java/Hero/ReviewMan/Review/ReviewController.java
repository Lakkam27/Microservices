package Hero.ReviewMan.Review;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reviews")
public class ReviewController {

    private final ReviewService reviewService;

    @Autowired
    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping
    public ResponseEntity<List<Review>> getAllReviews(@RequestParam(required = false) Long companyId) {
        return new ResponseEntity<>(reviewService.getAllReviews(companyId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> addReview(@RequestParam Long companyId, @RequestBody Review review) {
        boolean result = reviewService.addReview(companyId, review);
        if (result) {
            return new ResponseEntity<>("Review successfully added", HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("Review not found", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("{reviewId}")
    public ResponseEntity<Review> getReview(@PathVariable long reviewId) {
        return new ResponseEntity<>(reviewService.getReview(reviewId), HttpStatus.OK);
    }

    @PutMapping("/{reviewId}")
    public ResponseEntity<String> updateReview(@PathVariable long reviewId, @RequestBody Review review) {
        boolean isReviewUpdated = reviewService.updateReview(reviewId, review);
        if (isReviewUpdated) {
            return new ResponseEntity<>("Review has been updated", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Review not updated", HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @DeleteMapping("/{reviewId}")
    public ResponseEntity<String> deleteReview(@PathVariable long reviewId) {
        boolean isReviewDeleted = reviewService.deleteReview(reviewId);
        if (isReviewDeleted) {
            return new ResponseEntity<>("Review has been deleted", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Review not deleted", HttpStatus.NOT_ACCEPTABLE);
        }
    }
}
