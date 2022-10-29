package com.github.thanglequoc.aqicalculatorspringboot.pollutant;

import com.thanglequoc.aqicalculator.Pollutant;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;


@RestController
@RequestMapping("/pollutant")
public class PollutantController {

    /**
     * Get all the available pollutants for calculation
     * */
    @GetMapping
    public List<Pollutant> getAllPollutants() {
        return Arrays.asList(Pollutant.values());
    }
}
