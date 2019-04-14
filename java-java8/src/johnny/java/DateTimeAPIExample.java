package johnny.java;

import java.time.*;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;

public class DateTimeAPIExample {
    public static void main(String args[]) {
        testLocalDateTime();
        testZonedDateTime();
        testChromoUnits();
        testPeriod();
        testDuration();
        testAdjusters();
        testBackwardCompatability();
    }

    // Local Date-Time API
    private static void testLocalDateTime() {
        // Get the current date and time
        LocalDateTime currentDT = LocalDateTime.now();
        System.out.println("Current DateTime: " + currentDT);

        LocalDate date1 = currentDT.toLocalDate();
        System.out.println("Current Date: " + date1);

        Month month = currentDT.getMonth();
        int day = currentDT.getDayOfMonth();
        int seconds = currentDT.getSecond();

        System.out.println("Month: " + month +", day: " + day +", seconds: " + seconds);

        // Update year and month
        LocalDateTime date2 = currentDT.withDayOfMonth(10).withYear(2012);
        System.out.println("New DateTime: " + date2);

        // Local Date
        LocalDate date = LocalDate.of(2014, Month.DECEMBER, 12);
        System.out.println("New Local Date: " + date);

        // 22 hour 15 minutes
        LocalTime time = LocalTime.of(22, 15);
        System.out.println("New Local Time: " + time);

        // Parse a string
        LocalTime timeParse = LocalTime.parse("20:15:30");
        System.out.println("Time from String: " + timeParse);
    }

    // Zoned Date-Time API
    public static void testZonedDateTime() {
        // Get the current date and time
        ZonedDateTime zdt = ZonedDateTime.parse("2007-12-03T10:15:30+05:30[Asia/Shanghai]");
        System.out.println("Zone DateTime: " + zdt);
        System.out.println("Zone Id: " + zdt.getZone());

        ZoneId id = ZoneId.of("Europe/Paris");
        System.out.println("ZoneId: " + id);

        ZoneId currentZone = ZoneId.systemDefault();
        System.out.println("CurrentZone: " + currentZone);
    }

    // Chrono Units Enum
    public static void testChromoUnits() {
        // Get the current date
        LocalDate today = LocalDate.now();
        System.out.println("Current date: " + today);

        // Add 1 week to the current date
        LocalDate nextWeek = today.plus(1, ChronoUnit.WEEKS);
        System.out.println("Next week: " + nextWeek);

        // Add 1 month to the current date
        LocalDate nextMonth = today.plus(1, ChronoUnit.MONTHS);
        System.out.println("Next month: " + nextMonth);

        // Add 1 year to the current date
        LocalDate nextYear = today.plus(1, ChronoUnit.YEARS);
        System.out.println("Next year: " + nextYear);

        // Add 10 years to the current date
        LocalDate nextDecade = today.plus(1, ChronoUnit.DECADES);
        System.out.println("Date after ten year: " + nextDecade);
    }

    // Period
    public static void testPeriod() {
        //Get the current date
        LocalDate date1 = LocalDate.now();
        System.out.println("Current date: " + date1);

        //add 1 month to the current date
        LocalDate date2 = date1.plus(1, ChronoUnit.MONTHS);
        System.out.println("Next month: " + date2);

        Period period = Period.between(date2, date1);
        System.out.println("Period: " + period);
    }

    // Duration
    public static void testDuration() {
        LocalTime time1 = LocalTime.now();
        Duration twoHours = Duration.ofHours(2);

        LocalTime time2 = time1.plus(twoHours);
        Duration duration = Duration.between(time1, time2);

        System.out.println("Duration: " + duration);
    }

    // Temporal Adjusters
    public static void testAdjusters() {
        //Get the current date
        LocalDate localDate = LocalDate.now();
        System.out.println("Current date: " + localDate);

        //get the next tuesday
        LocalDate nextTuesday = localDate.with(TemporalAdjusters.next(DayOfWeek.TUESDAY));
        System.out.println("Next Tuesday on : " + nextTuesday);

        //get the second saturday of next month
        LocalDate firstInYear = LocalDate.of(localDate.getYear(), localDate.getMonth(), 1);
        LocalDate secondSaturday = firstInYear.with(TemporalAdjusters.nextOrSame(
                DayOfWeek.SATURDAY)).with(TemporalAdjusters.next(DayOfWeek.SATURDAY));
        System.out.println("Second Saturday on : " + secondSaturday);
    }

    // Backward Compatibility with ofInstant
    public static void testBackwardCompatability() {
        //Get the current date
        Date currentDate = new Date();
        System.out.println("Current date: " + currentDate);

        //Get the instant of current date in terms of milliseconds
        Instant now = currentDate.toInstant();
        ZoneId currentZone = ZoneId.systemDefault();

        LocalDateTime localDateTime = LocalDateTime.ofInstant(now, currentZone);
        System.out.println("Local date: " + localDateTime);

        ZonedDateTime zonedDateTime = ZonedDateTime.ofInstant(now, currentZone);
        System.out.println("Zoned date: " + zonedDateTime);
    }
}
