/*
 * Copyright (c) 2020.
 * All rights reserved.
 */

package model.request;

public class Dates
{
    private String checkin;
    private String checkout;

    public void setCheckin(String checkin){
        this.checkin = checkin;
    }
    public String getCheckin(){
        return this.checkin;
    }
    public void setCheckout(String checkout){
        this.checkout = checkout;
    }
    public String getCheckout(){
        return this.checkout;
    }
}