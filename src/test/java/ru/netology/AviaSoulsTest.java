package ru.netology;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AviaSoulsTest {
    @Test
    public void shouldCompareByPrice() {
        Ticket ticket1 = new Ticket("SVO", "KZN", 5000, 800, 1000);
        Ticket ticket2 = new Ticket("SVO", "KZN", 4500, 900, 1100);
        assertTrue(ticket1.compareTo(ticket2) > 0);
    }

    @Test
    public void shouldSortByPriceInSearch() {
        AviaSouls aviaSouls = new AviaSouls();
        aviaSouls.add(new Ticket("SVO", "KZN", 6000, 800, 1100));
        aviaSouls.add(new Ticket("SVO", "KZN", 5000, 900, 1200));
        aviaSouls.add(new Ticket("SVO", "KZN", 7000, 830, 1230));

        Ticket[] result = aviaSouls.search("SVO", "KZN");
        assertEquals(5000, result[0].getPrice());
        assertEquals(6000, result[1].getPrice());
        assertEquals(7000, result[2].getPrice());
    }

    @Test
    public void shouldSortByFlightDurationUsingComparator() {
        AviaSouls aviaSouls = new AviaSouls();
        aviaSouls.add(new Ticket("SVO", "KZN", 5000, 800, 1100));
        aviaSouls.add(new Ticket("SVO", "KZN", 6000, 900, 1000));
        aviaSouls.add(new Ticket("SVO", "KZN", 7000, 830, 1230));

        TicketTimeComparator comparator = new TicketTimeComparator();
        Ticket[] result = aviaSouls.searchAndSortBy("SVO", "KZN", comparator);

        // Ожидаем, что билеты отсортируются по продолжительности полета
        int duration1 = result[0].getTimeTo() - result[0].getTimeFrom();
        int duration2 = result[1].getTimeTo() - result[1].getTimeFrom();
        int duration3 = result[2].getTimeTo() - result[2].getTimeFrom();

        assertTrue(duration1 <= duration2);
        assertTrue(duration2 <= duration3);
    }
}

