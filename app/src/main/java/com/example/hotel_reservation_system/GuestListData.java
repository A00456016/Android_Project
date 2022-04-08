package com.example.hotel_reservation_system;

public class GuestListData {

    Long id;
    String guestName;
    String gender;

    public GuestListData() {
    }
    public GuestListData(Long id, String guestName, String gender) {
        this.id = id;
        this.guestName = guestName;
        this.gender = gender;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGuestName() {
        return guestName;
    }

    public void setGuestName(String guestName) {
        this.guestName = guestName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
