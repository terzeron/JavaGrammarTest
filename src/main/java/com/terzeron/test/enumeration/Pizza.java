package com.terzeron.test.enumeration;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.List;
import java.util.stream.Collectors;

public class Pizza {

    private PizzaStatus status;
    EnumMap<PizzaStatus, Pizza> map;
    private static EnumSet<PizzaStatus> undeliveredPizzaStatuses = EnumSet.of(PizzaStatus.ORDERED, PizzaStatus.READY);

    public PizzaStatus getStatus() {
        return status;
    }

    public void setStatus(PizzaStatus status) {
        this.status = status;
    }

    @JsonFormat(shape = JsonFormat.Shape.OBJECT)
    public enum PizzaStatus {
        ORDERED(5) {
            @Override
            public boolean isOrdered() {
                return true;
            }
        },
        READY(2) {
            @Override
            public boolean isReady() {
                return true;
            }
        },
        DELIVERED(0) {
            @Override
            public boolean isDelivered() {
                return true;
            }
        };

        private int timeToDelivery;

        public boolean isOrdered() {
            return false;
        }

        public boolean isReady() {
            return false;
        }

        public boolean isDelivered() {
            return false;
        }

        @JsonProperty("timeToDelivery")
        public int getTimeToDelivery() {
            return timeToDelivery;
        }

        PizzaStatus(int timeToDelivery) {
            this.timeToDelivery = timeToDelivery;
        }
    }

    public boolean isDeliverable() {
        return this.status.isReady();
    }

    public void printTimeToDeliver() {
        System.out.println("Time to delivery is " +
                this.getStatus().getTimeToDelivery());
    }

    public static List<Pizza> getAllUndeliveredPizzas(List<Pizza> input) {
        return input.stream().filter(
                (s) -> undeliveredPizzaStatuses.contains(s.getStatus()))
                .collect(Collectors.toList());

    }

    public void deliver() {
        if (isDeliverable()) {
            PizzaDeliverySystemConfiguration.getInstance().getDeliveryStrategy().deliver(this);
            this.setStatus(PizzaStatus.DELIVERED);
        }
    }

    public static EnumMap<Pizza.PizzaStatus, List<Pizza>> groupPizzaByStatus(List<Pizza> pizzaList) {
        // 상태별 피자목록 맵
        EnumMap<PizzaStatus, List<Pizza>> pizzaByStatus = new EnumMap<PizzaStatus, List<Pizza>>(PizzaStatus.class);

        for (Pizza pizza : pizzaList) {
            PizzaStatus status = pizza.getStatus();
            if (pizzaByStatus.containsKey(status)) {
                pizzaByStatus.get(status).add(pizza);
            } else {
                List<Pizza> newPizzaList = new ArrayList<Pizza>();
                newPizzaList.add(pizza);
                pizzaByStatus.put(status, newPizzaList);
            }
        }
        return pizzaByStatus;
    }

}

