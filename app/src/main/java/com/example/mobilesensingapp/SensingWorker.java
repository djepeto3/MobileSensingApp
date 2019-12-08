package com.example.mobilesensingapp;

import android.content.ContentValues;
import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.work.ListenableWorker;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

import com.aware.Aware;
import com.aware.Locations;
import com.aware.providers.Locations_Provider;

public class SensingWorker extends Worker {
    public SensingWorker(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
    }

    @NonNull
    @Override
    public Result doWork() {

        Aware.startLocations(ApplicationContext.getContext());

        Locations.setSensorObserver(new Locations.AWARESensorObserver() {
            @Override
            public void onLocationChanged(ContentValues data) {

                final double latitude =data.getAsDouble(Locations_Provider.Locations_Data.LATITUDE);
                final double longitude=data.getAsDouble(Locations_Provider.Locations_Data.LONGITUDE);

                long timestamp = data.getAsLong(Locations_Provider.Locations_Data.TIMESTAMP);
                Log.d("-----------------Location","Time: "+timestamp+" Latitude: "+latitude+" Longitude: "+longitude+"----------------");
            }
        });
        return ListenableWorker.Result.success();
    }
}
