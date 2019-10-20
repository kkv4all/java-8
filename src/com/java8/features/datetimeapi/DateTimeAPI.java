package datetimeapi;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;
import java.util.function.BiConsumer;

public class DateTimeAPI {
	public static void main(String[] args) {
		DateTimeAPI api = new DateTimeAPI();
		PrintLine print = x -> System.out.println(String.format("===== %s =====",x));
		
		print.print("Local DateTime");
		api.testLocalDateTime();
		print.print("Zoned DateTime");
		api.testZonedDateTime();
		print.print("Chrono Unit");
		api.testChronoUnit();
		print.print("Periods");
		api.testPeroids();
		print.print("Duration");
		api.testDuration();
		print.print("Temporal Adjuster");
		api.testAdjuster();
		print.print("Backward Compatibility");
		api.testBackwardCompatibility();
	}

	private void testBackwardCompatibility() {
		Date currentDate = new Date();
		System.out.println("Current Date: "+currentDate);
		
		Instant now = currentDate.toInstant();
		ZoneId currentZone = ZoneId.systemDefault();
		
		LocalDateTime localDateTime = LocalDateTime.ofInstant(now, currentZone);
		System.out.println("Local time:"+localDateTime);

		ZonedDateTime zonedDateTime = ZonedDateTime.ofInstant(now, currentZone);
		System.out.println("Zoned time:"+zonedDateTime);
	}

	private void testAdjuster() {
		LocalDate today = LocalDate.now();
		System.out.println("Current Date: "+ today);
		
		LocalDate nextTuesday = today.with(TemporalAdjusters.next(DayOfWeek.TUESDAY));
		System.out.println("Next Tuesday: "+nextTuesday);
		
		LocalDate firstOfThisMonth = LocalDate.of(today.getYear(), today.getMonth(), 1);
		LocalDate secondSaturdayOfMonth = firstOfThisMonth.with(TemporalAdjusters.nextOrSame(DayOfWeek.SATURDAY)).with(TemporalAdjusters.next(DayOfWeek.SATURDAY));
		System.out.println("Second Saturday of this month: "+secondSaturdayOfMonth);
	}

	private void testDuration() {
		LocalTime now = LocalTime.now();
		System.out.println("Current Time: "+ now);
		
		LocalTime nextHour = now.plus(1,ChronoUnit.HOURS);
		System.out.println("Next Week: "+nextHour);
		
		Duration duration = Duration.between(nextHour, now);
		System.out.println("Duration: "+duration);
		
	}

	private void testPeroids() {
		LocalDate today = LocalDate.now();
		System.out.println("Current Date: "+ today);
		
		LocalDate nextWeek = today.plus(1,ChronoUnit.WEEKS);
		System.out.println("Next Week: "+nextWeek);

		Period period = Period.between(nextWeek, today);
		System.out.println("Period: "+period.getDays());
	}

	private void testChronoUnit() {
		LocalDate today = LocalDate.now();
		System.out.println("Current Date: "+ today);
		
		LocalDate nextWeek = today.plus(1,ChronoUnit.WEEKS);
		System.out.println("Next Week: "+nextWeek);
		
		LocalDate nextMonth = today.plus(1,ChronoUnit.MONTHS);
		System.out.println("Next Month: "+nextMonth);
		
		LocalDate nextYear = today.plus(1,ChronoUnit.YEARS);
		System.out.println("Next Year: "+nextYear);
	}

	private void testZonedDateTime() {
		ZonedDateTime zonedDateTime = ZonedDateTime.parse("2007-12-03T10:15:30+05:30[Asia/Calcutta]");
		System.out.println("Zoned DateTime: "+ zonedDateTime);
		
		ZoneId zoneId = zonedDateTime.getZone();
		System.out.println("Zone Id: "+zoneId);
		
		ZoneId id = ZoneId.of("Europe/Paris");
		System.out.println("Paris zone: "+id);
		
		ZoneId currentZone = ZoneId.systemDefault();
		System.out.println("Current Zone: "+ currentZone);
	}

	private void testLocalDateTime() {
		LocalDateTime currentTime = LocalDateTime.now();
		System.out.println("Current DateTime: " + currentTime);
		
		LocalDate localDate = currentTime.toLocalDate();
		System.out.println("Current Date(Local): "+ localDate);
		
		Month month = currentTime.getMonth();
		DayOfWeek dayOfWeek = currentTime.getDayOfWeek();
		int day = currentTime.getDayOfMonth();
		System.out.println("Month: "+month + ", Day of Week: "+dayOfWeek + ", Day of Month: "+day);
		
		LocalDateTime dateWithChangedYearAndMonth = currentTime.withMonth(1).withYear(2012);
		System.out.println("Current Date with Modified year as 2012 and month as January: "+ dateWithChangedYearAndMonth);
		
		LocalDate dateWithValueSet = LocalDate.of(2014, Month.JANUARY, 1);
		System.out.println("Set Date : " + dateWithValueSet);
	}
	
	interface PrintLine {
		void print(String s);
	}
}
