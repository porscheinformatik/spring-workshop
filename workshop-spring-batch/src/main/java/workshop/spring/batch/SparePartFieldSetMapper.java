package workshop.spring.batch;

import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

import workshop.spring.jpa.entities.SparePart;

public class SparePartFieldSetMapper implements FieldSetMapper<SparePart>
{

    @Override
    public SparePart mapFieldSet(FieldSet fieldSet) throws BindException
    {
        SparePart sparePart = new SparePart();
        sparePart.setNumber(fieldSet.readString("number"));
        sparePart.setPrice(fieldSet.readDouble("price"));
        return sparePart;
    }

}
