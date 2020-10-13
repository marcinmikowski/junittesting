package pl.asseco.junittest;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class StringTest {

    @BeforeAll
    public static void beforeAll() {
        System.out.println("Before all");
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("After all");
    }

    @BeforeEach
    public void beforeEach(TestInfo testInfo) {
        System.out.println("Before each " + testInfo.getDisplayName());
    }

    @AfterEach
    public void afterEach(TestInfo testInfo) {
        System.out.println("After each test " + testInfo.getDisplayName());
    }

    @Test
    @DisplayName("When str is null throw an exception")
    public void expectException() {
        String str = null;
        assertThrows(NullPointerException.class,
                () -> {
                    str.length();
                });
    }

    @Test
    public void someTest() {
        System.out.println("SomeTest");
        var length = "ABCD".length();
        assertEquals(4, length);
        assertThat(length).isEqualTo(4);
    }

    @Disabled
    @Test
    @RepeatedTest(10)
    public void someOtherTest() {
        System.out.println("Some other test");
    }

    @ParameterizedTest
    @ValueSource(strings = {"AA", "BB", "CC", "DD"})
    public void length_greather_then_zero(String str) {
        assertTrue(str.length() > 0);
    }

    @ParameterizedTest
    @CsvSource({"abcd, ABCD", "efg, EFG"})
    void uppercaseTest(String word, String expected) {
        assertEquals(expected, word.toUpperCase());
    }

    @ParameterizedTest(name = "{0} equals {1}")
    @CsvFileSource(resources = "/upperFile.csv")
    void uppFileTest(String expected, String word) {
        assertEquals(expected, word.toUpperCase());
    }

    @Test
    void performaceTest() {
        assertTimeout(Duration.ofSeconds(1), () -> {
            for (int i = 0; i < 2; i++) {
                System.out.println(1);
            }
        });

    }

    @Nested
    class EmptyStringTest {

        private String str = "AAA";

        @BeforeEach
        void beforeTest() {
            str = "";
            System.out.println("Before test");
        }

        @Test
        void empty() {
            assertTrue(str.isEmpty());
        }

    }
}
