package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Person;

public class Program {

	public static void main(String[] args) {

		final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		try {

			System.out.println("Enter the person's data:");
			System.out.print("Name: ");
			String name = sc.nextLine();

			System.out.print("Birth (DD/MM/YYYY): ");
			Date birth = sdf.parse(sc.next());

			System.out.print("Height: ");
			Double height = sc.nextDouble();

			Person per = new Person(name, birth, height);

			System.out.println();
			System.out.println(per);

		} catch (ParseException e) {
			System.out.println("Invalid Date format.");
		} catch (InputMismatchException e) {
			System.out.println("Invalid input.");
		} catch (RuntimeException e) {
			System.out.println("Unexpected error.");
		}

		sc.close();

	}

}
