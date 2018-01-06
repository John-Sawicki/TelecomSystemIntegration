package app.cominjohnsawickitrkhp_identity_photo.linkedin.httpswww.telecomsystemintegration;

/**
 * Created by John on 4/22/2017.
 */

public class System {
    private String mSystemName;
    private int mSystemImageId;

    public System(String sys, int imageId) {
        mSystemName = sys;
        mSystemImageId = imageId;
    }
    public String getSystemName() {
        return mSystemName;
    }

    public int getImageResourceId() {
        return mSystemImageId;
    }
}