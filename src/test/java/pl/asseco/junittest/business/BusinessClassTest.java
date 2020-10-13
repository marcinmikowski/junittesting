package pl.asseco.junittest.business;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BusinessClassTest {

    @Test
    void calculateSum() {
        BusinessClassImpl businessClass = new BusinessClassImpl();
        assertThat(businessClass.sumValues(1,2,3,4)).isEqualTo(10).as("Sum value is not equal!!");
    }
}
