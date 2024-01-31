package com.rktpdyfk.TradingMatchingService.service;

import com.rktpdyfk.TradingMatchingService.entity.OptionPost;
import com.rktpdyfk.TradingMatchingService.repository.OptionPostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OptionPostService {
    private final OptionPostRepository optionPostRepository;
    private void createOptionPost(OptionPost optionPost) {
        optionPostRepository.save(optionPost);
    }
}
