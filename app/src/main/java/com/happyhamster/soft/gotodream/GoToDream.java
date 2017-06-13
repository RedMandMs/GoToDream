package com.happyhamster.soft.gotodream;

import android.app.Application;

import com.happyhamster.soft.gotodream.di.ApplicationComponent;

import io.realm.Realm;

/**
 * Created by Vilgodskiy_Sergey on 08.06.2017.
 */

public class GoToDream extends Application {

    private GoToDream instance;

    ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        Realm.init(this);
        applicationComponent = buildComponent();
    }

    private ApplicationComponent buildComponent() {
        return null;
    }
}
