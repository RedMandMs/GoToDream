package com.happyhamster.soft.gotodream.di;

import android.content.Context;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Vilgodskiy_Sergey on 07.06.2017.
 */
@Module
public class ApplicationModule {

    private final Context context;

    public ApplicationModule(Context context) {
        this.context = context;
    }

    @Provides
    @Named("application")
    @Singleton
    public Context provideApplicationContext() {
        return context;
    }
}
