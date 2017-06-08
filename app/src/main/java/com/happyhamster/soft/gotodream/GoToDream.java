package com.happyhamster.soft.gotodream;

import android.app.Application;

import com.happyhamster.soft.gotodream.di.ApplicationComponent;

/**
 * Created by Vilgodskiy_Sergey on 08.06.2017.
 */

public class GoToDream extends Application {

    private GoToDream instance;

    ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        applicationComponent = buildComponent();
    }

    private ApplicationComponent buildComponent() {
        return null;
    }
}
