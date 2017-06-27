package com.happyhamster.soft.gotodream.di;

import com.happyhamster.soft.gotodream.domain.interactor.DreamInteractorImpl;
import com.happyhamster.soft.gotodream.view.StartActivity;

import dagger.Component;

/**
 * Created by Vilgodskiy_Sergey on 08.06.2017.
 */
@InteractorScope
@Component(dependencies = ApplicationComponent.class, modules = {DreamModule.class, PlanModule.class})
public interface InteractorComponent {

    void inject(DreamInteractorImpl dreamInteractor);

    void inject(StartActivity startActivity);
}
