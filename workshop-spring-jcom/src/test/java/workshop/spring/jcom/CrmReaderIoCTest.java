package workshop.spring.jcom;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import cross.infrastructure.exception.CrossCommunicationException;
import cross.integration.cfram.CloseMode;
import cross.integration.cfram.device.internal.FileDevice;

@ContextConfiguration(locations="classpath:META-INF/workshop.jcom.spring.xml")
public class CrmReaderIoCTest extends AbstractTestNGSpringContextTests
{
    @Autowired
    private CrmReader target;
    
    @Test
    public void readData() throws CrossCommunicationException
    {
        FileDevice device = new FileDevice();
        device.setDataSource(new File("src/test/resources/contacts.txt"));
        device.setProcInfoSource(new File("src/test/resources/crmpisource.txt"));
        device.setProcInfoSink(new File("target/crmpisink.txt"));
        target.readData("test", device);
        device.close(CloseMode.ACCEPT, "");
    }

}
