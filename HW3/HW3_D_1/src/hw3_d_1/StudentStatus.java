package hw3_d_1;

public enum StudentStatus{
	
	INSTATE{
		@Override 
		public float getTuition() {return 1000;}
		},
		
	OUTSTATE{
		@Override 
		public float getTuition() {return 2000;}
		},
	
	INTL{
		@Override 
		public float getTuition() {return 4000;}
	};

	public float getTuition() {
		return 0;
	}

		
}
