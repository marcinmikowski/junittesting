package pl.asseco.junittest.business;

import org.springframework.stereotype.Component;
import pl.asseco.junittest.model.Item;

@Component
public class ItemBusinessService {

    public Item returnsHardcodedItem() {
        return new Item(1, "Ball", 10, 10);
    }

}
