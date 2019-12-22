package com.company;

import java.util.Scanner;

public class cLector {

	public int llegirEnter(){

		Scanner lector = new Scanner(System.in);
		int correcte = 0;

		while (!lector.hasNextInt()){
				lector.next();
				System.out.print("No és un enter. Introdueix un altre número: ");
		}
		correcte=lector.nextInt();
		lector.nextLine();
		return correcte;
	}

	public int llegirEnter (String missatge){
		System.out.print(missatge);
		return llegirEnter();
	}

	public float llegirFloat(){

		Scanner lector = new Scanner(System.in);
		float correcte = 0;

		while (!lector.hasNextFloat()){
			lector.next();
			System.out.print("No és un número vàlid. Introdueix un altre número: ");
		}
		correcte=lector.nextFloat();
		lector.nextLine();
		return correcte;
	}

	public float llegirFloat (String missatge){
		System.out.print(missatge);
		return llegirFloat();
	}

	public String llegirString (){
		String frase = "";
		Scanner lector = new Scanner(System.in);

		frase=lector.nextLine();
		return frase;
	}

	public String llegirString (String missatge){
		System.out.print(missatge);
		return llegirString();
	}

	public char llegirChar (){
		char caracter = ' ';
		Scanner lector = new Scanner(System.in);

		caracter=lector.next().charAt(0);
		return caracter;
	}

	public char llegirChar (String missatge){
		System.out.print(missatge);
		return llegirChar();
	}
}
