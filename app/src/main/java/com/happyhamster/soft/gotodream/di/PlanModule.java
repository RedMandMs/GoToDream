package com.happyhamster.soft.gotodream.di;

import com.happyhamster.soft.gotodream.domain.interactor.PlanInteractor;
import com.happyhamster.soft.gotodream.domain.interactor.PlanInteractorImpl;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Vilgodskiy_Sergey on 08.06.2017.
 */
@Module
public class PlanModule {

    @Provides
    @InteractorScope
    PlanInteractor providePlanInteractor() {
        return new PlanInteractorImpl();
    }
}
