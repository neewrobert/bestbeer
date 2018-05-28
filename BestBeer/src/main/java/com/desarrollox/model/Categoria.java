package com.desarrollox.model;

public enum Categoria {

	LARGER				(1, "Larger"), 
	PILSEN				(2, "Pilsen"),
	BOCK				(3, "Bock"),
	ALE					(4, "Ale"),
	WEISSBIER			(5, "Weissbier"),
	BARLEY_WINE 		(6, "Barley Wine"),
	INDIA_PALE_ALE		(7, "India Pale Ale"),
	AMBER_ALE_RED_ALE	(8, "Amber Ale Red Ale"),
	STOUT				(9, "Stout"),
	STRONG_ALE			(10, "Strong Ale"),
	DUBBEL				(11, "Dubbel");


	private int id;
	private String nome;

	private Categoria(int id, String nome) {
		this.id = id;
		this.nome = nome;
	}
	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
