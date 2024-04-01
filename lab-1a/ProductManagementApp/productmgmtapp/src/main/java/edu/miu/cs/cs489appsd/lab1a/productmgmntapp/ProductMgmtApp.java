package edu.miu.cs.cs489appsd.lab1a.productmgmntapp;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.thoughtworks.xstream.XStream;
import edu.miu.cs.cs489appsd.lab1a.productmgmntapp.model.LocalDateTimeAdapter;
import edu.miu.cs.cs489appsd.lab1a.productmgmntapp.model.Product;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ProductMgmtApp {
    public static void main(String[] args) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        List<Product> products = List.of(
                new Product(3128874119L, "Banana", LocalDate.parse("2023-01-24", dateTimeFormatter), 124, BigDecimal.valueOf(0.55)),
                new Product(2927458265L, "Apple", LocalDate.parse("2022-12-09", dateTimeFormatter), 18, BigDecimal.valueOf(1.09)),
                new Product(9189927460L, "Carrot", LocalDate.parse("2023-03-31", dateTimeFormatter), 89, BigDecimal.valueOf(2.99))
        );

        printProducts(products);
    }

    private static void printProducts(List<Product> products) {
        List<Product> sortedProduct = products
                .stream()
                .sorted(Comparator.comparing(Product::getName))
                .collect(Collectors.toList());


//        JSON
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(LocalDate.class, new LocalDateTimeAdapter())
//                .setPrettyPrinting()
                .create();
        String jsonRepresentation = gson.toJson(sortedProduct);
        decoratedPrint(jsonRepresentation, "Print in JSON Format");


//        XML
        XStream xstream = new XStream();
        xstream.alias("product", Product.class);
        StringBuilder ps = new StringBuilder();
        for (Product p : products) {
            ps.append(xstream.toXML(p));

        }
        String val = ps.toString();
        val = "<products>\n" + val;
        val = val + "\n</products>";
        decoratedPrint(val, "Print in XML Format");


//        CSV
        String objectsCommaSeparated = products.stream()
                .map(product -> product.toCsv())
                .collect(Collectors.joining("\n"));
        decoratedPrint(objectsCommaSeparated, "Print in CSV Format");

    }


    private static void decoratedPrint(String result, String message) {
        System.out.println(message);
        System.out.println();
        System.out.println(result);
        System.out.println("----------------------");
        System.out.println();
    }
}

class Person {
    private String firstname;
    private String lastname;

    public Person(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }
}