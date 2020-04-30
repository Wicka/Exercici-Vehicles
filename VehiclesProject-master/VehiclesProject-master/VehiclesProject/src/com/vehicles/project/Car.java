package com.vehicles.project;

import java.util.List;

public class Car extends Vehicle {

	public Car(String plate, String brand, String color) {
		super(plate, brand, color);
	}

	public void addWheels(List<Wheel> frontWheels, List<Wheel> backWheels) throws Exception {
		addTwoWheels(frontWheels);
		addTwoWheels(backWheels);
	}

	public void addTwoWheels(List<Wheel> wheels) throws Exception {
		
		if (wheels.size() != 2) {
			System.out.println("\n Los coches tienen DOS ruedas delanteras y DOS ruedas traseras \n");
			throw new Exception();
			}

		Wheel rightWheel = wheels.get(0);
		Wheel leftWheel = wheels.get(1);

		if (!rightWheel.equals(leftWheel)) {
			System.out.println("\n La rueda derecha y la rueda izquierda deben ser iguales \n");
			throw new Exception();
			}

		this.wheels.add(leftWheel);
		this.wheels.add(rightWheel);
	}

	@Override
	public String toString() {
		return "Coche [Matricula=" + plate + ", Marca=" + brand + ", Color=" + color + ", Ruedas del Coche =" + wheels + "]";

	}

}
