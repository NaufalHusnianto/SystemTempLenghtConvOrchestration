package cc.kelompok22.temperatureconvserver.dto;

public class TemperatureConversionResponseDto {
    private double convertedValue;
    private String message;

    public TemperatureConversionResponseDto(double convertedValue, String message) {
        this.convertedValue = convertedValue;
        this.message = message;
    }

    public double getConvertedValue() {
        return convertedValue;
    }

    public void setConvertedValue(double convertedValue) {
        this.convertedValue = convertedValue;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
