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

        Ticket[] expected = {
                new Ticket("SVO", "KZN", 5000, 900, 1200),
                new Ticket("SVO", "KZN", 6000, 800, 1100),
                new Ticket("SVO", "KZN", 7000, 830, 1230)
        };
        Ticket[] result = aviaSouls.search("SVO", "KZN");

        assertArrayEquals(expected, result);
    }

    @Test
    public void shouldSortByFlightDurationUsingComparator() {
        AviaSouls aviaSouls = new AviaSouls();
        aviaSouls.add(new Ticket("SVO", "KZN", 5000, 800, 1100));
        aviaSouls.add(new Ticket("SVO", "KZN", 6000, 900, 1000));
        aviaSouls.add(new Ticket("SVO", "KZN", 7000, 830, 1230));

        TicketTimeComparator comparator = new TicketTimeComparator();

        Ticket[] expected = {
                new Ticket("SVO", "KZN", 6000, 900, 1000),
                new Ticket("SVO", "KZN", 5000, 800, 1100),
                new Ticket("SVO", "KZN", 7000, 830, 1230)
        };
        Ticket[] result = aviaSouls.searchAndSortBy("SVO", "KZN", comparator);

        assertArrayEquals(expected, result);
    }
}
