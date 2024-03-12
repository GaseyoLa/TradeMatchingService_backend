package com.rktpdyfk.TradingMatchingService.service;

import com.rktpdyfk.TradingMatchingService.dto.ItemDto;
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
        List<Item> items = itemRepository.findItemListByKeyword(keyword);
        List<TextSearchDto> result = items.stream()
                .map(TextSearchDto::new)
                .collect(Collectors.toList());
        return result;
    }

    //특정 아이템 검색
    public ItemDto.ItemInfoDto getItemInfoByNameKr(String nameKr){
        return new ItemDto.ItemInfoDto(itemRepository.findOneByNameKr(nameKr).get());
    }
}