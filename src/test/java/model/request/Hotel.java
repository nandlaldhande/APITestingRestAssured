/*
 * Copyright (c) 2020.
 * All rights reserved.
 */

package model.request;

import java.util.List;

/**
 * @author Nandlal
 * @since 28-APR-2020
 */
public class Hotel {
    private Dates dates;

    private String destination;

    private List<Room> room;

    private String placeId;

    public Hotel(String destination, String placeId) {
        this.destination = destination;
        this.placeId = placeId;
    }

    public void setDates(Dates dates) {
        this.dates = dates;
    }

    public Dates getDates() {
        return this.dates;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDestination() {
        return this.destination;
    }

    public void setRoom(List<Room> room) {
        this.room = room;
    }

    public List<Room> getRoom() {
        return this.room;
    }

    public void setPlaceId(String placeId) {
        this.placeId = placeId;
    }

    public String getPlaceId() {
        return this.placeId;
    }
}

