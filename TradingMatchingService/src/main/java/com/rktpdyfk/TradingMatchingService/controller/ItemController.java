package com.rktpdyfk.TradingMatchingService.controller;

import com.rktpdyfk.TradingMatchingService.dto.ItemDto;
import com.rktpdyfk.TradingMatchingService.dto.TextSearchDto;
import com.rktpdyfk.TradingMatchingService.entity.Item;
import com.rktpdyfk.TradingMatchingService.service.ItemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ItemController {
    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping("/item/{nameKr}")
    public ResponseEntity<ItemDto.ItemInfoDto> getItemInfo(@PathVariable String nameKr){
        return ResponseEntity.ok(itemService.getItemInfoByNameKr(nameKr));
    }
}
