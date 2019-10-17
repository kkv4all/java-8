package datetimeapi;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;

public class DateTimeAPI {
	public static void main(String[] args) {
		DateTimeAPI api = new DateTimeAPI();
		
		api.testLocalDateTime();
		api.testZonedDateTime();
		api.testChronoUnit();
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
		System.out.println("Cuurent Date(Local): "+ localDate);
		
		Month month = currentTime.getMonth();
		DayOfWeek dayOfWeek = currentTime.getDayOfWeek();
		int day = currentTime.getDayOfMonth();
		System.out.println("Month: "+month + ", Day of Week: "+dayOfWeek + ", Day of Month: "+day);
		
		LocalDateTime dateWithChangedYearAndMonth = currentTime.withMonth(1).withYear(2012);
		System.out.println("Current Date with Modified year as 2012 and month as January: "+ dateWithChangedYearAndMonth);
		
		LocalDate dateWithValueSet = LocalDate.of(2014, Month.JANUARY, 1);
		System.out.println("Set Date : " + dateWithValueSet);
	}
}
