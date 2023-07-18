package com.hospitality.SiHotel.enumeration;

import lombok.Getter;

public enum RoomType {

    RS("Regular Single Bed"),

    RD("Regular Double Bed"),

    RT("Regular Twin Bed"),

    VS("VIP Single Bed"),

    VD("VIP Double Bed"),

    VT("VIP Twin Bed");

    @Getter
    private final String label;

    RoomType(String label) {
        this.label = label;
    }

}
