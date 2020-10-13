package pl.asseco.junittest.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.asseco.junittest.business.ItemBusinessService;
import pl.asseco.junittest.model.Item;

@RestController
public class ItemController {

    @Autowired
    private ItemBusinessService itemBusinessService;

    @GetMapping("/dummy-item")
    public Item getItem() {
        return new Item(1, "Ball", 10, 10);
    }

    @GetMapping("/bs-item")
    public Item getBSItem() {
        System.out.println("Returning ");
        return itemBusinessService.returnsHardcodedItem();
    }
}
