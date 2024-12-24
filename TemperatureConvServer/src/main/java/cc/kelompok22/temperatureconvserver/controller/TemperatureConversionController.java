package cc.kelompok22.temperatureconvserver.controller;

import cc.kelompok22.temperatureconvserver.dto.TemperatureConversionRequestDto;
import cc.kelompok22.temperatureconvserver.dto.TemperatureConversionResponseDto;
import cc.kelompok22.temperatureconvserver.service.TemperatureConversionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TemperatureConversionController {

    @Autowired
    private TemperatureConversionService conversionService;

    @PostMapping("/hit")
    public ResponseEntity<TemperatureConversionResponseDto> convertTemperature(@RequestBody TemperatureConversionRequestDto request) {
        try {
            double convertedValue = conversionService.convertTemperature(
                    request.getValue(),
                    request.getFromUnit(),
                    request.getToUnit()
            );

            TemperatureConversionResponseDto response = new TemperatureConversionResponseDto(
                    convertedValue,
                    "Conversion successful"
            );

            return ResponseEntity.ok(response);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(
                    new TemperatureConversionResponseDto(0, e.getMessage())
            );
        }
    }
}
