package jpabook.jpashop.domain;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Member {

    @Id
    @GeneratedValue
    @Column(name="member_id")
    private Long id;

    private String name;

    @Embedded
    private Address address;

    // member와 order는 일대다 관계
    // order 테이블에 있는 member 필드에 의해 난 매핑된거야
    @OneToMany(mappedBy = "member")
    private List<Order> orders = new ArrayList<>();


}
