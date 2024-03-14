package com.rktpdyfk.TradingMatchingService.service;

import com.rktpdyfk.TradingMatchingService.dto.ItemDto;
import com.rktpdyfk.TradingMatchingService.dto.TextSearchDto;
import com.rktpdyfk.TradingMatchingService.entity.Item;
import com.rktpdyfk.TradingMatchingService.repository.ItemRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemService {
    private final ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public List<TextSearchDto> searchItems(String keyword){
        List<Item> items = itemRepository.findItemListByKeyword(keyword);
        List<TextSearchDto> result = items.stream()
                .map(TextSearchDto::new)
                .collect(Collectors.toList());
        return result;
    }

    public List<TextSearchDto> searchItemsPage(String keyword, int pageNumber, int pageSize){
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        Page<Item> items = itemRepository.findItemListByKeywordPage(keyword,pageable);
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