package com.github.thanglequoc.aqicalculatorspringboot.aqicalculator.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NowcastAQICalculationRequest extends AQICalculationRequest {
    private double[] concentrationsLast12Hours;
}
