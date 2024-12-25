package cc.k3522077.lengthconvserver.controller;

import cc.k3522077.lengthconvserver.dto.RequestDto;
import cc.k3522077.lengthconvserver.dto.ResponseDto;
import cc.k3522077.lengthconvserver.service.LengthConvService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LengthConvController {
    @Autowired
    private LengthConvService lengthConvService;

    @PostMapping("/hit")
    public ResponseEntity<ResponseDto> convertLength (@RequestBody RequestDto request){
        try {

            double convertedValue = lengthConvService.ConvertValue(
                    request.getValue(),
                    request.getFrom(),
                    request.getTo()
            );


            ResponseDto response = new ResponseDto(convertedValue, "Successfull");
            return ResponseEntity.ok(response);

        } catch (IllegalArgumentException e) {

            ResponseDto errorResponse = new ResponseDto(0, "Invalid input: " + e.getMessage());
            return ResponseEntity.badRequest().body(errorResponse);

        } catch (Exception e) {
            ResponseDto errorResponse = new ResponseDto(0, "An error occurred: " + e.getMessage());
            return ResponseEntity.status(500).body(errorResponse);
        }




    }

}
