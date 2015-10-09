
package org.exparity.hamcrest.date.core;

import static org.exparity.hamcrest.date.testutils.Dates.*;
import static org.junit.Assert.assertThat;

import org.exparity.hamcrest.date.DateMatchers;
import org.exparity.hamcrest.date.LocalDateMatchers;
import org.exparity.hamcrest.date.LocalDateTimeMatchers;
import org.exparity.hamcrest.date.ZonedDateTimeMatchers;
import org.junit.Test;

/**
 * Unit test for {@link IsYear}
 *
 * @author Stewart Bissett
 */
public class isYearTest {

	// Date Matchers
	@Test
	public void isDateYear() {
		assertThat(AUG_04_2016_AS_DATE, DateMatchers.isYear(2016));
	}

	@Test(expected = AssertionError.class)
	public void isDateNotYear() {
		assertThat(AUG_04_2015_NOON_AS_DATE, DateMatchers.isYear(2016));
	}

	// LocalDate Matchers
	@Test
	public void isLocalDateYear() {
		assertThat(AUG_04_2016, LocalDateMatchers.isYear(2016));
	}

	@Test(expected = AssertionError.class)
	public void isLocalDateNotYear() {
		assertThat(AUG_04_2015, LocalDateMatchers.isYear(2016));
	}

	// LocalDateTime Matchers
	@Test
	public void isLocalDateTimeYear() {
		assertThat(AUG_04_2016_NOON, LocalDateTimeMatchers.isYear(2016));
	}

	@Test(expected = AssertionError.class)
	public void isLocalDateTimeNotYear() {
		assertThat(AUG_04_2015_NOON, LocalDateTimeMatchers.isYear(2016));
	}

	// ZonedDateTime Matchers
	@Test
	public void isZonedDateTimeYear() {
		assertThat(AUG_04_2016_NOON_UTC, ZonedDateTimeMatchers.isYear(2016));
	}

	@Test(expected = AssertionError.class)
	public void isZonedDateTimeNotYear() {
		assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.isYear(2016));
	}

}
