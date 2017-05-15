package de.pandigo.cars.models.stereo;

import java.util.Arrays;

public class KenwoodStereoImpl extends AbstractStereo{

    private static final int MAX_LEVEL = 40;

    public KenwoodStereoImpl() {
        this.setMaxLevel(MAX_LEVEL);
        this.setSourceOptionList(Arrays.asList(SourceOption.Aux,SourceOption.CD,SourceOption.FM));
    }
}
