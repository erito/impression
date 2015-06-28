package com.erikbuttram.impression.strategies;

import android.content.Context;
import android.hardware.Camera;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;

import com.erikbuttram.impression.RequestCreator;
import com.erikbuttram.impression.enums.CameraPosition;
import com.erikbuttram.impression.session.CameraSession;

import java.lang.ref.WeakReference;
import java.util.concurrent.RunnableFuture;

/**
 * Strategy used to get camera for api level < 21 by erikb on 6/27/15.
 */
public class BaseStrategy implements StrategyInterface {

    public BaseStrategy(Context context) {
    }

    @Override
    public CameraSession execute(RequestCreator.CameraCallback listener, CameraPosition pos) {
        Thread thread = new Thread();

        return null;
    }

    private class CameraAcquirer implements Runnable {

        WeakReference<RequestCreator.CameraCallback> mRef;
        private Handler mHandler;
        private CameraPosition mPos;

        public CameraAcquirer(RequestCreator.CameraCallback callback, CameraPosition pos) {
            mRef = new WeakReference<>(callback);
            mHandler = new Handler();
            mPos = pos;
        }

        @Override
        public void run() {
            Camera selected = null;
            Throwable e = null;
            try {
                int k = Camera.getNumberOfCameras();
                for (int i = 0; i < k; i++) {
                    Camera.CameraInfo ci = new Camera.CameraInfo();
                    Camera.getCameraInfo(k, ci);
                    CameraPosition pos = CameraPosition.fromOld(ci.facing);
                    if (pos == mPos) {
                        selected = Camera.open(i);
                        break;
                    }
                }
            } catch (Exception ex) {
                e = ex;
            }

            final Throwable finalE = e;
            //TODO:  Configure a camera session.
            mHandler.post(new Runnable() {
                @Override
                public void run() {

                    if (mRef.get() != null) {
                        if (finalE != null) {
                            mRef.get().onError(finalE);
                        } else {
                            //mRef.get().onSuccess();
                        }
                    }

                }
            });
        }
    }

}
