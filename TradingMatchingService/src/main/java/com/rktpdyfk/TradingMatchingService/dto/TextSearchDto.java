package com.rktpdyfk.TradingMatchingService.dto;

import com.rktpdyfk.TradingMatchingService.entity.Item;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TextSearchDto {

    private Long id;

    private String image;

    private String nameKr;

    public TextSearchDto(Item item){
        this.id = item.getId();
        this.image = item.getImage();
        this.nameKr = item.getNameKr();
    }
}