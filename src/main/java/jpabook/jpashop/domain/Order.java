package jpabook.jpashop.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="orders")
@Getter
@Setter
public class Order {

    @Id @GeneratedValue
    @Column(name="order_id")
    private Long id;

    // order와 member 는 다대일 관계
    // '다' 인 Order 쪽에 외래키가 존재한다.
    // 얘가 연관관계의 주인
    @ManyToOne
    @JoinColumn(name="member_id")
    private Member member;


    // order와 orderItems 는 일대다 관계
    @OneToMany(mappedBy = "order")
    private List<OrderItem> orderItems = new ArrayList<>();

    // 하나의 배송정보는 하나의 주문정보
    // 그렇다면 어디에 외래키를 둘까?
    // 여기서는 orders에 두자. => 연관관계 주인
    @OneToOne
    @JoinColumn(name="delivery_id")
    private Delivery delivery;

    private LocalDateTime orderDate; // 주문시간

    @Enumerated(EnumType.STRING)
    private OrderStatus status; // 주문상태 [ORDER, CANCEL]





}
