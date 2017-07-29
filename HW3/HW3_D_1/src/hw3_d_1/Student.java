package hw3_d_1;

class Student {
	
	private float tuition;
	private String name;
	private StudentStatus status;
	
	
	public Student (StudentStatus status, String name){
		this.status = status;
		this.name = name;
	}
	
	public float getTuition(){
		tuition = status.getTuition();
		return tuition;
	}
	
	public String getName(){
		return name;
	}

	public static void main(String args[]){
		
		System.out.println("HW3, Design 1 Test");
		System.out.println("by: Alesia Razumova\n");
		
		Student s1 =
				new Student(StudentStatus.INSTATE,
							"John Smith");
				s1.getTuition();
				
				System.out.println("New In-State Student");
				System.out.println("Name: \t"+ s1.getName());
				System.out.println("Tuition: \t$"+ s1.getTuition());
				System.out.println(" ");
				
		Student s2 =
				new Student(StudentStatus.INTL,
						"Julie Jones");
				s2.getTuition();		
				
				System.out.println("New International Student");
				System.out.println("Name: \t"+ s2.getName());
				System.out.println("Tuition: \t$"+ s2.getTuition());
				System.out.println(" ");
				
		Student s3 =
				new Student(StudentStatus.OUTSTATE,
							"Kyle Spears");
				s3.getTuition();
				
				System.out.println("New Out of State Student");
				System.out.println("Name: \t"+ s3.getName());
				System.out.println("Tuition: \t$"+ s3.getTuition());
				System.out.println(" ");
				
				
				
				
	}

}