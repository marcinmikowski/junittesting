package pl.asseco.junittest.spike;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

public class jsonAssertTest {

    @Test
    void jsonAssert() throws JSONException {
        String actR = "{\"id\":1,\"name\":\"Ball\",\"quantity\":10,\"price\":10}";
        String expR = "{\"id\":1,\"name\":\"Ball\",\"quantity\":10,\"price\":10}";
        JSONAssert.assertEquals(expR, actR, false);
    }
}
