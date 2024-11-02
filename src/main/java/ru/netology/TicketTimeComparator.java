package ru.netology;

import java.util.Comparator;

public class TicketTimeComparator implements Comparator<Ticket> {

    @Override
    public int compare(Ticket t1, Ticket t2) {
        int flightDuration1 = t1.getTimeTo() - t1.getTimeFrom();
        int flightDuration2 = t2.getTimeTo() - t2.getTimeFrom();
        return Integer.compare(flightDuration1, flightDuration2);
    }
}

