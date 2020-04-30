package com.vehicles.project;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * FASE 3:

	Modifica el projecte anterior afegint els mètodes necessaris a Bike, de manera que es pugui afegir rodes davanteres i traseres.
	
	Modificar el Main anterior, afegint la opció de Bike o Car:
	
	0) Preguntar a l’usuari si vol crear un cotxe o una moto.
	
	1) Demanar a l’usuari la matrícula, la marca i el seu color.
	
	2) Crear el vehícle amb les dades anteriors.
	
	3) Afegir-li les rodes traseres corresponents, demanant a l’usuari la marca i el diametre.
	
	4) Afegir-li les rodes davanteres corresponents, demanant a l’usuari la marca i el diametre. 

 */

public class Fase3 {

	
	public static void main(String[] args) {
		
		Scanner entrada = new Scanner(System.in);		//OBJETO Scanner PARA PEDIR DATOS POR CONSOLA
	
		String color, marca, matricula;					//VARIABLE PARA  VEHICULOS
		
		boolean bien=false;								//VARIABLE BOOLEAN PARA CONTROLAR BUCLES
		
		double diametre;								//VARIABLE PARA RUEDA
	
		int i=1;										//VARIABLE PARA CONTROL BUCLES

		int opcion;										//VARIABLE PARA SELECCIONAR SI COCHE O MOTO
		
		List<Wheel> RodesTraseres = new ArrayList<Wheel>();		//ARRAY RUEDAS TRASERAS 
		List<Wheel> RodesDavanteres = new ArrayList<Wheel>();	//ARRAY RUEDAS DELANTERAS
		
		System.out.println("--------------------- QUE DESEAS CREAR : -------------------------\n");
		System.out.println("1. Un Coche. \n");
		System.out.println("2. Una Moto. \n");
		System.out.println("Selecciona una Opcion: ( 1 - 2 )");
		System.out.println("-------------------------------------------------------------------");
		
		
		do {
			
			opcion=  Integer.parseInt(entrada.nextLine());		//RECOJO EN OPCION SI SE DESEA CREAR UN COCHE O UNA MOTO 
			
			if(opcion != 1 && opcion !=2) {				
			
				System.out.println("ERROR --- ELIGE OPCION ( 1 / 2 )");						
			}
			
		}while(opcion!=1 && opcion !=2);			//NO SALDRE HASTA QUE ELIJA MOTO O COCHE
				
				
		if(opcion==1) {			//COCHE
		
			bien=false;		//REINICIO bien
			
			do {											//BUCLE PARA INTRODUCIR MATRICULA CORRECTA
		
				System.out.println("Introdueix la matrícula del cotxe : ");		//PIDO MATRICULA COCHE
				matricula=entrada.nextLine();
				bien=ComprobarMatricula(matricula);				//LLAMO FUNCION COMPROBAR MATRICULA				
				
			}while(bien!=true);		//REPITO BUCLE DE PEDIR MATRICULA HASTA QUE CUMPLA AMBAS CONDICIONES
			
			
			System.out.println("Introdueix la marca del cotxe : ");		//PIDO MARCA DEL COCHE
			marca=entrada.nextLine();
			
			System.out.println("Introdueix el color del cotxe : ");		//PIDO COLOR DEL COCHE
			color=entrada.nextLine();
		
			Car cotxe = new Car(matricula,marca,color);					//CREO OBJETO COCHE
			
			System.out.println("------------  RUEDAS TRASERAS -------------\n");
			
			do {		//BUCLE PARA PEDIR DOS RUEDAS TRASERAS
				
				bien=false;			//INICIO VARIABLE bien
					
				System.out.println("RUEDA num. " + i + " -- MARCA  :");				//PIDO MARCA DE LA RUEDA
				marca=entrada.nextLine();
					
				do {	//BUCLE PARA CONTROLAR ENTRADA DIAMETRO CORRECTO
					
						System.out.println("RUEDA num. " + i + " -- DIAMETRO  :");	//PIDO EL DIAMETRO DE LA RUEDA
						diametre=Double.parseDouble(entrada.nextLine());
							
						bien=ComprobarDiametro(diametre);					//LLAMO FUNCION COMPROBAR DIAMETRO CORRECTO Y RECOJO EN bien
						
				}while(bien!=true);							//NO SALDRE HASTA QUE EL DIAMETRO SEA CORRECTO bien=true QUE ME DEVUELVE LA FUNCION
					
				Wheel RodeT = new Wheel(marca, diametre);			// CREO OBJETO RUEDA
				RodesTraseres.add(RodeT);							//GUARDO ARRAY RUEDAS
					
				i++;						//INCREMENTO i
				
	        }while (i<3);					//NO SALDRE HASTA CREAR DOS RUEDAS
			
			i=1;			//REINICIO i
			
			System.out.println("------------  RUEDAS DELANTERAS -------------\n");
			
			do {		//BUCLE PARA PEDIR DOS RUEDAS DELANTERAS
				
				bien=false;			//INICIO VARIABLE bien		
				
				System.out.println("RUEDA num. " + i + " -- MARCA  :");				//PIDO MARCA DE LA RUEDA
				marca=entrada.nextLine();
				
				do {	//BUCLE PARA CONTROLAR ENTRADA DIAMETRO CORRECTO
				
					System.out.println("RUEDA num. " + i + " -- DIAMETRO  :");	//PIDO EL DIAMETRO DE LA RUEDA
					diametre=Double.parseDouble(entrada.nextLine());
			
					bien=ComprobarDiametro(diametre);					//LLAMO FUNCION COMPROBAR DIAMETRO CORRECTO Y RECOJO EN bien
				
				}while(bien!=true);							//NO SALDRE HASTA QUE EL DIAMETRO SEA CORRECTO bien=true QUE ME DEVUELVE LA FUNCION
				
				Wheel RodeD = new Wheel(marca, diametre);				//CREO OBJETO RUEDA			
				RodesDavanteres.add(RodeD);;							//GUARDO ARRAY RUEDAS
					
				i++;							//INCREMENTO i
				
			}while (i<3);						//NO SALDRE HASTA CREAR DOS RUEDAS
			
			
			try {
				cotxe.addWheels(RodesDavanteres, RodesTraseres);		//AÑADO RUEDAS A COCHE ( 2 y 2 )				
				
			} catch (Exception e) {					//CONTROLO LA EXCEPCION LANZADA POR LAS CLASES INVOCADAS EN EL TRY-CATCH
				e.printStackTrace();
			}
		
			System.out.println(cotxe);				//MUESTRO OBJETO COCHE POR CONSOLA1
			
			
		}else {			//NO ELIGIO LA OPCION COCHE	POR LO QUE ES LA OPCION 2
			
			bien = false;		//REINICIO VARIABLE bien
			
			do {				//BUCLE PARA INTRODUCIR MATRICULA CORRECTA
				
				System.out.println("Introdueix la matrícula de la Moto : ");	//PIDO MATRICULA MOTO
				matricula=entrada.nextLine();
	
				bien=ComprobarMatricula(matricula);				//LLAMO FUNCION COMPROBAR MATRICULA	QUE ME DEVUELVE true o false	
													
			}while(bien!=true);		//REPITO BUCLE DE PEDIR MATRICULA HASTA QUE CUMPLA AMBAS CONDICIONES
				
			System.out.println("Introdueix la marca de la Moto : ");	//PIDO MARCA MOTO
			marca=entrada.nextLine();
			
			System.out.println("Introdueix el color de la Moto : ");	//PIDO COLOR MOTO
			color=entrada.nextLine();
			
			Bike moto = new Bike(matricula,marca,color);				//CREO OBJETO MOTO				
				
			System.out.println("------------  RUEDA TRASERA  -------------\n");
				
			bien=false;					//REINICIO VARIABLE CONTROL bien 
							
			System.out.println("-------- Marca de la RUEDA  : ");		//PIDO MARCA RUEDA TRASERA
			marca=entrada.nextLine();
					
			do {	//BUCLE PARA CONTROLAR ENTRADA DIAMETRO CORRECTO
					
				System.out.println("-------- Diametro de la RUEDA : ");		//PIDO DIAMETRO RUEDA TRASERA DENTRO BUCLE CONTROL
				diametre=Double.parseDouble(entrada.nextLine());
					
				bien=ComprobarDiametro(diametre);							//LAMO A COMPROBAR DIAMETRO Y ME DEVUELVE true o false
						
			}while(bien!=true);		//REPITO BUCLE HASTA QUE DIAMETRO INTRODUCIDO ESTE CORRECTO
					
			Wheel RodeT = new Wheel(marca, diametre);				//CREO OBJETO RUEDA
			RodesTraseres.add(RodeT);								//GUARDO EN ARRAY RUEDA
					
				
			System.out.println("------------  RUEDA DELANTERA -------------\n");
									
			System.out.println("-------- Marca de la RUEDA  : ");	//PIDO MARCA RUEDA
			marca=entrada.nextLine();
			
			bien=false;				//REINICIO VARIABLE CONTROL bien
			
			do {	//BUCLE PARA CONTROLAR ENTRADA DIAMETRO CORRECTO
					
					System.out.println("-------- Diametro de la RUEDA : ");	//PIDO DIAMETRO RUEDA DELANTERA EN BUCLE CONTROL
					diametre=Double.parseDouble(entrada.nextLine());
			
					bien=ComprobarDiametro(diametre);
						
						
			}while(bien!=true);			//REPITO BUCLE HASTA QUE DIAMETRO INTRODUCIDO ESTE CORRECTO
					
			Wheel RodeD = new Wheel(marca, diametre);			//CREO OBJETO RUEDA
			RodesDavanteres.add(RodeD);							//GUARDO EN ARRAY RUEDA
						
			
			try {
					moto.addWheels(RodesDavanteres, RodesTraseres);		//MOTOS SOLO TIENE UNA RUEDA DELANTERA Y OTRA TRASERA
			} catch (Exception e) {
					e.printStackTrace();								//PASO AMBOS ARRAY CON UN SOLO ELEMENTO PARA RESPETAR ATRIBUTO DE LA CLASE
			}
		
			System.out.println(moto);		//MUESTRO OBJETO MOTO
		}
			
	}
			
		
	//FUNCION COMPROBAR MATRICULA QUE LLAMO ANTES DE PASAR A PEDIR LOS OTROS VALORES 
	
	private static boolean ComprobarMatricula(String mat) {
			
		String matricula;	//VARIABLE PARA RECOGER PARAMETRO
		
		int iCont;			//VARIABLE QUE USO PARA CONTAR LA CANTIDAD NUMEROS EN EL EL STRING matricula
		
		boolean bien;		//VARIABLE QUE USO PARA DEVOLVER SI ES CORRECTA LA MATRICULA
		
		char caracter;		//VARIABLE QUE USO PARA RECORRER EL STRING matricula
			
		matricula=mat.toUpperCase();				    //PASO A MAYUSCULAS
		matricula=matricula.replace("-", "");			//QUITO  GUIONES			
		matricula=matricula.replace(" ","");			//QUITO ESPACIOS BLANCOS
			
		iCont=0;			//INICIO LA CANTIDAD DE NUMEROS QUE TIENE EL STRING matricula
			
		if (matricula.length() ==7) {		//COMPRUEBO QUE MATRICULA TENGA LA LONGITUD CORRECTA (B-1234-HZ  // 1234-BKZ)
				
			bien=true;		//TIENE LA LONGITUD CORRECTA					
					
			for(int j=0; j< matricula.length() ; j++) {	//RECORRO STRING matricula 
						
				caracter=matricula.charAt(j);		//SELECCIONO EL caracter DEL STRING matricula
						
				if (Character.isDigit(caracter)) {	//COMPRUEBO SI ES UN NUMERO

					iCont++;						//STRING matricula TENDRA TANTOS NUMEROS COMO INDIQUE iCont		
				}										
			}				
								
		}else {
				
			bien=false;		//EL STRING TIENE MAS O MENOS DE 8 CARACTERES
		}
			
			
		if (bien!=true || iCont!=4) {	//SI LONGITUD NO CORRECTA Y NO TIENE 4 NUMEROS MSJ DE ERROR Y VUELVO PEDIR MATRICULA
				
			System.out.println("ERROR MATRICULA INCORRECTA VUELVE A INTRODUCIRLA \n");
			bien=false;
		}
			return bien;	//DEVUELVO VARIABLE (true o false)
	}
		
		
	//FUNCION COMPROBAR DIAMETRO QUE LLAMO AL PEDIR EL VALOR ANTES DE CREAR EL OBJETO RUEDA
	
	public static boolean ComprobarDiametro(double diametre) {

		boolean bien;		//VARIABLE DONDE QUE USO PARA DEVOLVER SI FUNCION ES true O false

		if (diametre < 0.4 || diametre > 4 ) {		//VERIFICO QUE PARAMETRO diametre CUMPLA LA CONDICION
	
			System.out.println("ERROR EL DIAMETRO DEBE SER --- 0.4 > DIAMETRO < 4 ---- \n");	//MSJ ERROR EN CONSOLA
			bien=false;					//ASIGNO false A VARIABLE QUE DEVUELVE LA FUNCION
	
		}else {				//LA CONDICION ESTA DENTRO DE LO ESPERADO
				
			bien=true;		//ASIGNO true A VARIABLE A DEVOLVER
		}
		
		return bien;	//DEVUELVO VARIABLE (true o false)
	}
		
}
			
		