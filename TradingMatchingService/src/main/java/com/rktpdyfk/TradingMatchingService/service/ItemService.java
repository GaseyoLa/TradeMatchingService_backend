package com.rktpdyfk.TradingMatchingService.service;

import com.rktpdyfk.TradingMatchingService.dto.TextSearchDto;
import com.rktpdyfk.TradingMatchingService.entity.Item;
import com.rktpdyfk.TradingMatchingService.repository.ItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemService {
    private final ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public List<TextSearchDto> searchItem(String keyword){
        List<Item> items = itemRepository.findByKeyword(keyword);
        List<TextSearchDto> result = items.stream()
                .map(item -> TextSearchDto.builder()
                        .id(item.getId())
                        .name(item.getName())
                        .image(item.getImage())
                        .build())
                .collect(Collectors.toList());
        return result;
    }
}