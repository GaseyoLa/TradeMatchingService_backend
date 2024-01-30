package com.rktpdyfk.TradingMatchingService.service;

import com.rktpdyfk.TradingMatchingService.dto.ItemSearchDto;
import com.rktpdyfk.TradingMatchingService.repository.ItemRepositoryElastic;
import org.springframework.stereotype.Service;

@Service
public class SearchService {

    private final ItemRepositoryElastic itemRepositoryElastic;

    public SearchService(ItemRepositoryElastic itemRepositoryElastic) {
        this.itemRepositoryElastic = itemRepositoryElastic;
    }

    public Iterable<ItemSearchDto> getNamesOfItem(String name){
        return itemRepositoryElastic.findAllByNameContains(name);
    }
}
