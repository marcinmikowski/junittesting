package pl.asseco.junittest.business;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.asseco.junittest.data.DataService;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

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
        doNothing().when(dataServiceMock).doSomeTest();
        assertThat(businessClass.calculateWithDataService()).isEqualTo(15).as("Sum value is not equal!!");
        dataServiceMock.doSomeTest();
        verify(dataServiceMock, times(1)).retrieveAll();
    }

    @Test
    void testList() {
        List mock = mock(List.class);
        when(mock.size()).thenReturn(5).thenReturn(10);
        assertThat(mock.size()).isEqualTo(5);
        assertThat(mock.size()).isEqualTo(10);
    }

    @Test
    void testListGet() {
        List mock = mock(List.class);
        when(mock.get(0)).thenReturn("text");
        assertThat(mock.get(0)).isEqualTo("text");
        assertThat(mock.get(1)).isNull();
        verify(mock, times(2)).get(anyInt());
        verify(mock, atMost(2)).get(anyInt());
        verify(mock, atLeast(2)).get(anyInt());
        verify(mock, never()).get(2);
    }

    @Test
    void argumentCapturing() {
        List mock = mock(List.class);
        mock.add("SomeString1");
        mock.add("SomeString2");

        ArgumentCaptor<String> argumentCaptor = ArgumentCaptor.forClass(String.class);

        verify(mock, times(2)).add(argumentCaptor.capture());

        //assertThat(argumentCaptor.getValue()).isEqualTo("SomeString1");
        List values = List.of("SomeString1", "SomeString2");
        assertThat(argumentCaptor.getAllValues()).isEqualTo(values);
    }

    @Test
    void spaying() {
        ArrayList arrayListSpy = spy(ArrayList.class);
        arrayListSpy.add("Test");

        assertThat(arrayListSpy.get(0)).isEqualTo("Test");
    }

    @Test
    void testListGeneric() {
        List mock = mock(List.class);
        when(mock.get(anyInt())).thenReturn("text");
        assertThat(mock.get(anyInt())).isEqualTo("text");
    }

    @Test
    void mockBusinessObject() {
        var underTest = mock(BusinessClassImpl.class);
        when(underTest.calculateWithDataService()).thenReturn(50);
        assertThat(underTest.calculateWithDataService()).isEqualTo(50);

        try (MockedStatic<BusinessClassImpl> theMock = Mockito.mockStatic(BusinessClassImpl.class)) {
            theMock.when(BusinessClassImpl::getName).thenReturn("WTF");
            assertThat(BusinessClassImpl.getName()).isEqualTo("WTF");
        }
    }

    @Test
    void simpleVerify() {
        List mock = mock(List.class);
        when(mock.get(0)).thenReturn("someValue");

        String value = (String) mock.get(0);

        assertThat(value).isEqualTo("someValue");
        verify(mock).get(0);
    }
}
