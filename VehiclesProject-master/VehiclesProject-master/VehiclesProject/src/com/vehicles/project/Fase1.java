package com.vehicles.project;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * 
	FASE 1:

	Ens donen un codi parcialment desenvolupat. El codi pot no estar complet i que s’hagi de modificar.

	El podem descarregar d’aquest link: https://github.com/ITAcademyProjects/VehiclesProject

	Ens demanen crear una classe Main que realitzi els següents passos: 
	
	1) Demanar a l’usuari la matrícula del cotxe, la marca i el seu color.

	2) Crear el cotxe amb les dades anteriors.

	3) Afegir-li dues rodes traseres demanant a l’usuari la marca i el diametre.

	4) Afegir-li dues rodes davanteres demanant a l’usuari la marca i el diametre.
	 
 */


public class Fase1 {

	public static void main(String[] args) {
	
		Scanner entrada = new Scanner(System.in);			//OBJETO Scanner PARA RECOJER ENTRADA POR CONSOLA
	
		String color, marca, matricula;						//VARIABLES ATRIBUTOS VEHICULO
		double diametre;									//VARIABLE ATRIBUTO RUEDA
		
		int i=1;
		List<Wheel> RodesTraseres = new ArrayList<Wheel>();		//ARRAY RUEDAS TRASERAS
		List<Wheel> RodesDavanteres = new ArrayList<Wheel>();	//ARRAY RUEDAS DELANTERAS
		
	
		System.out.println("Introdueix la matrícula del cotxe : ");		//PETICION DE MATRICULA POR CONSOLA
		matricula=entrada.nextLine();
		
		System.out.println("Introdueix la marca del cotxe : ");			//PETICION MARCA POR CONSOLA
		marca=entrada.nextLine();
		
		System.out.println("Introdueix el color del cotxe : ");			//PETICION COLOR POR CONSOLA
		color=entrada.nextLine();

	
		Car cotxe = new Car(matricula,marca,color);						//CREO UN OBJETO DE LA CLASE COCHE
	
		
		System.out.println("------------  RUEDAS TRASERAS -------------\n");
		
		do {															//PIDO POR CONSOLA DOS VECES LAS RUEDAS
						
			System.out.println("RUEDA num. " + i + " -- MARCA  :");		//PIDO MARCA DE LA RUEDA
			marca=entrada.nextLine();
			
			System.out.println("RUEDA num. " + i + " -- DIAMETRO  :");	//PIDO DIAMETRO DE LA RUEDA
			diametre=Double.parseDouble(entrada.nextLine());
			
			Wheel RodeT = new Wheel(marca, diametre);					//CREO OBJETO RUEDA
			
			RodesTraseres.add(RodeT);									//GUARDO LA RUEDA CREADA EN EL ARRAY RUEDAS TRASERAS
			
			i++;
			
		}while (i<3);
		
		i=1;
		
		System.out.println("------------  RUEDAS DELANTERAS -------------\n");
		
		do {
			
			System.out.println("RUEDA num. " + i + " -- MARCA  :");		//PIDO POR CONSOLA DOS VECES LAS RUEDAS
			marca=entrada.nextLine();									//PIDO MARCA DE LA RUEDA
			
			System.out.println("RUEDA num. " + i + " -- DIAMETRO  :");	//PIDO DIAMETRO DE LA RUEDA
			diametre=Double.parseDouble(entrada.nextLine());
			
			Wheel RodeD = new Wheel(marca, diametre);					//CREO OBJETO RUEDA
			
			RodesDavanteres.add(RodeD);									//GUARDO LA RUEDA CREADA EN EL ARRAY RUEDAS TRASERAS
				
			i++;
			
		}while (i<3);
		
		try {
			cotxe.addWheels(RodesDavanteres, RodesTraseres);			//AÑADO LAS RUEDAS AL OBJETO COCHE ENVIANDO LOS DOS ARRAY DE RUEDAS
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		System.out.println(cotxe);										//MUESTRO COCHE POR CONSOLA
		
	}

}
