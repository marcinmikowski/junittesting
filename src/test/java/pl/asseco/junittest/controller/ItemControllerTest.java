package pl.asseco.junittest.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import pl.asseco.junittest.business.ItemBusinessService;
import pl.asseco.junittest.model.Item;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(ItemController.class)
public class ItemControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ItemBusinessService itemBusinessService;

    @Test
    public void itemControllerTest() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/dummy-item")
                .accept(MediaType.APPLICATION_JSON);

        mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(content().json("{\"id\": 1,\"name\":\"Ball\",\"quantity\":10,\"price\":10}"))
                .andReturn();
    }

    @Test
    public void itemControllerBSTest() throws Exception {
        when(itemBusinessService.returnsHardcodedItem()).thenReturn(
                new Item(2, "Item 2", 10, 10)
        );

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/bs-item")
                .accept(MediaType.APPLICATION_JSON);

        mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(content().json("{\"id\": 2,\"name\":\"Item 2\",\"quantity\":10,\"price\":10}"))
                .andReturn();
    }

    @Test
    public void itemControllerDBTest() throws Exception {
        when(itemBusinessService.retriveAllItems()).thenReturn(
                List.of(new Item(2, "Item 2", 10, 10))
        );

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/db-items")
                .accept(MediaType.APPLICATION_JSON);

        mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(content().json("[{\"id\": 2,\"name\":\"Item 2\",\"quantity\":10,\"price\":10}]"))
                .andReturn();
    }
}
