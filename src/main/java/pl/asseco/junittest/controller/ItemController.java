package pl.asseco.junittest.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.asseco.junittest.model.Item;

@RestController
public class ItemController {

    @GetMapping("/dummy-item")
    public Item getItem() {
        return new Item(1, "Ball", 10, 10);
    }
}
