package com.happyhamster.soft.gotodream.domain.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by Vilgodskiy_Sergey on 07.06.2017.
 */
@Entity(tableName = "task",
        foreignKeys = @ForeignKey(entity = Stage.class, parentColumns = "id", childColumns = "stage_id", onDelete = ForeignKey.CASCADE))
public class Task {

    @PrimaryKey(autoGenerate = true)
    private Long id;

    @ColumnInfo(name = "description")
    private String description;

    @ColumnInfo(name = "complete")
    private boolean complete;

    @ColumnInfo(name = "stage_id")
    private Long stageId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }

    public Long getStageId() {
        return stageId;
    }

    public void setStageId(Long stageId) {
        this.stageId = stageId;
    }
}
