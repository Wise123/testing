package org.example.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.RequiredArgsConstructor;
import org.example.service.lookup.LookupService;
import org.example.validator.RegionValidator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/bpmn")
@RequiredArgsConstructor
public class MainController {
    private final LookupService lookupService;
    private final RegionValidator regionValidator;

    @GetMapping("/initialize")
    @Operation(summary = "initialize business process")
    public int main(
            @RequestParam(defaultValue = "1")
            @Parameter(description = "region code, one, two or three symbols, may be added several values per request")
            String[] regionNumbers
    ) {
        Set<String> regionNumbersCroppedAndDeduplicated =
                Arrays.stream(regionNumbers)
                        .map(item -> item.length() == 1 ? "0" + item : item)
                        .map(item -> item.length() > 2 ? item.substring(1,3) : item)
                        .collect(Collectors.toSet());

        regionValidator.validate(regionNumbersCroppedAndDeduplicated.stream().toList());
        return lookupService.count(regionNumbersCroppedAndDeduplicated.stream().toList());
    }
}
