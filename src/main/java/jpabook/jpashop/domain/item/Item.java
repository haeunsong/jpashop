package jpabook.jpashop.domain.item;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/*
<< 엔티티 >>
id
name
price:int
stockQuantity:int
categories: List
=> book(author,isbn),album(artist,etc),movie(director,actor)

 */
@Entity
// SINGLE_TABLE 전략: 한 테이블에 다 때려박는것
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="dtype")
@Getter @Setter
public abstract class Item {
    @Id
    @GeneratedValue
    @Column(name="item_id")
    private Long id;

    private String name;
    private int price;
    private int stockQuantity;




}
