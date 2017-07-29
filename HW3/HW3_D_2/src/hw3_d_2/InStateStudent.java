package hw3_d_2;

public class InStateStudent extends StudentStatus{

	public InStateStudent (float t){
		super(tuition = t);
	}
	
	public float getTuition(){
		return StudentStatus.tuition;
	}
	
}
