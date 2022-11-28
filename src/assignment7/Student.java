package assignment7;

public class Student {
	private String FirstName;
	private String LastName;
	private int StudentID;
	private int AttemptedCredits;
	private int PassingCredits;
	private double TotalGP;
	private double BearBucksBalance;
	
	/**
	 * Constructor Method for student Class
	 * @param initFirstName
	 * @param initLastName
	 * @param initStudentID
	 */
	public Student(String initFirstName, String initLastName, int initStudentID) {
		FirstName = initFirstName;
		LastName = initLastName;
		StudentID = initStudentID;
		PassingCredits = 0;
		AttemptedCredits = 0;
		TotalGP = 0.0;
	}
	
	/**
	 * Accessor Method for FullName
	 * @return
	 * FullName: the concatenation of FirstName and LastName
	 */
	public String getFullName() { 

		String FullName;
		FullName = FirstName + " " + LastName;
		return FullName;
	}
	
	/**
	 * Accessor Method for Student ID
	 * @return StudentID
	 */
	public int getId() { 
		return StudentID;
	}
	
	/**
	 * Mutator Method for PassingCredits, AttemptedCredits, TotalGP
	 * @param grade
	 * @param credits
	 * If grade >= 1.7, count as passing
	 */
	public void submitGrade(double grade, int credits) { //Parameter: grade and credits, if grade is greater than or equal to 1.7, count as Passing
		if (grade >= 1.7) {
			PassingCredits += credits;
			AttemptedCredits += credits;
			TotalGP += grade * credits;
		} else {
			AttemptedCredits += credits;
			TotalGP += grade * credits;
		}
	}
	
	
	
	/**
	 * Accessor Method for AttemptedCredits
	 * @return
	 * AttemptedCredits
	 */
	public int getTotalAttemptedCredits() { 
		return AttemptedCredits;
	}
	
	/**
	 * Accessor Method for PassingCredits
	 * @return
	 * PassingCredits
	 */
	public int getTotalPassingCredits() {  
		return PassingCredits;
		
	}
	
	/**
	 * Calculating the GPA = TotalGP/AttemptedCredits
	 * @return GPA 
	 */
	public double calculateGradePointAverage() { 
		return TotalGP/(double) AttemptedCredits;
	}
	
	/**
	 * Return the class standing of a student according to the totalPassingCredits
	 * @return
	 * the String representing each ClassStanding 
	 */
	public String getClassStanding() {
		if (this.getTotalPassingCredits()<30) {
			return "First Year";
		} else if (this.getTotalPassingCredits()<60) {
			return "Sophomore";
		} else if (this.getTotalPassingCredits()<90) {
			return "Junior";
		} else {
			return "Senior";
		}
	}
	
	/**
	 * 
	 * @return boolean Value if the student is eligible for PhiBetaKappa
	 */
	public boolean isEligibleForPhiBetaKappa() { // Parameter: Passing credits and GPA, return eligibility for PhiBetaKappa
		if ((this.getTotalPassingCredits()>=98 && this.calculateGradePointAverage()>=3.60) || (this.getTotalPassingCredits()>=75 && this.calculateGradePointAverage()>=3.80)){
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Mutator Method for BearBucksBalance, added by the param
	 * @param amount
	 */
	public void depositBearBucks(double amount) { // Setter method for BearBuckBalances
		BearBucksBalance += amount;
	}
	
	/**
	 * Mutator Method for BearBucksBalance, reduced by the param
	 * @param amount
	 */
	public void deductBearBucks(double amount) {
		BearBucksBalance -= amount;
	}
	
	/**
	 * Accessor Method for BearBucksBalance
	 * @return BearBucksBalance
	 */
	public double getBearBucksBalance() {
		return BearBucksBalance;
		
	}
	
	/**
	 * 
	 * @return the BearBuckBalance after being cashed out. 
	 */
	public double cashOutBearBucks() { 
		if (BearBucksBalance <= 10.0) {
			BearBucksBalance = 0.0;
			return 0.0;
		} else {
			double returnBearBucksBalance = BearBucksBalance - 10.0;
			BearBucksBalance = 0.0;
			return returnBearBucksBalance;
		}
	}
	
	/**
	 * 
	 * @param firstName
	 * @param other
	 * @param isHyphenated
	 * @param id
	 * @return a new Student Object, with given first name, 
	 */
	public Student createLegacy(String firstName, Student other, boolean isHyphenated, int id) { // Parameter first name of the first parent, the LastNames of the parents, (depends on if hyphenated), set the remaining balance accordingly
		String ChildfirstName = firstName;
		String ChildLastName;
		if (isHyphenated) {
			ChildLastName = this.LastName + "-" +other.LastName;
			
		} else {
			ChildLastName = this.LastName;
		}
		Student child = new Student(ChildfirstName, ChildLastName, this.StudentID+other.StudentID);
		child.BearBucksBalance = this.cashOutBearBucks() + other.cashOutBearBucks();
		return child;
	}
	
	/**
	 * @return the String of the Student's full name and ID
	 */
	public String toString() { 
		return FirstName + " " + LastName +" " + this.StudentID;
	}
	
}
