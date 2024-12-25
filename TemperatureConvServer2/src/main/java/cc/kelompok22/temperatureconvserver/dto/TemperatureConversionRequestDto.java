package cc.kelompok22.temperatureconvserver.dto;

public class TemperatureConversionRequestDto {
    private double value;
    private String from;
    private String to;

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String fromUnit) {
        this.from = fromUnit;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String toUnit) {
        this.to = toUnit;
    }
}
