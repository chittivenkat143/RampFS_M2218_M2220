package com.hcl.training.pojos;

public class Cricket implements Game{
	
	private String teamName;
	private Integer teamSize;

	public String gameName() {
		return "Cricket";
	}

	public String typeOfGame() {
		return "Outdoor";
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public Integer getTeamSize() {
		return teamSize;
	}

	public void setTeamSize(Integer teamSize) {
		this.teamSize = teamSize;
	}
	
}
