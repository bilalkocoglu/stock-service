package com.example.youtube.stockservice.dto;

public class CalculateAwardMilesWithTaxRequestDto {
    private String awardType;
    private String wantMoreMiles;
    private String isOneWay;
    private String departureOrigin;
    private String departureDestination;
    private int departureDateDay;
    private int departureDateMonth;
    private int departureDateYear;

    public CalculateAwardMilesWithTaxRequestDto(String awardType, String wantMoreMiles, String isOneWay, String departureOrigin, String departureDestination, int departureDateDay, int departureDateMonth, int departureDateYear) {
        this.awardType = awardType;
        this.wantMoreMiles = wantMoreMiles;
        this.isOneWay = isOneWay;
        this.departureOrigin = departureOrigin;
        this.departureDestination = departureDestination;
        this.departureDateDay = departureDateDay;
        this.departureDateMonth = departureDateMonth;
        this.departureDateYear = departureDateYear;
    }

    public CalculateAwardMilesWithTaxRequestDto() {
    }

    public String getAwardType() {
        return awardType;
    }

    public void setAwardType(String awardType) {
        this.awardType = awardType;
    }

    public String getWantMoreMiles() {
        return wantMoreMiles;
    }

    public void setWantMoreMiles(String wantMoreMiles) {
        this.wantMoreMiles = wantMoreMiles;
    }

    public String getIsOneWay() {
        return isOneWay;
    }

    public void setIsOneWay(String isOneWay) {
        this.isOneWay = isOneWay;
    }

    public String getDepartureOrigin() {
        return departureOrigin;
    }

    public void setDepartureOrigin(String departureOrigin) {
        this.departureOrigin = departureOrigin;
    }

    public String getDepartureDestination() {
        return departureDestination;
    }

    public void setDepartureDestination(String departureDestination) {
        this.departureDestination = departureDestination;
    }

    public int getDepartureDateDay() {
        return departureDateDay;
    }

    public void setDepartureDateDay(int departureDateDay) {
        this.departureDateDay = departureDateDay;
    }

    public int getDepartureDateMonth() {
        return departureDateMonth;
    }

    public void setDepartureDateMonth(int departureDateMonth) {
        this.departureDateMonth = departureDateMonth;
    }

    public int getDepartureDateYear() {
        return departureDateYear;
    }

    public void setDepartureDateYear(int departureDateYear) {
        this.departureDateYear = departureDateYear;
    }
}
