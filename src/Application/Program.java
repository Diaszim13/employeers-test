package Application;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Employee;
import entities.OutsourceEmployee;
public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<Employee> list = new ArrayList<>();
		
		System.out.print("Enter the number of emplyees: ");
		int n = sc.nextInt();
		
		for(int i=1; i<n +1; i++) {
			System.out.println("Employee " + i + " data: ");
			System.out.print("Outsourced?: ");
			char ch = sc.next().charAt(0);
			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Hours: ");
			int hours = sc.nextInt();
			System.out.print("value per hour: ");
			double valueperhour = sc.nextDouble();
			
			if(ch == 'y' || ch == 'Y') {
				System.out.print("additional charge: ");
				double additionalCharge = sc.nextDouble();
				Employee emp = new OutsourceEmployee(name,hours, valueperhour, additionalCharge);
				list.add(emp);
			}else if(ch == 'n' || ch == 'N') {
				Employee emp = new Employee(name, hours, valueperhour);
				list.add(emp);
			}else {
				System.out.println("not suported response!");
			}
		}
		
		System.out.println();
		System.out.println("Payments: ");
		for(Employee emp : list) {
			System.out.println(emp.getName() + "- U$ " + String.format("%.2f", emp.payment()));
		}
		
		sc.close();
		
		
			}

}
