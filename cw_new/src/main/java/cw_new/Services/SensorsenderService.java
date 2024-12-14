package cw_new.Services;

import org.springframework.stereotype.Service;

@Service
public class SensorsenderService {

    private Float wasserstand; // Der zuletzt empfangene Wasserstand
    private String info;       // Die zuletzt empfangene Info

    public void setData(Float wasserstand, String info) {
        this.wasserstand = wasserstand;
        this.info = info;
    }

    public Float getWasserstand() {
        return wasserstand;
    }

    public String getInfo() {
        return info;
    }
}
