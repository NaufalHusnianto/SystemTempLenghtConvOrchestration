package cc.k3522077.lengthconvserver.service;

import cc.k3522077.lengthconvserver.dto.RequestDto;
import org.springframework.stereotype.Service;

@Service
public class LengthConvService {
    public double ConvertValue (double value, String from, String to) {
        if (from.equalsIgnoreCase("Meter") && to.equalsIgnoreCase("Kilometer")) {
            return value / 1000;
        } else if (from.equalsIgnoreCase("Meter") && to.equalsIgnoreCase("Inci")) {
            return value * 39.3701;
        } else if (from.equalsIgnoreCase("Kilometer") && to.equalsIgnoreCase("Meter")) {
            return value * 1000;
        }else if (from.equalsIgnoreCase("Kilometer") && to.equalsIgnoreCase("Inci")) {
            return value * 1000 * 39.3701;
        } else if (from.equalsIgnoreCase("Inci") && to.equalsIgnoreCase("Meter")) {
            return value / 39.3701;
        } else if (from.equalsIgnoreCase("Inci") && to.equalsIgnoreCase("Kilometer")) {
            return value * (1000 * 39.3701);
        }else {
            throw new IllegalArgumentException("Invalid Length Unit");
        }
    }
}
