package Hero.Jobman.job.jobimpl;

import Hero.Jobman.job.Dto.JobDTO;
import Hero.Jobman.job.Job;
import Hero.Jobman.job.JobRepository;
import Hero.Jobman.job.JobService;
import Hero.Jobman.job.clients.CompanyClient;
import Hero.Jobman.job.clients.ReviewClient;
import Hero.Jobman.job.external.Company;
import Hero.Jobman.job.external.Review;
import Hero.Jobman.mapper.Jobmapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class JobServiceImpl implements JobService {

    private final CompanyClient companyClient;
    private final ReviewClient reviewClient;
    private final JobRepository jobRepository;
    private long nextid = 1L;

    @Override
    public List<JobDTO> findAll() {
        List<Job> jobs = jobRepository.findAll();
        return jobs.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    private JobDTO convertToDto(Job job) {
        //        RestTemplate restTemplate = new RestTemplate();
//        Company company = restTemplate.getForObject("http://COMPANY-SERVICE:8081/companies/"
//                        + job.getCompanyID(),
//                Company.class);
//        ResponseEntity<List<Review>> reviewResponse=restTemplate.exchange("http://REVIEW-SERVICE:8083/review?companyId=" +
//                        company.getId(),
//                HttpMethod.GET,
//                null,
//                new ParameterizedTypeReference<List<Review>>() {
//                });
//        List<Review> reviews=reviewResponse.getBody();


        // Fetch the company details
        Company company = companyClient.getCompany(job.getCompanyID());

        // Fetch the reviews for the company
        List<Review> reviews = reviewClient.getReviews(job.getCompanyID());

        // Map the job, company, and reviews to JobDTO
        return Jobmapper.maptoJobWithCompanyDTO(job, company, reviews);
    }

    @Override
    public void createjob(Job job) {
        job.setId(nextid++);
        jobRepository.save(job);
    }

    @Override
    public JobDTO getById(Long id) {
        Job job = jobRepository.findById(id).orElse(null);
        return job != null ? convertToDto(job) : null;
    }

    @Override
    public boolean deleteJob(Long id) {
        try {
            jobRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean updateJob(long id, Job updateJob) {
        Optional<Job> jobOptional = jobRepository.findById(id);
        if (jobOptional.isPresent()) {
            Job job = jobOptional.get();
            job.setTitle(updateJob.getTitle());
            job.setDescription(updateJob.getDescription());
            job.setMaxSalary(updateJob.getMaxSalary());
            job.setMinSalary(updateJob.getMinSalary());
            job.setLocation(updateJob.getLocation());
            jobRepository.save(job);
            return true;
        }
        return false;
    }
}

