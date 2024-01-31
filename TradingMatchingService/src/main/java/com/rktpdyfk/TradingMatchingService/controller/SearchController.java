package com.rktpdyfk.TradingMatchingService.controller;

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
public class SearchController {
    private final ItemService itemService;

    public SearchController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping("/search/{keyword}")
    public ResponseEntity<List<TextSearchDto>> searchItems(@PathVariable String keyword){
        return ResponseEntity.ok(itemService.searchItem(keyword));
    }
}
