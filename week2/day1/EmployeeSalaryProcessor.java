
public class EmployeeSalaryProcessor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		process(101, "Rahul", "60000", "20", "true");
	}
	
	public static void process(int id, String name, String basicStr, String bonusStr, String activeStr) {
        try {
            Double basic = Double.parseDouble(basicStr.trim());
            Double bonusPct = Double.parseDouble(bonusStr.trim());
            Integer empId = id;
            Boolean active = Boolean.valueOf(activeStr.trim());
            double bonus = basic * (bonusPct / 100.0);
            double finalSal = basic + bonus;
            String upper = name.toUpperCase();
            String rev = new StringBuilder(name).reverse().toString();
            String alias = upper, copy = new String(upper);

            System.out.println("Employee ID: " + empId);
            System.out.println("Employee Name: " + upper);
            System.out.println("Basic Salary: " + basic);
            System.out.println("Bonus: " + bonus);
            System.out.println("Final Salary: " + finalSal);
            System.out.println("Active: " + active);
            System.out.println("Reversed Name: " + rev);
            System.out.println("Salary above 75000: " + (finalSal > 75000 ? "Yes" : "No"));
            System.out.println("Same ref: " + (alias == upper) + ", New obj: " + (copy != upper));
        } catch (NumberFormatException e) {
            System.out.println("Invalid numeric input: " + e.getMessage());
        }
    }

}
