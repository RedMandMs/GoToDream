package com.happyhamster.soft.gotodream.domain.interactor;

import com.happyhamster.soft.gotodream.domain.entity.Dream;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * Created by Vilgodskiy_Sergey on 07.06.2017.
 */
public class DreamInteractorImpl extends Interactor<Dream> implements DreamInteractor {

    @Inject
    PlanInteractor planInteractor;

    public DreamInteractorImpl() {

    }

    @Override
    public Observable<Dream> get(Long id) {
        return doInTransaction(realm -> Observable.just(realm.where(Dream.class).equalTo("id", id).findFirst()));
    }

    @Override
    public Observable<Dream> getAll() {
        return doInTransaction(realm -> Observable.fromIterable((realm.where(Dream.class).findAll())));
    }

    @Override
    public Observable<Dream> persist(Dream dream) {
        return doInTransaction(realm -> Observable.just(realm.copyToRealm(dream)));
    }

    @Override
    public Observable<Dream> update(Dream dream) {
        return doInTransaction(realm -> {
            realm.insertOrUpdate(dream);
            return Observable.just(dream);
        });
    }

    @Override
    public void remove(Long id) {
        doInTransaction(realm -> {
            realm.where(Dream.class).equalTo("id", id).findAll().deleteAllFromRealm();
            return Observable.empty();
        });
    }
}
