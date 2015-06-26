package com.erikbuttram.impression;

import android.app.Application;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.view.Surface;

import com.erikbuttram.impression.enums.CameraPosition;

import java.io.IOException;

/**
 * Base class to retrieve and instantiate {@link com.erikbuttram.impression.session.CameraSession}
 * for use.  Note that {@link RequestCreator} will use either the
 * {@link android.hardware.camera2.CaptureRequest} or plain {@link android.hardware.Camera} api
 * as a fallback
 */
public class RequestCreator {

    private Context mContext;
    private CameraPosition mPosRequested;
    private Object mPreviewSurface;

    public void togglePosition() {
        //TODO:  this
    }

    /**
     * Instantiates a new {@link Builder}
     * @param context
     * @return {@link Builder}
     */
    private static Builder with(Context context) {
        return new Builder(context);
    }


    private static class Builder {

        private RequestCreator mRequest;

        /**
         * An optional {@link SurfaceTexture } to render a preview/capture session onto onto
         * if nothing is specified here, it can be specified at a later point when a
         * @param surface
         * @return
         */
        public Builder onto(Surface surface) {
            this.mRequest.mPreviewSurface = surface;
            return this;
        }

        /**
         * An optional {@link SurfaceTexture } to render a preview/capture session onto onto
         * if nothing is specified here, it can be specified at a later point when a
         * @param texture
         * @return
         */
        public Builder onto(SurfaceTexture texture) {
            this.mRequest.mPreviewSurface = texture;
            return this;
        }

        public Builder position(CameraPosition pos) {
            mRequest.mPosRequested = pos;
            return this;
        }

        /**
         *
         * @throws IllegalArgumentException
         * @throws  java.io.IOException
         */
        public void execute() throws IOException {

        }

        public Builder(Context context) {
            RequestCreator request = new RequestCreator();
            if (context instanceof Application) {
                request.mContext = context;
            } else {
                request.mContext = context.getApplicationContext();
            }
            request.mPosRequested = CameraPosition.STANDARD;
        }
    }
}
