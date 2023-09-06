package jpabook.jpashop.domain;

import jakarta.persistence.*;
import jpabook.jpashop.domain.item.Item;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Category {

    @Id @GeneratedValue
    @Column(name="category_id")
    private Long id;

    private String name;

    @ManyToMany // category와 item 은 다대다 관계
    // 중간에 테이블을 하나 만들어준다. (category와 item 사이에)-실전에서는 사용X.
    @JoinTable(name="category_item",
            joinColumns= @JoinColumn(name="category_id"),
            inverseJoinColumns = @JoinColumn(name="item_id")
    )
    private List<Item> items = new ArrayList<>();

    // 카테고리 만들기 // self로 연관에 연관걸기!
    @ManyToOne // 부모입장에서는 자식이 여러명이니까
    @JoinColumn(name="parent_id")
    private Category parent;

    @OneToMany(mappedBy = "parent")// 자식입장에서는 부모 한 명
    private List<Category> child = new ArrayList<>();







}
