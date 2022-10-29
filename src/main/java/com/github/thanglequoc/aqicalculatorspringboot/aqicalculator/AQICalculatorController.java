package com.github.thanglequoc.aqicalculatorspringboot.aqicalculator;

import com.github.thanglequoc.aqicalculatorspringboot.aqicalculator.request.NowcastAQICalculationRequest;
import com.github.thanglequoc.aqicalculatorspringboot.aqicalculator.request.RegularAQICalculationRequest;
import com.thanglequoc.aqicalculator.AQICalculator;
import com.thanglequoc.aqicalculator.AQIResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/aqi-calculator")
public class AQICalculatorController {

    private AQICalculator aqiCalculator;

    public AQICalculatorController() {
        this.aqiCalculator = AQICalculator.getAQICalculatorInstance();
    }

    @PostMapping("/aqi")
    public AQIResult calculateAQI(@RequestBody RegularAQICalculationRequest calculationRequest) {
        return aqiCalculator.getAQI(calculationRequest.getPollutant(), calculationRequest.getConcentration());
    }

    @PostMapping("/nowcast-aqi")
    public AQIResult calculateNowcastAQI(@RequestBody NowcastAQICalculationRequest calculationRequest) {
        return aqiCalculator.getNowCastAQI(calculationRequest.getPollutant(), calculationRequest.getConcentrationsLast12Hours());
    }
}
