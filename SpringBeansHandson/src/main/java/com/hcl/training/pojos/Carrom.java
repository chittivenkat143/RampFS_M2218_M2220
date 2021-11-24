package com.hcl.training.pojos;

import org.springframework.beans.factory.annotation.Autowired;

public class Carrom implements Game{
	
	private Integer gameSize;// 2players Singles; 4players Doubles
	private CarromType type;
	
	@Autowired
	public Carrom(CarromType type) {
		this.type = type;
	}
	
	public Carrom() {
	}

	public String gameName() {
		// TODO Auto-generated method stub
		return "Carrom";
	}

	public String typeOfGame() {
		// TODO Auto-generated method stub
		return "Indoor";
	}

	public Integer getGameSize() {
		return gameSize;
	}

	public void setGameSize(Integer gameSize) {
		this.gameSize = gameSize;
	}
	
	public CarromType getCarromType() {
		return getGameSize() == 2 ? CarromType.SINGLE : CarromType.DOUBLE;
	}
	
}
