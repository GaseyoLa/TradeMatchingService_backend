package com.rktpdyfk.TradingMatchingService.controller;

import com.rktpdyfk.TradingMatchingService.dto.TextSearchDto;
import com.rktpdyfk.TradingMatchingService.service.ItemService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SearchController {
    private final ItemService itemService;

    public SearchController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping("/search/item/all/{keyword}")
    public ResponseEntity<List<TextSearchDto>> searchItems(@PathVariable String keyword){
        return ResponseEntity.ok(itemService.searchItems(keyword));
    }

    //page기능 추가
    @GetMapping("/search/item/page/")
    public ResponseEntity<List<TextSearchDto>> searchItemsWithPage(
            @RequestParam("keyword") String keyword,
            @RequestParam(value = "pageNumber", defaultValue = "0") int pageNumber,
            @RequestParam(value = "pageSize", defaultValue = "5") int pageSize){
        return ResponseEntity.ok(itemService.searchItemsPage(keyword, pageNumber, pageSize));
    }
}
