package workshop.spring.batch;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

@ContextConfiguration(locations={"classpath:META-INF/workshop.spring.batch.xml", "classpath:META-INF/worckshop.spring.batch.contact.xml"})
public class SpringBatchTest extends AbstractTestNGSpringContextTests
{
    @Autowired
    private JobLauncher jobLauncher;
    @Autowired
    private Job job;
    
    @Test
    public void importCsv() throws JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException, JobParametersInvalidException
    {
        JobParameters jobParameters = new JobParameters();
        jobLauncher.run(job, jobParameters);
    }

}
