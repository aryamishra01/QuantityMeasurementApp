package com.qma.quantity.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.qma.quantity.dto.HistoryRequest;

@FeignClient(name = "HISTORY-SERVICE")
public interface HistoryClient {

    @PostMapping("/history")
    void saveHistory(@RequestBody HistoryRequest request);
}