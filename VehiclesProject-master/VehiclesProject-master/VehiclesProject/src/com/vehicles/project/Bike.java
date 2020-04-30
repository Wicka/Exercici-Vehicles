package com.vehicles.project;

import java.util.List;

public class Bike extends Vehicle {

	public Bike(String plate, String brand, String color) {
		super(plate, brand, color);
	}
	public void addWheels(List<Wheel> frontWheel, List<Wheel> rearWheel) throws Exception {
		addOneWheel(frontWheel,rearWheel);
	}

	public void addOneWheel(List<Wheel> fWheel, List<Wheel> rWheel) throws Exception {
		
		if (fWheel.size() != 1 ) {			//SOLO UNA RUEDA EN ARRAY RUEDA DELANTERA
			System.out.println("Las Motos solo tienen una rueda delantera  \n");
			throw new Exception();		
		}

		if (rWheel.size() != 1 ) {			//SOLO UNA RUEDA EN ARRAY RUEDA TRASERA
			System.out.println("Las Motos solo tienen una rueda trasera  \n");
			throw new Exception();
			}

		Wheel frontWheel = fWheel.get(0);
		Wheel rearWheel = rWheel.get(0);

		if (!frontWheel.equals(rearWheel)) {
			System.out.println("Ruedas delanteras y traseras no son Iguales  \n");
			throw new Exception();
			}

		this.wheels.add(frontWheel);
		this.wheels.add(rearWheel);
	}

	@Override
	public String toString() {
		return "Moto [Matricula=" + plate + ", Marca=" + brand + ", Color=" + color + ", Ruedas de la Moto =" + wheels + "]";
	}
}
