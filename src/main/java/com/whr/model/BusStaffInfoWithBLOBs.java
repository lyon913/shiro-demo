package com.whr.model;

public class BusStaffInfoWithBLOBs extends BusStaffInfo {
    private byte[] cardFront;

    private byte[] cardOppoSide;

    public byte[] getCardFront() {
        return cardFront;
    }

    public void setCardFront(byte[] cardFront) {
        this.cardFront = cardFront;
    }

    public byte[] getCardOppoSide() {
        return cardOppoSide;
    }

    public void setCardOppoSide(byte[] cardOppoSide) {
        this.cardOppoSide = cardOppoSide;
    }
}