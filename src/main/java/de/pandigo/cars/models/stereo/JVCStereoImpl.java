package de.pandigo.cars.models.stereo;

import java.util.Arrays;

public class JVCStereoImpl extends AbstractStereo{

    private static final int MAX_LEVEL = 50;

    public JVCStereoImpl() {
        this.setMaxLevel(MAX_LEVEL);
        this.setSourceOptionList(Arrays.asList(SourceOption.FM,SourceOption.DVD,SourceOption.Spotify,SourceOption.Youtube));
    }
}
