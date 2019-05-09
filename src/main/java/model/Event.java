package model;

import java.util.Date;

public class Event {

    private Long id;

    private Date when;

    public Event () {
    }

    public Event (final Long id, final Date when) {
        this.id = id;
        this.when = when;
    }

    public Long getId () {
        return id;
    }

    public void setId (final Long id) {
        this.id = id;
    }

    public Date getWhen () {
        return when;
    }

    public void setWhen (final Date when) {
        this.when = when;
    }
}
