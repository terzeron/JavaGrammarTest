package stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Product {
    long price;
    String name;

    public Product(long price, String name) {
        this.price = price;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public long getPrice() {
        return price;
    }
}

public class ReductionTest {
    public static void main(String[] args) {
        List<Product> productList = Arrays.asList(new Product(23, "potatoes"), new Product(14, "orange"), new Product(13
                , "lemon"), new Product(23, "bread"), new Product(13, "sugar"));
        List<String> collectorCollection = productList.stream().map(Product::getName).collect(Collectors.toList());
        collectorCollection.stream().forEach(System.out::println);
        String listToString = productList.stream().map(Product::getName).collect(Collectors.joining(", ", "[", "]"));
        System.out.println(listToString);
    }
}


