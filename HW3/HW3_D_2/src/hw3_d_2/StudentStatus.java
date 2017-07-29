package hw3_d_2;

class StudentStatus {

	protected static float tuition;
	
	public StudentStatus (float t){
		StudentStatus.tuition = t;
	}

	public float getTuition(){
		return tuition;
	}
	
	
	public static void main(String args[]){
		
		System.out.println("HW3, Design 2 Test");
		System.out.println("by: Alesia Razumova\n");
		
		Student s1 = new Student( new InStateStudent(1000), "John Smith");
		s1.getTuition();
		
		System.out.println("New In-State Student");
		System.out.println("Name: \t"+ s1.getName());
		System.out.println("Tuition: \t$"+ s1.getTuition());
		System.out.println(" ");
		
		Student s2 = new Student( new OutStateStudent(4000), "Sally Sue");
		s2.getTuition();
		
		System.out.println("New Out of State Student");
		System.out.println("Name: \t"+ s2.getName());
		System.out.println("Tuition: \t$"+ s2.getTuition());
		System.out.println(" ");
		
		Student s3 = new Student( new IntlStudent(7000), "Randy Wells");
		s3.getTuition();
		
		System.out.println("New International Student");
		System.out.println("Name: \t"+ s3.getName());
		System.out.println("Tuition: \t$"+ s3.getTuition());
		System.out.println(" ");
		
	}
	
	
}
