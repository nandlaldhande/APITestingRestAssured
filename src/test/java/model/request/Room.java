/*
 * Copyright (c) 2020.
 * All rights reserved.
 */

package model.request;

import java.util.List;

public class Room
{
    private List<Guest> guest;

    public void setGuest(List<Guest> guest){
        this.guest = guest;
    }
    public List<Guest> getGuest(){
        return this.guest;
    }

    @Override
    public String toString() {
        return "Room{" +
                "guest=" + guest +
                '}';
    }
}
