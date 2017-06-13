package com.happyhamster.soft.gotodream.domain.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

import java.util.Date;
import java.util.List;

/**
 * Created by Vilgodskiy_Sergey on 07.06.2017.
 */
@Entity(tableName = "stage",
        foreignKeys = @ForeignKey(entity = Plan.class, parentColumns = "id", childColumns = "plan_id", onDelete = ForeignKey.CASCADE))
public class Stage {

    @PrimaryKey(autoGenerate = true)
    private Long id;

    @ColumnInfo(name = "start")
    private Date start;

    @ColumnInfo(name = "finish")
    private Date finish;

    @ColumnInfo(name = "name")
    private String name;

    @ColumnInfo(name = "complete")
    private boolean complete;

    @ColumnInfo(name = "plan_id")
    private Long planId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getFinish() {
        return finish;
    }

    public void setFinish(Date finish) {
        this.finish = finish;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }

    public Long getPlanId() {
        return planId;
    }

    public void setPlanId(Long planId) {
        this.planId = planId;
    }
}
