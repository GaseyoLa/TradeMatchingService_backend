package com.rktpdyfk.TradingMatchingService.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EmailErrorResult {
    private String code;
    private String message;
}
