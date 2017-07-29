package hw3_d_2;
class Student {
		
		private String name;
		private StudentStatus status;
		
		
		public Student (StudentStatus status, String name){
			this.name = name;
			this.status = status;
		}
		
		public float getTuition(){
			return status.getTuition();
		}
		
		public String getName(){
			return name;
		}

	
}
