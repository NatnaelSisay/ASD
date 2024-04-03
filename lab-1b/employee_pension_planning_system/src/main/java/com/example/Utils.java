package com.example;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import com.example.models.LocalDateTimeAdapter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Utils {

  private static DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ISO_LOCAL_DATE;
  private static final GsonBuilder builder = new GsonBuilder();

  private static final Gson gson = builder
      .setPrettyPrinting()
      .registerTypeAdapter(LocalDate.class, new LocalDateTimeAdapter())
      .create();

  public static LocalDate getCorspondingLocalDate(String date) {
    date = date.trim();
    return LocalDate.parse(date, dateTimeFormatter);
  }

  public static boolean willQualifyForTheYearNextMonth(int expectedYear, LocalDate givenDate) {
    LocalDate nextMonth = givenDate.plusMonths(1);
    int yearDiff = LocalDate.now().getYear() - givenDate.getYear();
    int nextMonthYearDiff = LocalDate.now().getYear() - nextMonth.getYear();

    return yearDiff >= expectedYear || (yearDiff != nextMonthYearDiff && nextMonthYearDiff >= expectedYear);

  }

  public static String getJsonFromList(List<?> values) {
    return gson.toJson(values);
  }
}
