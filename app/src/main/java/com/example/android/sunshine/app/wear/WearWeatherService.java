package com.example.android.sunshine.app.wear;

/**
 * Created by anikr on 10/30/2016.
 */

import android.util.Log;

import com.example.android.sunshine.app.sync.SunshineSyncAdapter;
import com.google.android.gms.wearable.DataEvent;
import com.google.android.gms.wearable.DataEventBuffer;
import com.google.android.gms.wearable.WearableListenerService;

public class WearWeatherService extends WearableListenerService {

    private static final String TAG = WearWeatherService.class.getSimpleName();

    private static final String WEATHER_PATH = "/weather";
    @Override
    public void onDataChanged(DataEventBuffer dataEvents) {Log.d("aniki","start asdsadsad");
        for (DataEvent dataEvent : dataEvents) {
            if (dataEvent.getType() == DataEvent.TYPE_CHANGED) {
                String path = dataEvent.getDataItem().getUri().getPath();
                Log.d(TAG, path);
                if (path.equals(WEATHER_PATH)) {Log.d("aniki","start syncv");
                    SunshineSyncAdapter.syncImmediately(this);
                }
            }
        }
    }
}
