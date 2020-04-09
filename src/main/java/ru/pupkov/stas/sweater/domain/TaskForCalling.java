package ru.pupkov.stas.sweater.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.crypto.Data;
import java.sql.Time;

@Entity
public class TaskForCalling {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer order;
    private Data data;
    private Time addingTime;
    private boolean completedTask;

    public TaskForCalling() {
    }

    public TaskForCalling(Data data, Time addingTime, boolean completedTask) {
        this.data = data;
        this.addingTime = addingTime;
        this.completedTask = completedTask;
    }



}
