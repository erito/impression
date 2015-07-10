package com.erikbuttram.impression.strategies;

import android.hardware.Camera;

import com.erikbuttram.impression.RequestCreator;
import com.erikbuttram.impression.enums.CameraPosition;
import com.erikbuttram.impression.session.CameraSession;

import java.util.concurrent.Callable;

/**
 * Created by erikb on 7/9/15.
 */
public class SessionAcquirer implements Callable<CameraSession> {

    private CameraPosition mPos;

    public SessionAcquirer(CameraPosition pos) {
        mPos = pos;
    }

    @Override
    public CameraSession call() throws Exception {
        Camera selected = null;
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
            //TODO:  Here we get the camera session from the camera
        } catch (Exception ex) {
            throw ex;
        }
        return null;
    }
}
