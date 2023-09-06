package jpabook.jpashop.domain;

/*
<< 엔티티 >>
OrderITem
- id
- item: Item
- order: Order
- orderPrice
- count
 */

import jakarta.persistence.*;
import jpabook.jpashop.domain.item.Item;
import lombok.Getter;
import lombok.Setter;

@Entity @Getter
@Setter
public class OrderItem {

    @Id
    @GeneratedValue
    @Column(name="order_item_id")
    private Long id;

    // orderItem - item => 다대일(한개의 아이템을 여러번 주문할 수 있으므로)
    @ManyToOne
    @JoinColumn(name="item_id")
    private Item item;

    @ManyToOne
    @JoinColumn(name="order_id")
    private Order order;

    private int orderPrice; // 주문가격
    private int count; // 주문수량

}
