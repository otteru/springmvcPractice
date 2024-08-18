package hello.itemservice.domain.item;

import lombok.Data;

@Data
/**
 * @Data를 사용해도 되지만 얘는 다 지원해줘서 오히려 위험하다.
 * 그래서 실무에서는 @Getter, @Setter 정도만 사용하자.
 */
public class Item {

    private Long id;
    private String itemName;
    private Integer price;
    private Integer quantity; // 수량이나 가격이 null로 들어올 수 있어서 Integer

    public Item() {
    }

    public Item(String itemName, Integer price, Integer quantity) {
        this.id = id;
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }
}
