package pl.asseco.junittest.business;

import org.junit.jupiter.api.Test;
import pl.asseco.junittest.data.DataService;

import static org.assertj.core.api.Assertions.assertThat;

class DataServiceStub implements DataService {
    @Override
    public int[] retrieveAll() {
        return new int[] {1,2,3,4};
    }
}

public class BusinessClassStubTest {

    @Test
    void calculateSum() {
        BusinessClassImpl businessClass = new BusinessClassImpl();
        businessClass.setDataService(new DataServiceStub());
        assertThat(businessClass.sumValues(1,2,3,4)).isEqualTo(10).as("Sum value is not equal!!");
    }


    @Test
    void calculateSumWithData() {
        BusinessClassImpl businessClass = new BusinessClassImpl();
        businessClass.setDataService(new DataServiceStub());
        assertThat(businessClass.calculateWithDataService()).isEqualTo(10).as("Sum value is not equal!!");
    }
}
