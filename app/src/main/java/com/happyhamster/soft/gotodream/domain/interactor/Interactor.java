package com.happyhamster.soft.gotodream.domain.interactor;

import java.util.UUID;
import java.util.function.Function;

import io.reactivex.Observable;
import io.realm.Realm;

/**
 * Created by Vilgodskiy_Sergey on 08.06.2017.
 */

abstract class Interactor<T> {

    protected Observable<T> doInTransaction(Function<Realm, Observable<T>> function) {
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        Observable<T> result = function.apply(realm);
        realm.commitTransaction();
        return result;
    }

    protected String getRandomId(){
        return UUID.randomUUID().toString();
    }

}
