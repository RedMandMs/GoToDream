package com.happyhamster.soft.gotodream.di;

import com.happyhamster.soft.gotodream.domain.interactor.DreamInteractor;
import com.happyhamster.soft.gotodream.domain.interactor.DreamInteractorImpl;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Vilgodskiy_Sergey on 08.06.2017.
 */
@Module
public class DreamModule {

    @Provides
    @InteractorScope
    DreamInteractor provideDreamInteractor() {
        return new DreamInteractorImpl();
    }
}
