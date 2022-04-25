package model.entities;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Person {

	private static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	private String name;
	private LocalDate birth;
	private Double height;

	public Person() {

	}

	public Person(String name, LocalDate birth, Double height) {
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

	public LocalDate getBirth() {
		return birth;
	}

	public void setBirth(LocalDate birth) {
		this.birth = birth;
	}

	public Double getHeight() {
		return height;
	}

	public void setHeight(Double height) {
		this.height = height;
	}

	private long[] calculateAge() {
		LocalDate today = LocalDate.now();
		long[] finalAge = new long[3];

		Period p = Period.between(birth, today);

		finalAge[0] = p.getYears();
		finalAge[1] = p.getMonths();
		finalAge[2] = p.getDays();

		return finalAge;

	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();

		sb.append("Person's Data:\n");
		sb.append("Name : " + name + "\n");
		sb.append("Birth: " + dtf.format(birth) + "\n");
		sb.append("Age: " + calculateAge()[0] + " years " + calculateAge()[1] + " months " + calculateAge()[2]
				+ " days\n");
		sb.append("Height: " + String.format("%.2f%n", height) + "\n");

		return sb.toString();
	}

}
