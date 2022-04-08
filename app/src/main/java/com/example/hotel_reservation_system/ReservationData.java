package com.example.hotel_reservation_system;

import java.util.List;

public class ReservationData {

    Long guestId;
    String hotelName;
    String check_in;
    String check_out;
    List<GuestListData> guestList;

    public ReservationData() {
    }

    public ReservationData(Long guestId, String hotelName, String check_in, String check_out, List<GuestListData> guestList) {
        this.guestId = guestId;
        this.hotelName = hotelName;
        this.check_in = check_in;
        this.check_out = check_out;
        this.guestList = guestList;
    }

    public Long getGuestId() {
        return guestId;
    }

    public void setGuestId(Long guestId) {
        this.guestId = guestId;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getCheck_in() {
        return check_in;
    }

    public void setCheck_in(String check_in) {
        this.check_in = check_in;
    }

    public String getCheck_out() {
        return check_out;
    }

    public void setCheck_out(String check_out) {
        this.check_out = check_out;
    }

    public List<GuestListData> getGuestList() {
        return guestList;
    }

    public void setGuestList(List<GuestListData> guestList) {
        this.guestList = guestList;
    }
}
