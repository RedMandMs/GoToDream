package com.happyhamster.soft.gotodream.domain.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.happyhamster.soft.gotodream.domain.entity.Plan;

import java.util.List;

/**
 * Created by Vilgodskiy_Sergey on 13.06.2017.
 */
@Dao
public interface PlanDao {

    @Query("SELECT * FROM plan")
    List<Plan> getAll();

    @Query("SELECT * FROM plan WHERE id = :id LIMIT 1")
    Plan get(Long id);

    @Insert(onConflict = OnConflictStrategy.ABORT)
    void persist(Plan plan);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void update(Plan plan);

    @Delete
    void delete(Plan plan);
}
