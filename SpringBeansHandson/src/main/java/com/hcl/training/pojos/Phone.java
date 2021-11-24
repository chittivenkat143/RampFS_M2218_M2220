package com.hcl.training.pojos;

import java.util.List;

public interface Phone {
	String company();
	String model();
	String os();
	Integer version();
	List<String> featuresSupport();
}
