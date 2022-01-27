package com.code.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
@RefreshScope
public class ConfigHotRefreshController {
    @Value("${pattern.formatDate}")
    private String formatDate;


    @GetMapping("/getNowDate")
    public String getNowDate() {
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern(formatDate);
        return timeFormatter.format(LocalDateTime.now());
    }
}
