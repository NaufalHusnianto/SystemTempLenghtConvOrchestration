package cc.kelompok22.temperatureconvserver.service;

import org.springframework.stereotype.Service;

@Service
public class TemperatureConversionService {
    public double convertTemperature(double value, String fromUnit, String toUnit) {
        if (fromUnit.equalsIgnoreCase("Celsius") && toUnit.equalsIgnoreCase("Reamur")) {
            return (value * 4) / 5;
        } else if (fromUnit.equalsIgnoreCase("Celsius") && toUnit.equalsIgnoreCase("Kelvin")) {
            return value + 273;
        } else if (fromUnit.equalsIgnoreCase("Celsius") && toUnit.equalsIgnoreCase("Fahrenheit")) {
            return (value * 9 / 5) + 32;
        }

        else if (fromUnit.equalsIgnoreCase("Reamur") && toUnit.equalsIgnoreCase("Celsius")) {
            return (value * 5) / 4;
        } else if (fromUnit.equalsIgnoreCase("Reamur") && toUnit.equalsIgnoreCase("Kelvin")) {
            return ((value * 5) / 4) + 273;
        } else if (fromUnit.equalsIgnoreCase("Reamur") && toUnit.equalsIgnoreCase("Fahrenheit")) {
            return (value * 9) / 4 + 32;
        }

        else if (fromUnit.equalsIgnoreCase("Fahrenheit") && toUnit.equalsIgnoreCase("Celsius")) {
            return (value - 32) * 5 / 9;
        } else if (fromUnit.equalsIgnoreCase("Fahrenheit") && toUnit.equalsIgnoreCase("Reamur")) {
            return (value - 32) * 4 / 9;
        } else if (fromUnit.equalsIgnoreCase("Fahrenheit") && toUnit.equalsIgnoreCase("Kelvin")) {
            return (value - 32) * 5 / 9 + 273;
        }

        else if (fromUnit.equalsIgnoreCase("Kelvin") && toUnit.equalsIgnoreCase("Celsius")) {
            return value - 273;
        } else if (fromUnit.equalsIgnoreCase("Kelvin") && toUnit.equalsIgnoreCase("Reamur")) {
            return (value - 273) * 4 / 5;
        } else if (fromUnit.equalsIgnoreCase("Kelvin") && toUnit.equalsIgnoreCase("Fahrenheit")) {
            return (value - 273) * 9 / 5 + 32;
        } else {
            throw new IllegalArgumentException("Invalid temperature units provided.");
        }
    }
}
