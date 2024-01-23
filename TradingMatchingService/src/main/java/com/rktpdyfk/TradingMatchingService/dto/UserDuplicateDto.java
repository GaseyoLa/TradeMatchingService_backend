package com.rktpdyfk.TradingMatchingService.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
public class UserDuplicateDto {
    @NotNull
    @Size(min = 2, max = 50)
    private String username;

    @NotNull
    @Size(min = 2, max = 50)
    private String nickname;

    @NotNull
    @Size(min = 3, max = 50)
    private String email;
}
