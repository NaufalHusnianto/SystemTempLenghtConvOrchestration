package cc.kelompok22.temperatureconvserver.service;

import org.springframework.stereotype.Service;

@Service
public class TemperatureConversionService {
    public double convertTemperature(double value, String from, String to) {
        if (from.equalsIgnoreCase("Celsius") && to.equalsIgnoreCase("Reamur")) {
            return (value * 4) / 5;
        } else if (from.equalsIgnoreCase("Celsius") && to.equalsIgnoreCase("Kelvin")) {
            return value + 273;
        } else if (from.equalsIgnoreCase("Celsius") && to.equalsIgnoreCase("Fahrenheit")) {
            return (value * 9 / 5) + 32;
        }

        else if (from.equalsIgnoreCase("Reamur") && to.equalsIgnoreCase("Celsius")) {
            return (value * 5) / 4;
        } else if (from.equalsIgnoreCase("Reamur") && to.equalsIgnoreCase("Kelvin")) {
            return ((value * 5) / 4) + 273;
        } else if (from.equalsIgnoreCase("Reamur") && to.equalsIgnoreCase("Fahrenheit")) {
            return (value * 9) / 4 + 32;
        }

        else if (from.equalsIgnoreCase("Fahrenheit") && to.equalsIgnoreCase("Celsius")) {
            return (value - 32) * 5 / 9;
        } else if (from.equalsIgnoreCase("Fahrenheit") && to.equalsIgnoreCase("Reamur")) {
            return (value - 32) * 4 / 9;
        } else if (from.equalsIgnoreCase("Fahrenheit") && to.equalsIgnoreCase("Kelvin")) {
            return (value - 32) * 5 / 9 + 273;
        }

        else if (from.equalsIgnoreCase("Kelvin") && to.equalsIgnoreCase("Celsius")) {
            return value - 273;
        } else if (from.equalsIgnoreCase("Kelvin") && to.equalsIgnoreCase("Reamur")) {
            return (value - 273) * 4 / 5;
        } else if (from.equalsIgnoreCase("Kelvin") && to.equalsIgnoreCase("Fahrenheit")) {
            return (value - 273) * 9 / 5 + 32;
        } else {
            throw new IllegalArgumentException("Invalid temperature units provided.");
        }
    }
}
