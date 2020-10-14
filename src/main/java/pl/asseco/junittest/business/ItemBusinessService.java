package pl.asseco.junittest.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.asseco.junittest.model.Item;
import pl.asseco.junittest.repository.ItemRepository;

import java.util.List;

@Component
public class ItemBusinessService {

    @Autowired
    private ItemRepository itemRepository;

    public Item returnsHardcodedItem() {
        return new Item(1, "Ball", 10, 10);
    }

    public List<Item> retriveAllItems() {
        List<Item> items = itemRepository.findAll();
        items.forEach(i -> i.setValue(i.getPrice() * i.getQuantity()));
        return items;
    }
}
