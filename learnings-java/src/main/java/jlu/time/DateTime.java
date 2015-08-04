package jlu.time;

import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.TextStyle;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.time.temporal.TemporalField;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 *
 * @author jialu
 */
public class DateTime {

    public static void main(String[] args) {
        DayOfWeek dow = DayOfWeek.THURSDAY;
        Locale locale = Locale.getDefault();
        System.out.println(dow.getDisplayName(TextStyle.FULL, locale));

        Month month = Month.APRIL;
        System.out.println(month.getDisplayName(TextStyle.FULL, locale));

        //LocalDate
        LocalDate date = LocalDate.of(238, 1, 23);
        LocalDate nextOrSameSunday = date.with(TemporalAdjusters.nextOrSame(DayOfWeek.SUNDAY));

        System.out.printf("For the date of %s, the next or same Sunday is %s\n", date, nextOrSameSunday);

        Date dateNow = new Date();
        Instant instantNow = dateNow.toInstant();

        Date anotherNow = new Date(instantNow.toEpochMilli());

        LocalDate localDate1 = LocalDate.now();

        Instant instantFromLocalDate = localDate1.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant();

        System.out.printf("localDate1 %s, instantFromLocaDate %s\n", localDate1, instantFromLocalDate);

        LocalDateTime localDateTime1 = LocalDateTime.now();
        Instant instantFromLocalDateTime1 = localDateTime1.toInstant(ZoneOffset.UTC);

        System.out.printf("localDateTime1 %s, instantFromLocaDateTime %s\n", localDateTime1, instantFromLocalDateTime1);
        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        Instant instantFromZonedDateTime = zonedDateTime.toInstant();
        System.out.printf("ZonedDateTime1 %s, instantFromZonedDateTime %s\n", zonedDateTime, instantFromZonedDateTime);

        LocalDate y2k = LocalDate.of(2000, 1, 1);
        LocalDate localDateNow = LocalDate.now();

        Period py2k = Period.between(y2k, localDateNow);
        long cy2kweeks = ChronoUnit.WEEKS.between(y2k, localDateNow);
        System.out.printf("Y2K %s, Now %s. It has been %d years, %d months, %d days.\n", y2k, localDateNow, py2k.getYears(), py2k.getMonths(), py2k.getDays());
        System.out.printf("%d Weeks between %s and %s\n", cy2kweeks, y2k, localDateNow);

        //Legacy conversion
        Calendar calendarNow = Calendar.getInstance();
        ZonedDateTime zdtFromCalendarNow = ZonedDateTime.ofInstant(calendarNow.toInstant(), ZoneId.systemDefault());

        System.out.printf("CalendarNow %s, zdt %s\n", calendarNow, zdtFromCalendarNow);

        /*
         1. Which class would you use to store your birthday in years, months, days, seconds, and nanoseconds?
            local date time
        
         2. Given a random date, how would you find the date of the previous Thursday?
            with temporaladjuster.prev
         3. What is the difference between a ZoneId and a ZoneOffset?

         4. How would you convert an Instant to a ZonedDateTime? How would you convert a ZonedDateTime to an Instant?

         Exercises

         1. Write an example that, for a given year, reports the length of each month within that year.

         2. Write an example that, for a given month of the current year, lists all of the Mondays in that month.

         3. Write an example that tests whether a given date occurs on Friday the 13th.
         */
    }

}
