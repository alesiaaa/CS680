package hw3_d_2;

public class IntlStudent extends StudentStatus{
	
	public IntlStudent (float t){
		super(tuition = t);
	}
	
	public float getTuition(){
		return StudentStatus.tuition;
	}

}
