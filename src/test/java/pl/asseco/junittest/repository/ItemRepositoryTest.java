package pl.asseco.junittest.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import pl.asseco.junittest.model.Item;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@DataJpaTest
public class ItemRepositoryTest {

    @Autowired
    private ItemRepository itemRepository;

    @Test
    void findAllTest() {
        final List<Item> itemList = itemRepository.findAll();
        assertThat(itemList.size()).isEqualTo(4);
    }

    @Test
    void findItemNo1001() {
        final Optional<Item> itemOptional = itemRepository.findById(1001);

        assertThat(itemOptional.get().getId()).isEqualTo(1001);
    }
}
