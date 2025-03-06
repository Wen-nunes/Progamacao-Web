package com.example.springjpa;

import jakarta.persistence.*;

import java.sql.Time;
import java.util.Date;

@Entity
@Table(name = "Events")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "event_date")
    @Temporal(TemporalType.DATE)
    private Date date;

    @Column(name = "event_time")
    @Temporal(TemporalType.TIME)
    private Date eventTime;

    @Column(name = "event_time_stamp")
    @Temporal(TemporalType.TIMESTAMP)
    private Date eventTimeStamp;
}
