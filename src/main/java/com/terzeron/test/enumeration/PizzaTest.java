package com.terzeron.test.enumeration;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PizzaTest {
    @Test
    public void givenPizzaOrder_whenReady_thenDeliverable() {
        Pizza testPz = new Pizza();
        testPz.setStatus(Pizza.PizzaStatus.READY);
        assertTrue(testPz.isDeliverable());
    }

    @Test
    public void givenPizzaOrders_whenRetrievingUndeliveredPizzas_thenCorrectlyRetrieved() {
        List<Pizza> pzList = new ArrayList<>();
        Pizza pz1 = new Pizza();
        pz1.setStatus(Pizza.PizzaStatus.DELIVERED);

        Pizza pz2 = new Pizza();
        pz2.setStatus(Pizza.PizzaStatus.ORDERED);

        Pizza pz3 = new Pizza();
        pz3.setStatus(Pizza.PizzaStatus.ORDERED);

        Pizza pz4 = new Pizza();
        pz4.setStatus(Pizza.PizzaStatus.READY);

        pzList.add(pz1);
        pzList.add(pz2);
        pzList.add(pz3);
        pzList.add(pz4);

        List<Pizza> undeliveredPizzas = Pizza.getAllUndeliveredPizzas(pzList);
        assertTrue(undeliveredPizzas.size() == 3);
    }

    @Test
    public void givenPizzaOrders_whenGroupByStatusCalled_thenCorrectlyGrouped() {
        List<Pizza> pzList = new ArrayList<>();
        Pizza pz1 = new Pizza();
        pz1.setStatus(Pizza.PizzaStatus.DELIVERED);

        Pizza pz2 = new Pizza();
        pz2.setStatus(Pizza.PizzaStatus.ORDERED);

        Pizza pz3 = new Pizza();
        pz3.setStatus(Pizza.PizzaStatus.ORDERED);

        Pizza pz4 = new Pizza();
        pz4.setStatus(Pizza.PizzaStatus.READY);

        pzList.add(pz1);
        pzList.add(pz2);
        pzList.add(pz3);
        pzList.add(pz4);

        EnumMap<Pizza.PizzaStatus, List<Pizza>> map = Pizza.groupPizzaByStatus(pzList);
        assertTrue(map.get(Pizza.PizzaStatus.DELIVERED).size() == 1);
        assertTrue(map.get(Pizza.PizzaStatus.ORDERED).size() == 2);
        assertTrue(map.get(Pizza.PizzaStatus.READY).size() == 1);
    }

    @Test
    public void givenPizzaOrder_whenDelivered_thenPizzaGetsDeliveredAndStatusChanged() {
        Pizza pz = new Pizza();
        pz.setStatus(Pizza.PizzaStatus.READY);
        pz.deliver();
        assertTrue(pz.getStatus() == Pizza.PizzaStatus.DELIVERED);
    }

    @Test
    public void whenSerializingUsingJsonFormat_thenCorrect() throws JsonProcessingException {
        Pizza pz = new Pizza();
        pz.setStatus(Pizza.PizzaStatus.READY);
        String result = new ObjectMapper().writeValueAsString(pz);
        assertEquals(result, "{\"status\":{\"ready\":true,\"delivered\":false,\"ordered\":false,\"timeToDelivery\":2},\"deliverable\":true}");
    }
}