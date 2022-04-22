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

	private long calculateAge() {
		Date now = new Date();
		long age = now.getTime() - birth.getTime();
		age = TimeUnit.DAYS.convert(age, TimeUnit.MILLISECONDS);
		return age / 365;

	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();

		sb.append("Person's Data:\n");
		sb.append("Name : " + name + "\n");
		sb.append("Birth: " + sdf.format(birth) + "\n");
		sb.append("Age: " + calculateAge() + "\n");
		sb.append("Height: " + String.format("%.2f%n", height) + "\n");

		return sb.toString();
	}

}
