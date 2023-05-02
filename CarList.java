public class CarList {

	public static void main(String[] args) 
	{
		Car car1 = new Car();
		car1.make = "Toyota";
		car1.model = "Corolla";
		car1.year = 2015;
		car1.colour = "silver";
		car1.odometer = 158942;
		car1.convertible = false;
		
		Car car2 = new Car();
		car2.make = "Tesla";
		car2.model = "Model 3";
		car2.year = 2020;
		car2.colour = "red";
		car2.odometer = 563245;
		car2.convertible = false;
		
		Car car3 = new Car();
		car3.make = "Audi";
		car3.model = "TT Roadster";
		car3.year = 2023;
		car3.colour = "white";
		car3.odometer = 5620;
		car3.convertible = true;
		
		
		System.out.println(car1.make);
		System.out.println(car1.model);
		System.out.println(car3.convertible);
		System.out.println(car2.odometer + " Km");
	}

}
