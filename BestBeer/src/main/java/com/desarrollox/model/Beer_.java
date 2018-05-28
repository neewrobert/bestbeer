package com.desarrollox.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2018-05-27T20:56:56.589-0300")
@StaticMetamodel(Beer.class)
public class Beer_ {
	public static volatile SingularAttribute<Beer, Long> id;
	public static volatile SingularAttribute<Beer, String> name;
	public static volatile SingularAttribute<Beer, String> nationality;
	public static volatile SingularAttribute<Beer, Double> price;
	public static volatile SingularAttribute<Beer, byte[]> image;
	public static volatile SingularAttribute<Beer, String> path;
	public static volatile SingularAttribute<Beer, String> category;
}
