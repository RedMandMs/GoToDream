package com.happyhamster.soft.gotodream.domain.interactor;

import java.util.function.Function;

import io.reactivex.Observable;
import io.realm.Realm;

/**
 * Created by Vilgodskiy_Sergey on 08.06.2017.
 */

abstract class Interactor<T> {

    Observable<T> doInTransaction(Function<Realm, Observable<T>> function) {
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        return function.apply(realm);
    }

}
