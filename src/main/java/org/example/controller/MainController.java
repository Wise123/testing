package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.service.lookup.LookupService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/main")
@RequiredArgsConstructor
public class MainController {
    private final LookupService lookupService;

    @GetMapping("/")
    public int main(
            @RequestParam(defaultValue = "59")
            int[] regionNumbers
    ) {
        return lookupService.count(regionNumbers);
    }
}
