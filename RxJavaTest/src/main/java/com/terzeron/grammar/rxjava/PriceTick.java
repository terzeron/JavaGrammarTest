package com.terzeron.grammar.rxjava;

import lombok.Data;

import java.text.SimpleDateFormat;
import java.util.Date;

@Data
public class PriceTick
{
    private final int sequence;
    private final Date date;
    private final String instrument;
    private final double price;
    private final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("hh:mm:ss");

    public boolean isLast() {
        return false;
    }
}
