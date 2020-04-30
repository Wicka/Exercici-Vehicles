package com.vehicles.project;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * FASE 2:

	Millorar el codi anterior comprovant la informació necesaria alhora de crear els objectes. S’ha de tenir en compte:

	- Una matrícula ha de tenir 4 números i dues o tres lletres.

	- Un diametre de la roda ha de ser superior a 0.4 i inferior a 4 
	
 */

public class Fase2 {
	
	public static void main(String[] args) {
		
		Scanner entrada = new Scanner(System.in);	//OBJETO Scanner PARA RECOJER ENTRADA POR CONSOLA
	
		String color, marca, matricula;				//ATRIBUTOS VEHICULO
	
		double diametre;							//ATRIBUTO RUEDA
		
		boolean bien=false;							//BOOLEAN PARA CONDICION BUCLES
		
		int i=1, iCont=0;							//CONTADORES PARA BUCLE E iCont PARA CONTAR VECES DE NUMEROS EN MATRICULA

		char caracter;								//CHAR PARA RECORRER String MATRICULA
		
		
		List<Wheel> RodesTraseres = new ArrayList<Wheel>();			//ARRAY RUEDAS TRASERAS
		List<Wheel> RodesDavanteres = new ArrayList<Wheel>();		//ARRAY RUEDAS DELANTERAS
		

		do {								//BUCLE PARA INTRODUCIR MATRICULA CORRECTA DEBE TENER 4 NUMEROS Y 2 o 3 LETRAS (B-1234-HZ o 1234-BKZ)
			
			System.out.println("Introdueix la matrícula del cotxe : ");			//PIDO MATRICULA POR CONSOLA
			matricula=entrada.nextLine();
			
			matricula=matricula.toUpperCase();				//PASO A MAYUSCULAS
			matricula=matricula.replace("-", "");			//QUITO  GUIONES			
			matricula=matricula.replace(" ","");			//QUITO ESPACIOS BLANCOS
			
			iCont=0;										//INICIO VECES QUE APARECE UN NUMERO EN String matricula
			
			if (matricula.length() < 8) {		//COMPRUEBO QUE MATRICULA TENGA LA LONGITUD CORRECTA (7 caracteres)
				
				bien=true;		//TIENE LA LONGITUD CORRECTA
				
				
				for(int j=0; j< matricula.length() ; j++) {	//RECORRO STRING matricula 
					
					caracter=matricula.charAt(j);		//SELECCIONO EL caracter DEL STRING matricula
					
					if (Character.isDigit(caracter)) {	//COMPRUEBO SI ES UN NUMERO
						iCont++;						//STRING matricula TENDRA TANTOS NUMEROS COMO INDIQUE iCont		
					}										
				}				
							
			}else {
				
				bien=false;		//EL STRING TIENE MAS O MENOS DE 7 CARACTERES
			}
			
			
			if (bien!=true || iCont!=4) {	//SI LONGITUD NO CORRECTA Y NO TIENE 4 NUMEROS MSJ DE ERROR Y VUELVO PEDIR MATRICULA
				
				System.out.println("ERROR MATRICULA INCORRECTA VUELVE A INTRODUCIRLA \n");
			}
		
		}while(bien!=true || iCont!=4);		//REPITO BUCLE DE PEDIR MATRICULA HASTA QUE CUMPLA AMBAS CONDICIONES
		
		
		System.out.println("Introdueix la marca del cotxe : ");			//PIDO MARCA POR CONSOLA
		marca=entrada.nextLine();
		
		System.out.println("Introdueix el color del cotxe : ");			//PIDO COLOR POR CONSOLA
		color=entrada.nextLine();
	
		Car cotxe = new Car(matricula,marca,color);						//CREO OBJETO COCHE 
		
		
		System.out.println("------------  RUEDAS TRASERAS -------------\n");	
		
		bien=false;						//INICIO ESTADO DE bien A false
		
		do {
						
			System.out.println("RUEDA num. " + i + " -- MARCA  :");		//PIDO MARCA RUEDA TRASERA
			marca=entrada.nextLine();
			
			do {
			
				System.out.println("RUEDA num. " + i + " -- DIAMETRO  :");	//PIDO DIAMETRO RUEDA TRASERA
				diametre=Double.parseDouble(entrada.nextLine());			//LO CONVIERTO EN DOUBLE
				
				
				if (diametre < 0.4 || diametre > 4 ) {				//REVISO SI diametre CUMPLE CONDICION 0.4 > diametre < 4	
					
					System.out.println("ERROR EL DIAMETRO DEBE SER --- 0.4 > DIAMETRO < 4 ---- \n");
					bien=false;		//NO CUMPLE CONDICION Y ACTUALIZO bien a false
					
				}else {
					
					bien=true;		//SI CUMPLE CONDICION ACTUALIZO bien a true PARA SALIR DEL BUCLE COMPROBACION
				}
				
			}while(bien!=true);		//NO SALDRE DE ESTE BUCLE HASTA QUE bien SEA true
			
			Wheel RodeT = new Wheel(marca, diametre);			//CREO OBEJTO RUEDA
			RodesTraseres.add(RodeT);							//GUARDO RUEDA EN ARRAY RUEDAS TRASERAS
				
			i++;												//INCREMENTO i
			
		}while (i<3 || bien!=true);		//NO SALDRE HASTA QUE HAYA CREADO DOS RUEDAS Y AMBAS TENGA CONDICION bien true
		
		i=1;							//REINICIO i
		
		bien=false;						//REINICIO bien
		
		System.out.println("------------  RUEDAS DELANTERAS -------------\n");
		
		do {
			
			System.out.println("RUEDA num. " + i + " -- MARCA  :");		//PIDO MARCA RUEDA TRASERA
			marca=entrada.nextLine();
	
			do {
			
				System.out.println("RUEDA num. " + i + " -- DIAMETRO  :");	//PIDO DIAMETRO RUEDA TRASERA
				diametre=Double.parseDouble(entrada.nextLine());
	
				if (diametre < 0.4 || diametre > 4 ) {				//REVISO SI diametre CUMPLE CONDICION 0.4 > diametre < 4
					
					System.out.println("ERROR EL DIAMETRO DEBE SER --- 0.4 > DIAMETRO < 4 ---- \n");
					bien=false;								//NO CUMPLE CONDICION Y ACTUALIZO bien a false
					
				}else {
					
					bien=true;		//SI CUMPLE CONDICION ACTUALIZO bien a true PARA SALIR DEL BUCLE COMPROBACION
				}
				
			}while(bien!=true);		//NO SALDRE DE ESTE BUCLE HASTA QUE bien SEA true
			
			
			Wheel RodeD = new Wheel(marca, diametre);			//CREO OBEJTO RUEDA	
			RodesDavanteres.add(RodeD);							//GUARDO RUEDA EN ARRAY RUEDAS TRASERAS
				
			i++;												//INCREMENTO i
			
		}while (i<3 || bien!=true);				//NO SALDRE HASTA QUE HAYA CREADO DOS RUEDAS Y AMBAS TENGA CONDICION bien true
		
		try {
			cotxe.addWheels(RodesDavanteres, RodesTraseres);		//AÑADO LAS RUEDAS AL OBJETO COCHE CONTROLANDO LA EXCEPCION QUE LANZAN
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		System.out.println(cotxe);				//MUESTRO COCHE POR CONSOLA			
	}

}
