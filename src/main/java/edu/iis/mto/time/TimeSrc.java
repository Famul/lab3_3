package edu.iis.mto.time;

import org.joda.time.DateTime;

public final class TimeSrc implements TimeSource {

    DateTime date;

    public TimeSrc() {
        this.date = new DateTime();
    }

    @Override
    public DateTime currentDateTime() {
        return date;
    }

    @Override
    public DateTime addHours(int hours) {
        date.plusHours(hours);
        return date;
    }

}
