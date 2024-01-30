package com.rktpdyfk.TradingMatchingService.entity;

import jakarta.persistence.Id;
import lombok.*;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "item_index")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class ItemElastic {

    @Id
    private Long id;

    private String name;

}
