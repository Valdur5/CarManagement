package de.pandigo.cars.models.stereo;

import java.util.List;

public abstract class AbstractStereo {

	private boolean isOn = false;
	private int level = 0;
	private List<SourceOption> sourceOptionList;
	private int maxLevel = 0;
	private int actualSourceIndex;

	void setMaxLevel(final int maxLevel) {
		this.maxLevel = maxLevel;
	}

	void setSourceOptionList(final List<SourceOption> sourceOptionList ){
	    this.sourceOptionList = sourceOptionList;
    }

    public SourceOption getCurrentSource() {
	    return this.sourceOptionList.get(this.actualSourceIndex);
    }

    public SourceOption nextSource()
    {
        if(this.actualSourceIndex < this.sourceOptionList.size()+1) {
            this.actualSourceIndex++;
        } else {
            this.actualSourceIndex = 0;
        }
        return this.sourceOptionList.get(this.actualSourceIndex);
    }

    public SourceOption prevSource()
    {
        if(this.actualSourceIndex > 0) {
            this.actualSourceIndex--;
        } else {
            this.actualSourceIndex = this.sourceOptionList.size();
        }
        return this.sourceOptionList.get(this.actualSourceIndex);
    }

	public void toggleOnOff() {
		this.isOn = !this.isOn;
	}

	public boolean isOn() {
		return this.isOn;
	}

	public void setLevel(final int level) {
		if (level <= this.maxLevel && level >= 0) {
			this.level = level;
		}
	}

	public int getLevel() {
		return this.level;
	}
}
