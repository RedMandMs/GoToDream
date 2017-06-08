package com.happyhamster.soft.gotodream.domain.interactor;

import com.happyhamster.soft.gotodream.domain.entity.Dream;

import io.reactivex.Observable;

/**
 * Created by Vilgodskiy_Sergey on 07.06.2017.
 */
public interface DreamInteractor {

    Observable<Dream> get(Long id);

    Observable<Dream> getAll();

    Observable<Dream> persist(Dream dream);

    Observable<Dream> update(Dream dream);

    void remove(Long id);
}
