public class ClassMaster {

	public static void main(String[] args)
	{
		Student person = new Student ();//object
		person.firstname = "John";
		person.lastname = "Son";
		person.alive = true;
		person.age = 69;
		person.major = "Jam Making";
		person.score = 3.8;
		
		Student person2 = new Student ();//object
		person2.firstname = "Baba";
		person2.lastname = "Cat";
		person2.alive = false;
		person2.age = 42;
		person2.major = "Camping";
		person2.score = 1.1;
		
		System.out.println(person.firstname);
		System.out.println(person.lastname);
		System.out.println(person.alive);
		System.out.println(person.age);
		System.out.println(person.major);
		System.out.println(person.score);
		
		System.out.println(person2.firstname);
		System.out.println(person2.lastname);
		System.out.println(person2.alive);
		System.out.println(person2.age);
		System.out.println(person2.major);
		System.out.println(person2.score);
		}
	}
