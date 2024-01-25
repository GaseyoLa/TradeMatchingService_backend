package com.rktpdyfk.TradingMatchingService.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Table(name = "item_job")
public class ItemJob {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_job_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "job_id", insertable = false, updatable = false, nullable = false)
    private Job job;

    @ManyToOne
    @JoinColumn(name = "item_id", insertable = false, updatable = false, nullable = false)
    private Item item;

}
