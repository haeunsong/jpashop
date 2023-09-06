package jpabook.jpashop.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Delivery {
    @Id
    @GeneratedValue
    @Column(name="delivery_id")
    private Long id;

    // delivery와 order는 일대일 매핑
    // order의 delivery 필드와 매핑
    @OneToOne(mappedBy = "delivery")
    private Order order;

    @Embedded
    private Address address;

    // ordinal은 1,2,3 숫자로 들어가니까 꼭 string 으로 사용하기!
    @Enumerated(EnumType.STRING)
    private DeliveryStatus status; // READY, CAMP

}
