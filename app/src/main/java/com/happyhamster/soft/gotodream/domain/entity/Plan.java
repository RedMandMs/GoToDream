package com.happyhamster.soft.gotodream.domain.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by Vilgodskiy_Sergey on 07.06.2017.
 */
@Entity(tableName = "plan")
public class Plan {

    @PrimaryKey(autoGenerate = true)
    private Long id;

    @ColumnInfo(name = "complete")
    private boolean complete;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }
}
