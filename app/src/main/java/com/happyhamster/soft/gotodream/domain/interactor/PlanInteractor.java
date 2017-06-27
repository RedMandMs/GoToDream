package com.happyhamster.soft.gotodream.domain.interactor;

import com.happyhamster.soft.gotodream.domain.entity.Plan;

import io.reactivex.Observable;

/**
 * Created by Vilgodskiy_Sergey on 08.06.2017.
 */

public interface PlanInteractor {

    Observable<Plan> persist(Plan plan);

    Observable<Plan> update(Plan plan);
}
