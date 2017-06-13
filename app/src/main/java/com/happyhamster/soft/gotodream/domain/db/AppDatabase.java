package com.happyhamster.soft.gotodream.domain.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;

import com.happyhamster.soft.gotodream.domain.dao.DreamDao;
import com.happyhamster.soft.gotodream.domain.dao.PlanDao;
import com.happyhamster.soft.gotodream.domain.dao.StageDao;
import com.happyhamster.soft.gotodream.domain.dao.TaskDao;
import com.happyhamster.soft.gotodream.domain.entity.Dream;
import com.happyhamster.soft.gotodream.domain.entity.Plan;
import com.happyhamster.soft.gotodream.domain.entity.Stage;
import com.happyhamster.soft.gotodream.domain.entity.Task;
import com.happyhamster.soft.gotodream.domain.util.DBTypeConverter;

/**
 * Created by Vilgodskiy_Sergey on 13.06.2017.
 */
@Database(entities = {Dream.class, Plan.class, Stage.class, Task.class}, version = 1)
@TypeConverters({DBTypeConverter.class})
public abstract class AppDatabase extends RoomDatabase {

    public abstract DreamDao dreamDao();

    public abstract PlanDao planDao();

    public abstract StageDao stageDao();

    public abstract TaskDao taskDao();
}
