package com.rktpdyfk.TradingMatchingService.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Indexed;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Builder
@Table(name = "items",indexes = {
        @Index(columnList = "name")
})
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id")
    private Long id;

    @Column(name = "name", nullable = false, unique = true)
    @Size(max=30)
    private String name;

    @ManyToOne
    @JoinColumn(name = "category_id", insertable = false, updatable = false, nullable = true)
    private Category category;

    @Column(name = "image")
    private String image;

    @OneToMany(mappedBy = "item")
    private List<Post> posts;

    @OneToMany(mappedBy = "item")
    private List<ItemJob> itemJobs;
}
