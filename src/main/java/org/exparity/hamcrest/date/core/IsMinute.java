package org.exparity.hamcrest.date.core;

import org.hamcrest.Description;

/**
 * A matcher that tests that the examined date is on the specified minute
 *
 * @author Stewart Bissett
 */
public class IsMinute<T, Z> extends ZonedTemporalMatcher<T, Z> {

	private final TemporalFieldWrapper<T, Z> expected;
	private final TemporalFieldAdapter<T, Z> accessor;
	private final Z zone;

	public IsMinute(final TemporalFieldWrapper<T, Z> expected, final TemporalFieldAdapter<T, Z> accessor, final Z zone) {
		this.expected = expected;
		this.accessor = accessor;
		this.zone = zone;
	}

	@Override
	protected boolean matchesSafely(final T actual, final Description mismatchDescription) {
		if (!this.expected.isSame(actual)) {
			mismatchDescription.appendText("the date has the minute " + accessor.asTemporalField(actual, zone));
			return false;
		} else {
			return true;
		}
	}

	@Override
	public void describeTo(final Description description) {
		description.appendText("the date has the minute " + expected.unwrap());
	}

	@Override
	public ZonedTemporalMatcher<T, Z> atZone(Z zone) {
		return new IsMinute<>(expected.withZone(zone), accessor, zone);
	}

}