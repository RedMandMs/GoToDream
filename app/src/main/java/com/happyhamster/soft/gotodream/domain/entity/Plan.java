package com.happyhamster.soft.gotodream.domain.entity;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

/**
 * Created by Vilgodskiy_Sergey on 07.06.2017.
 */

public class Plan extends RealmObject {

    private boolean complete;

    private RealmList<Stage> stages;

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }

    public RealmList<Stage> getStages() {
        return stages;
    }

    public void setStages(RealmList<Stage> stages) {
        this.stages = stages;
    }
}
