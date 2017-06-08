package com.happyhamster.soft.gotodream.domain.interactor;

import com.happyhamster.soft.gotodream.domain.entity.Plan;

import io.reactivex.Observable;

/**
 * Created by Vilgodskiy_Sergey on 07.06.2017.
 */
public class PlanInteractorImpl implements PlanInteractor {

    @Override
    public Observable<Plan> persist(Plan plan) {
        return null;
    }

    @Override
    public Observable<Plan> update(Plan plan) {
        return null;
    }

    @Override
    public void remove(Long id) {

    }
}
