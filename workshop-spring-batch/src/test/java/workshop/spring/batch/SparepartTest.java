package workshop.spring.batch;

import junit.framework.Assert;

import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
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
import org.testng.xml.LaunchSuite.ExistingSuite;

@ContextConfiguration(locations="classpath:META-INF/sparepart.spring.batch.xml")
public class SparepartTest extends AbstractTestNGSpringContextTests
{
    @Autowired
    private JobLauncher jobLauncher;
    @Autowired
    private Job job;
    
    @Test
    public void importCsv() throws JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException, JobParametersInvalidException
    {
        JobParameters jobParameters = new JobParameters();
        JobExecution jobExecution = jobLauncher.run(job, jobParameters);
        Assert.assertEquals(jobExecution.getExitStatus(), ExitStatus.COMPLETED);
    }

}
