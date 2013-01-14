package workshop.spring.data;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public class CrmFacade
{
    @Autowired
    private ContactRepository repository;
    
    public List<ContactReport> reportFindAll()
    {
        return repository.reportFindAll();
    }

}
