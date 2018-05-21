package com.desarrollox.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "beer")
public class Beer extends BaseEntity {

	/**
	 * Classe modelo para a cerveja
	 */
	private static final long serialVersionUID = 8128048827039840802L;

	@Id
	@GeneratedValue
	private Long id;
	
	@Column (name = "name")
	private String name;
	
	@Column (name = "category")
	private String category;
	
	@Column (name = "nationality")
	private String nationality;
	
	@Column (name = "price")
	private Double price;
	
	@Lob
	@Column (name = "image")
	private byte[] image;
	
	@Column (name = "path")
	private String path;

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

}
