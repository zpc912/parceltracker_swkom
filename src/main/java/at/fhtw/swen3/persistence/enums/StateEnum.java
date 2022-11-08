package at.fhtw.swen3.persistence.enums;

import at.fhtw.swen3.services.dto.TrackingInformation;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum StateEnum {
    PICKUP,
    INTRANSPORT,
    INTRUCKDELIVERY,
    TRANSFERRED,
    DELIVERED;

    /*PICKUP("Pickup"),

    INTRANSPORT("InTransport"),

    INTRUCKDELIVERY("InTruckDelivery"),

    TRANSFERRED("Transferred"),

    DELIVERED("Delivered");

    private String value;

    StateEnum(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    @JsonCreator
    public static TrackingInformation.StateEnum fromValue(String value) {
        for (TrackingInformation.StateEnum b : TrackingInformation.StateEnum.values()) {
            if (b.value.equals(value)) {
                return b;
            }
        }
        throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }*/
}
