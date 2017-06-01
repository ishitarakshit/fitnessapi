package com.practice.data;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;

@Embeddable
public class Goal {

	@Embedded
	@AttributeOverrides({
	    @AttributeOverride(name="amount", column=@Column(name="START_WEIGHT")),
	    @AttributeOverride(name="unit", column=@Column(name="START_WEIGHT_UNIT")),
	    @AttributeOverride(name="dateTime", column=@Column(name="START_DATE"))
	  })
	private Weight startWeight;

	@Embedded
	@AttributeOverrides({
	    @AttributeOverride(name="amount", column=@Column(name="TARGET_WEIGHT")),
	    @AttributeOverride(name="unit", column=@Column(name="TARGET_WEIGHT_UNIT")),
	    @AttributeOverride(name="dateTime", column=@Column(name="TARGET_DATE"))
	  })
	private Weight targetWeight;

	public Weight getStartWeight() {
		return startWeight;
	}

	public void setStartWeight(Weight startWeight) {
		this.startWeight = startWeight;
	}

	public Weight getTargetWeight() {
		return targetWeight;
	}

	public void setTargetWeight(Weight targetWeight) {
		this.targetWeight = targetWeight;
	}

}
