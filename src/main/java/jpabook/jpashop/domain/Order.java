package jpabook.jpashop.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

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





}
