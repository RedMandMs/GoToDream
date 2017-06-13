package com.happyhamster.soft.gotodream.domain.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.happyhamster.soft.gotodream.domain.entity.Dream;

import java.util.List;

/**
 * Created by Vilgodskiy_Sergey on 13.06.2017.
 */
@Dao
public interface DreamDao {

    @Query("SELECT * FROM dream")
    List<Dream> getAll();

    @Query("SELECT * FROM dream WHERE id = :id LIMIT 1")
    Dream get(Long id);

    @Insert(onConflict = OnConflictStrategy.ABORT)
    void persist(Dream dream);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void update(Dream dream);

    @Delete
    void delete(Dream dream);
}
