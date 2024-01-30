package com.rktpdyfk.TradingMatchingService.dto;

import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ItemSearchDto {
//    @Size(min=1,max=50)
    private String name;
}
