package pl.asseco.junittest.controller;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ItemControllerIT {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    public void serviceTest() throws JSONException {
        String response = testRestTemplate.getForObject("/db-items", String.class);
        JSONAssert.assertEquals("[{id: 1001},{id: 1002},{id: 1003},{id: 1004}]", response, false);
    }


}
