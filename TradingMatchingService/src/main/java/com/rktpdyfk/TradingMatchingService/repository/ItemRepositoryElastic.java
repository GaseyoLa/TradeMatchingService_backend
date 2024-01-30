package com.rktpdyfk.TradingMatchingService.repository;

import com.rktpdyfk.TradingMatchingService.dto.ItemSearchDto;
import com.rktpdyfk.TradingMatchingService.entity.ItemElastic;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepositoryElastic extends ElasticsearchRepository<ItemElastic,Long> {
    List<ItemSearchDto> findAllByNameContains(String name);
//    List<String> findAllNamesByNameContains(String name);
}
