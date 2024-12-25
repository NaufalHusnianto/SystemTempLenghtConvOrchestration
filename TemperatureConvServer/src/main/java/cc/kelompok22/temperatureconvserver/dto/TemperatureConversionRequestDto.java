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

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }
}
