package Hero.Jobman.job;

import Hero.Jobman.job.Dto.JobDTO;

import java.util.List;

public interface JobService {
    List<JobDTO> findAll();
    void createjob(Job job);


    JobDTO getById(Long id);
    boolean deleteJob(Long id);

    boolean updateJob(long id, Job updateJob);


}
