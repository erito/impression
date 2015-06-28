package com.erikbuttram.impression.enums;

import android.hardware.Camera;

import com.erikbuttram.impression.RequestCreator;

/**
 * Enums that can be used to specify position, note if this isn't set in the
 * {@link RequestCreator}, it will simply traverse the list of cameras as you
 * request {@link RequestCreator#togglePosition()}
 */
public enum CameraPosition {
    /**
     * Indicates that this is the camera most likely to be used the device, usually the rear facing
     */
    STANDARD,
    /**
     * Indicates this is a camera mounted on the front of the device
     */
    FRONT;

    public static CameraPosition fromOld(int facing) {
        if (facing == Camera.CameraInfo.CAMERA_FACING_FRONT) {
            return FRONT;
        } else {
            return STANDARD;
        }
    }
}
