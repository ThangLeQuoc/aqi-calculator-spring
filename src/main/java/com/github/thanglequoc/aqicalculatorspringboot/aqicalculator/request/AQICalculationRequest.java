package com.github.thanglequoc.aqicalculatorspringboot.aqicalculator.request;

import com.thanglequoc.aqicalculator.Pollutant;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class AQICalculationRequest {
    private Pollutant pollutant;
}
