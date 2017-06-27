package com.happyhamster.soft.gotodream;

import android.app.Application;

import com.happyhamster.soft.gotodream.di.ApplicationComponent;
import com.happyhamster.soft.gotodream.di.ApplicationModule;
import com.happyhamster.soft.gotodream.di.DaggerApplicationComponent;
import com.happyhamster.soft.gotodream.di.DaggerInteractorComponent;
import com.happyhamster.soft.gotodream.di.InteractorComponent;
import com.happyhamster.soft.gotodream.di.DreamModule;
import com.happyhamster.soft.gotodream.di.PlanModule;

import io.realm.Realm;

/**
 * Created by Vilgodskiy_Sergey on 08.06.2017.
 */

public class GoToDream extends Application {

    private GoToDream instance;

    private static ApplicationComponent applicationComponent;

    private static InteractorComponent interactorComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        Realm.init(this);
        applicationComponent = buildApplicationComponent();
        interactorComponent = buildInteractorComponent(applicationComponent);
    }

    private ApplicationComponent buildApplicationComponent() {
        return DaggerApplicationComponent.builder().applicationModule(new ApplicationModule(this)).build();
    }

    private InteractorComponent buildInteractorComponent(ApplicationComponent applicationComponent) {
        return DaggerInteractorComponent.builder().applicationComponent(applicationComponent).dreamModule(new DreamModule()).planModule(new PlanModule()).build();
    }

    public static ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }

    public static InteractorComponent getInteractorComponent() {
        return interactorComponent;
    }
}
