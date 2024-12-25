package cc.kelompok22.temperatureconvserver.dto;

public class TemperatureConversionResponseDto {
    private double converted_value;
    private String message;

    public TemperatureConversionResponseDto(double converted_value, String message) {
        this.converted_value = converted_value;
        this.message = message;
    }

    public double getConverted_value() {
        return converted_value;
    }

    public void setConverted_value(double converted_value) {
        this.converted_value = converted_value;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
