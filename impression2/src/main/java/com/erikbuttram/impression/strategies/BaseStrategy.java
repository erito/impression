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
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.RunnableFuture;

/**
 * Strategy used to get camera for api level < 21 by erikb on 6/27/15.
 */
public class BaseStrategy implements StrategyInterface {

    public BaseStrategy(Context context) {
    }

    @Override
    public void execute(RequestCreator.CameraCallback listener, CameraPosition pos) {

    }
}
