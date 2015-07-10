package com.erikbuttram.impression.strategies;

import android.content.Context;
import android.hardware.camera2.CameraManager;

import com.erikbuttram.impression.enums.CameraPosition;
import com.erikbuttram.impression.session.CameraSession;

import java.util.concurrent.Callable;

/**
 * Created by erikb on 7/9/15.
 */
public class SessionAcquirerLollipop implements Callable<CameraSession> {

    private CameraPosition mPos;
    private final CameraManager mManager;

    public SessionAcquirerLollipop(Context context, CameraPosition pos) {
        mPos = pos;
        mManager = (CameraManager)context.getSystemService(Context.CAMERA_SERVICE);
    }

    @Override
    public CameraSession call() throws Exception {
        //callback right herrr dawg
        return null;
    }
}
