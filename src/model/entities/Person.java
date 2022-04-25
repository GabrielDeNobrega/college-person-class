package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Person {

	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	private String name;
	private Date birth;
	private Double height;

	public Person() {

	}

	public Person(String name, Date birth, Double height) {
		this.name = name;
		this.birth = birth;
		this.height = height;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public Double getHeight() {
		return height;
	}

	public void setHeight(Double height) {
		this.height = height;
	}

	private long[] calculateAge() {
		Date now = new Date();
		long[] finalAge = new long[3];

		long age = now.getTime() - birth.getTime();
		age = TimeUnit.DAYS.convert(age, TimeUnit.MILLISECONDS);

		long years = age / 365;
		long month = (age % 365) / 30;

		finalAge[0] = years;
		finalAge[1] = month;
		finalAge[2] = month % 30;

		return finalAge;

	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();

		sb.append("Person's Data:\n");
		sb.append("Name : " + name + "\n");
		sb.append("Birth: " + sdf.format(birth) + "\n");
		sb.append("Age: " + calculateAge()[0] + " years " + calculateAge()[1] + " months " + calculateAge()[2]
				+ " days\n");
		sb.append("Height: " + String.format("%.2f%n", height) + "\n");

		return sb.toString();
	}

}
