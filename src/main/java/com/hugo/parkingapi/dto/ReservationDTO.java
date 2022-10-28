package com.hugo.parkingapi.dto;

public class ReservationDTO {
    private String reservationCode;

    public ReservationDTO() {
    }

    public ReservationDTO(String reservationCode) {
        this.reservationCode = reservationCode;
    }

    public String getReservationCode() {
        return this.reservationCode;
    }

    public void setReservationCode(String reservationCode) {
        this.reservationCode = reservationCode;
    }
}
