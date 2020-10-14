package pl.asseco.junittest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.asseco.junittest.model.Item;

public interface ItemRepository extends JpaRepository<Item, Integer> {
}
