package hello.itemservice.domain.item;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository // 안에 @Component 존재
public class ItemRepository {

    private static final Map<Long, Item> store = new HashMap<>(); // static, 실제로는 HashMap 사용하면 안된다고 함 ->멀티 쓰레드에서 접근하면 ConcurrentMap 사용해야 한다고 함
    private static long sequence = 0L; //static // 얘도 동시 접근하면 값이 꼬일 수 있다고 함 어터믹롱? 그런거 사용해야 한다고 함

    public Item save(Item item) {
        item.setId(++sequence);
        store.put(item.getId(), item);
        return item;
    }

    public Item findById(Long id) {
        return store.get(id);
    }

    public List<Item> findAll() {
        return new ArrayList<>(store.values());
    }

    public void update(Long itemId, Item updateParam) {
        Item findItem = findById(itemId);
        findItem.setItemName(updateParam.getItemName());
        findItem.setPrice(updateParam.getPrice());
        findItem.setQuantity(updateParam.getQuantity());
    }

    public void clearStore() {
        store.clear();
    }
}
