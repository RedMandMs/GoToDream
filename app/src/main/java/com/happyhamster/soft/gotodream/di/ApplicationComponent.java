package com.happyhamster.soft.gotodream.di;

import android.content.Context;

import com.happyhamster.soft.gotodream.GoToDream;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Vilgodskiy_Sergey on 08.06.2017.
 */
@Singleton
@Component(modules = {ApplicationModule.class})
public interface ApplicationComponent {

    void inject(GoToDream goToDream);

    @Named("application")
    Context getContext();
}
