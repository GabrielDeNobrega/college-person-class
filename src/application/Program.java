package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Person;

public class Program {

	public static void main(String[] args) {

		final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		try {

			System.out.println("Enter the person's data:");
			System.out.print("Name: ");
			String name = sc.nextLine();

			System.out.print("Birth (DD/MM/YYYY): ");
			LocalDate birth = LocalDate.parse(sc.next(), dtf);

			System.out.print("Height: ");
			Double height = sc.nextDouble();

			Person per = new Person(name, birth, height);

			System.out.println();
			System.out.println(per);

		} catch (InputMismatchException e) {
			System.out.println("Invalid input.");
		} catch (RuntimeException e) {
			System.out.println("Unexpected error.");
		}

		sc.close();

	}

}
