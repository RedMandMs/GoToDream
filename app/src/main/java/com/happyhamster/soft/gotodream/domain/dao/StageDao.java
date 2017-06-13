package com.happyhamster.soft.gotodream.domain.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.happyhamster.soft.gotodream.domain.entity.Stage;

import java.util.List;

/**
 * Created by Vilgodskiy_Sergey on 13.06.2017.
 */
@Dao
public interface StageDao {

    @Query("SELECT * FROM stage")
    List<Stage> getAll();

    @Query("SELECT * FROM stage WHERE id = :id LIMIT 1")
    Stage get(Long id);

    @Insert(onConflict = OnConflictStrategy.ABORT)
    void persist(Stage stage);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void update(Stage stage);

    @Insert(onConflict = OnConflictStrategy.ABORT)
    void persist(List<Stage> stage);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void update(List<Stage> stage);

    @Delete
    void delete(Stage stage);
}
