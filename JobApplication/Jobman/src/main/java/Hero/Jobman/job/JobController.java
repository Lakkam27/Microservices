package Hero.Jobman.job;

import Hero.Jobman.job.Dto.JobDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/jobs")
public class JobController {

    private final JobService jobService;

    @GetMapping()
    public ResponseEntity<List<JobDTO>> findAll() {
        return ResponseEntity.ok(jobService.findAll());
    }

    @PostMapping()
    public ResponseEntity<String> createjob(@RequestBody Job job) {
        jobService.createjob(job);
        return new ResponseEntity<>("Job is added successfully", HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<JobDTO> getById(@PathVariable Long id) {
        JobDTO jobDTO = jobService.getById(id);
        if (jobDTO != null) {
            return new ResponseEntity<>(jobDTO, HttpStatus.OK);
        }
        return new ResponseEntity<>(jobDTO, HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteJob(@PathVariable Long id) {
        boolean deleted = jobService.deleteJob(id);
        if (deleted) {
            return new ResponseEntity<>("Successfully deleted job", HttpStatus.OK);
        }
        return new ResponseEntity<>("The job you are looking for is not found", HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateJob(@PathVariable long id, @RequestBody Job updateJob) {
        boolean update = jobService.updateJob(id, updateJob);
        if (update) {
            return new ResponseEntity<>("Job is successfully updated", HttpStatus.OK);
        }
        return new ResponseEntity<>("Job is NOT FOUND", HttpStatus.NOT_FOUND);
    }
}
