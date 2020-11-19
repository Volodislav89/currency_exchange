package com.spring.currency_exchange.controller;

import com.spring.currency_exchange.model.Exchange;
import com.spring.currency_exchange.model.NbuCurrency;
import com.spring.currency_exchange.model.Stats;
import com.spring.currency_exchange.repository.StatsRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@RestController
@CrossOrigin
@AllArgsConstructor
public class StatsController {
    private StatsRepository statsRepository;
    private RestTemplate restTemplate;

    @PostMapping("/exchange")
    public Stats getStats(@RequestBody Exchange exchange) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<String>(headers);
        List<NbuCurrency> nbuCurrencyList = Arrays.asList(restTemplate.exchange("https://bank.gov.ua/NBUStatService/v1/statdirectory/exchange?json",
                HttpMethod.GET, entity, NbuCurrency[].class).getBody());
        NbuCurrency nbuCurrency = nbuCurrencyList.stream().filter(c -> c.getCc().equals(exchange.getOut())).findFirst().get();
        Double sum = exchange.getSum() / nbuCurrency.getRate();
        Stats stats = new Stats(exchange.getUserId(), sum);
        return statsRepository.save(stats);
    }

    @GetMapping("/stats")
    public List<Stats> findBySum(@RequestParam(value = "sum", required = false) Double sum,
                                 @RequestParam(value = "first", required = false) Double sum1,
                                 @RequestParam(value = "second", required = false) Double sum2) {
        if (sum !=null) {
            return statsRepository.findBySumLessThan(sum);
        }else if (sum1 != null && sum2 != null) {
            return statsRepository.findBySumBetween(sum1, sum2);
        }else
            return statsRepository.findAll();
    }
}

