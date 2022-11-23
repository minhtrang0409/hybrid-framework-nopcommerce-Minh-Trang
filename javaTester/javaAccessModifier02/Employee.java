package javaAccessModifier02;

import javaAccessModifier01.Car;

public class Employee extends Car {
	public static void main (String[] args) {
		Car car = new Car();
		
//		System.out.println(carName);
//		viewCar();
		
//		System.out.println(carColor);
//		viewCarColor();
		Employee emp = new Employee();
		emp.checkAccess();
	}
	public void checkAccess() {
		System.out.println(carSpeed);
		viewCarSpeed();
		
		System.out.println(carCountry);
		viewCarCountry();
}
}