package pl.asseco.junittest.business;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.asseco.junittest.model.Item;
import pl.asseco.junittest.repository.ItemRepository;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ItemBusinessServiceTest {

    @InjectMocks
    private ItemBusinessService itemBusinessService;

    @Mock
    private ItemRepository itemRepository;

    @Test
    void findAllMethodTest() {
        when(itemRepository.findAll()).thenReturn(List.of(new Item(1, "Item 1", 30, 60)));

        List<Item> items = itemBusinessService.retriveAllItems();

        for(Item item: items) {
            assertThat(item.getValue()).isEqualTo(item.getPrice() * item.getQuantity());
        }
    }

    @Test
    public void calculateSumUsingDataService() {
        when(itemRepository.findAll()).thenReturn(List.of(
                new Item(2, "Item2", 10, 10),
                new Item(3, "Item3", 20, 20)
        ));

        List<Item> items = itemBusinessService.retriveAllItems();

        assertThat(items.get(0).getValue()).isEqualTo(100);
        assertThat(items.get(1).getValue()).isEqualTo(400);
    }
}
