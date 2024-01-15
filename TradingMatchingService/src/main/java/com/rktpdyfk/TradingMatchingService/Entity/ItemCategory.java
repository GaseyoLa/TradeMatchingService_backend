package com.rktpdyfk.TradingMatchingService.Entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "item_category")
public class ItemCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_category_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "category_id", insertable = false, updatable = false, nullable = false)
    private Category category;

    @ManyToOne
    @JoinColumn(name = "Item_id", insertable = false, updatable = false, nullable = false)
    private Item item;

}
