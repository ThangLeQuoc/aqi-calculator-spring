package com.github.thanglequoc.aqicalculatorspringboot.aqicalculator.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegularAQICalculationRequest extends AQICalculationRequest {
    private double concentration;
}
