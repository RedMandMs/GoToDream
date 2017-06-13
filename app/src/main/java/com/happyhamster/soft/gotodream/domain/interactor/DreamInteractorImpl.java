package com.happyhamster.soft.gotodream.domain.interactor;

import com.happyhamster.soft.gotodream.domain.entity.Dream;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * Created by Vilgodskiy_Sergey on 07.06.2017.
 */
public class    DreamInteractorImpl extends Interactor<Dream> implements DreamInteractor {

    @Inject
    PlanInteractor planInteractor;

    public DreamInteractorImpl() {

    }

    @Override
    public Observable<Dream> get(Long id) {
        return null;
    }

    @Override
    public Observable<Dream> getAll() {
        return null;
    }

    @Override
    public Observable<Dream> persist(Dream dream) {
        return null;
    }

    @Override
    public Observable<Dream> update(Dream dream) {
        return null;
    }

    @Override
    public void remove(Long id) {

    }
}
