package org.exparity.hamcrest.date.core;

import org.hamcrest.Description;

/**
 * A matcher that tests that the examined date is on the same month of the year
 * as the reference date
 *
 * @author Stewart Bissett
 */
public class IsMonth<T, Z> extends ZonedTemporalMatcher<T, Z> {

	private final TemporalFieldWrapper<T, Z> expected;
	private final TemporalFieldAdapter<T, Z> accessor;
	private final Z zone;

  	public IsMonth(final TemporalFieldWrapper<T, Z> expected, final TemporalFieldAdapter<T, Z> accessor, final Z zone) {
		this.expected = expected;
		this.accessor = accessor;
		this.zone = zone;
	}

	@Override
	protected boolean matchesSafely(final T actual, final Description mismatchDescription) {
		if (!this.expected.isSame(actual)) {
			mismatchDescription.appendText("the date has the month " + accessor.asTemporalField(actual, zone));
			return false;
		} else {
			return true;
		}
	}

	@Override
	public void describeTo(final Description description) {
		description.appendText("the date has the month " + expected.unwrap());
	}

	@Override
	public ZonedTemporalMatcher<T, Z> atZone(Z zone) {
		return new IsMonth<>(expected.withZone(zone), accessor, zone);
	}

}