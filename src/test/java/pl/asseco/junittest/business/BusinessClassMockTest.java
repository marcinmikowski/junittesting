package pl.asseco.junittest.business;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.asseco.junittest.data.DataService;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BusinessClassMockTest {

    @InjectMocks
    private BusinessClassImpl businessClass = new BusinessClassImpl();

    @Mock
    private DataService dataServiceMock;

    @BeforeEach
    void setUp() {
        businessClass.setDataService(dataServiceMock);
    }

    @Test
    void calculateSum() {
        when(dataServiceMock.retrieveAll()).thenReturn(new int[] {1,2,3,4});

        assertThat(businessClass.calculateWithDataService()).isEqualTo(10).as("Sum value is not equal!!");
    }

    @Test
    void calculateSumWithData() {
        when(dataServiceMock.retrieveAll()).thenReturn(new int[] {1,2,3,4,5});

        assertThat(businessClass.calculateWithDataService()).isEqualTo(15).as("Sum value is not equal!!");
    }
}
