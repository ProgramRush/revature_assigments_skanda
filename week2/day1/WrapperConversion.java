
public class WrapperConversion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String age = "25";
		String salary = "45000.75";
		String active = "true";
		
		Integer ageObj = Integer.valueOf(age);
		Double salaryObj = Double.valueOf(salary);
        Boolean activeObj = Boolean.valueOf(active);
		
        Double incrementedSalaryObj = salaryObj * 1.10;
        
        System.out.println("Age: " + ageObj + " | Type: " + ageObj.getClass().getSimpleName());
        System.out.println("Original Salary: " + salaryObj + " | Type: " + salaryObj.getClass().getSimpleName());
        System.out.println("Active: " + activeObj + " | Type: " + activeObj.getClass().getSimpleName());
        System.out.println("Salary (+10%): " + incrementedSalaryObj + " | Type: " + incrementedSalaryObj.getClass().getSimpleName());
		
	}

}
