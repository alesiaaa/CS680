package hw3_d_2;

public class OutStateStudent extends StudentStatus{

	public OutStateStudent (float t){
		super(tuition = t);
	}
	
	public float getTuition(){
		return StudentStatus.tuition;
	}
	
	
}
