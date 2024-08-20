package Hero.Jobman.mapper;

import Hero.Jobman.job.Dto.JobDTO;
import Hero.Jobman.job.Job;
import Hero.Jobman.job.external.Company;
import Hero.Jobman.job.external.Review;

import java.util.List;

public class Jobmapper {
    public static JobDTO maptoJobWithCompanyDTO(Job job , Company company, List<Review> review){
        JobDTO jobDTO =new JobDTO();
        jobDTO.setId(job.getId());
        jobDTO.setTitle(job.getTitle());
        jobDTO.setDescription(job.getDescription());
        jobDTO.setLocation(job.getLocation());
        jobDTO.setMinSalary(job.getMinSalary());
        jobDTO.setMaxSalary(job.getMaxSalary());
        jobDTO.setCompany(company);
        jobDTO.setReview(review);
        return jobDTO;

    }
}
