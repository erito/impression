package com.erikbuttram.impression.strategies;

import com.erikbuttram.impression.RequestCreator;
import com.erikbuttram.impression.enums.CameraPosition;
import com.erikbuttram.impression.session.CameraSession;

/**
 * Created by erikb on 6/27/15.
 */
public interface StrategyInterface {
     CameraSession execute(RequestCreator.CameraCallback listener, CameraPosition pos);
}
