package org.exparity.hamcrest.date;

import static org.exparity.hamcrest.date.DateMatchers.sameMillisecondOfSecond;
import static org.exparity.hamcrest.date.testutils.DateMatcherTestUtils.addDateField;
import static org.exparity.hamcrest.date.testutils.Dates.JAN_1ST_2012_11_AM;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsNot.not;
import java.util.Calendar;
import java.util.Date;
import org.junit.Test;

/**
 * Unit Tests for the {@link IsSameSecondOfMinute} class
 * 
 * @author Stewart Bissett
 */
public class IsSameMillsecondTest {

	@Test
	public void canCompareTheSameMillisecond() {
		Date date = new Date(), other = new Date(date.getTime());
		assertThat(other, sameMillisecondOfSecond(date));
	}

	@Test
	public void canDetectDifferentSecond() {
		Date date = new Date(), other = addDateField(date, Calendar.MILLISECOND, 1);
		assertThat(other, not(sameMillisecondOfSecond(date)));
	}

	@Test
	public void canCompareTheSameSecondInt() {
		assertThat(JAN_1ST_2012_11_AM, sameMillisecondOfSecond(0));
	}

	@Test
	public void canDetectDifferentSecondInt() {
		assertThat(JAN_1ST_2012_11_AM, not(sameMillisecondOfSecond(1)));
	}

}