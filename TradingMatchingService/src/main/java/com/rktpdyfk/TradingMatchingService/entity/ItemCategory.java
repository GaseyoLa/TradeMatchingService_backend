package com.rktpdyfk.TradingMatchingService.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
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
