package com.happyhamster.soft.gotodream.domain.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.happyhamster.soft.gotodream.domain.entity.Task;

import java.util.List;

/**
 * Created by Vilgodskiy_Sergey on 13.06.2017.
 */
@Dao
public interface TaskDao {

    @Query("SELECT * FROM task")
    List<Task> getAll();

    @Query("SELECT * FROM task WHERE id = :id LIMIT 1")
    Task get(Long id);

    @Insert(onConflict = OnConflictStrategy.ABORT)
    void persist(Task task);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void update(Task task);

    @Insert(onConflict = OnConflictStrategy.ABORT)
    void persist(List<Task> task);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void update(List<Task> task);

    @Delete
    void delete(Task task);
}
