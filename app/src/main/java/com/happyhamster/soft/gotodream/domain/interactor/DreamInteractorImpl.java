package com.happyhamster.soft.gotodream.domain.interactor;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.happyhamster.soft.gotodream.GoToDream;
import com.happyhamster.soft.gotodream.domain.entity.Dream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;

import javax.inject.Inject;
import javax.inject.Named;

import io.reactivex.Observable;

/**
 * Created by Vilgodskiy_Sergey on 07.06.2017.
 */
public class DreamInteractorImpl extends Interactor<Dream> implements DreamInteractor {

    @Inject
    PlanInteractor planInteractor;

    @Inject
    @Named("application")
    Context context;

    public DreamInteractorImpl() {
        GoToDream.getInteractorComponent().inject(this);
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
        if(dream.getId() != null){
            throw new IllegalArgumentException("Нельзя сохранить мечту, у которой уже есть Id");
        }
        return doInTransaction(realm -> {
            dream.setId(getRandomId());
            return Observable.just(realm.copyToRealm(dream));});
    }

    @Override
    public Observable<Dream> update(Dream dream) {
        if(dream.getId() == null){
            throw new IllegalArgumentException("Нельзя обновить мечту, у которой отсутствует Id");
        }
        return doInTransaction(realm -> {
            planInteractor.update(dream.getPlan());
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

    @Override
    public void updateImage(String id, Bitmap image) {
        String fileName = getImageFileName(id);
        if(image != null) {
            try (FileOutputStream fos = context.openFileOutput(fileName, Context.MODE_PRIVATE)) {
                ByteBuffer buffer = ByteBuffer.allocate(image.getByteCount());
                image.copyPixelsToBuffer(buffer);
                fos.write(buffer.array());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else {
            context.deleteFile(fileName);
        }
    }

    @Override
    public Bitmap getImage(String id) {
        String fileName = getImageFileName(id);
        File file = context.getFileStreamPath(fileName);
        if(file.exists()) {
            try (FileInputStream fis = context.openFileInput(fileName)) {
                ByteBuffer buffer = ByteBuffer.allocate(fis.available());
                byte[] biteArray = buffer.array();
                fis.read(biteArray, 0, fis.available());
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inMutable = true;
                return BitmapFactory.decodeByteArray(biteArray, 0, biteArray.length, options);
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }else {
            return null;
        }
    }

    private String getImageFileName(String id){
        return Dream.class.getSimpleName() + "_image_" + id;
    }
}
