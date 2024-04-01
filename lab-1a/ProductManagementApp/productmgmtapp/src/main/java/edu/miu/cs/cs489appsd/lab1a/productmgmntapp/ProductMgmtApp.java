package edu.miu.cs.cs489appsd.lab1a.productmgmntapp;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import edu.miu.cs.cs489appsd.lab1a.productmgmntapp.model.LocalDateTimeAdapter;
import edu.miu.cs.cs489appsd.lab1a.productmgmntapp.model.Product;
import edu.miu.cs.cs489appsd.lab1a.productmgmntapp.model.Products;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;
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
        String jsonRepresentation = convertToJson(sortedProduct);
        decoratedPrint(jsonRepresentation, "Print in JSON Format");

//        XML
        String xmlRepresentation = convertToXML(new Products(sortedProduct));
        decoratedPrint(xmlRepresentation, "Print in XML Format");

//        CSV
        String objectsCommaSeparated = convertToCSV(products);
        decoratedPrint(objectsCommaSeparated, "Print in CSV Format");
    }


    private static String convertToJson(List<Product> products) {
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(LocalDate.class, new LocalDateTimeAdapter())
                .setPrettyPrinting()
                .create();
        String jsonRepresentation = gson.toJson(products);
        return jsonRepresentation;
    }

    private static String convertToXML(Products products) {
        try {
            JAXBContext context = JAXBContext.newInstance(Products.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            StringWriter writer = new StringWriter();
            marshaller.marshal(products, writer);
            String result = writer.toString();
            return result;
        } catch (JAXBException e) {
            System.out.println(e);
        }
        return "";

    }

    private static String convertToCSV(List<Product> products) {
        String objectsCommaSeparated = products.stream()
                .map(product -> product.toCsv())
                .collect(Collectors.joining("\n"));
        return objectsCommaSeparated;
    }

    private static void decoratedPrint(String result, String message) {
        System.out.println(message);
        System.out.println();
        System.out.println(result);
        System.out.println("----------------------");
        System.out.println();
    }
}