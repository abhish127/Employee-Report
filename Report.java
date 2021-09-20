import java.util.*;

public class Report {
    private ArrayList<String> employees;
    private ArrayList<Double> weeklyRates;
    private boolean employeeBonus;

    public Report(){
        employees = new ArrayList<>();
        weeklyRates = new ArrayList<>();
        employeeBonus = false;
    }

    public boolean isTypeCorrect(double type){
        if (type == 1 || type == 2 || type == 3){
            return true;
        }
        else{
            return false;
        }
    }

    public boolean isBonusCorrect(double bonus){
        if (bonus == 1 || bonus == 2 ) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isNameNotEmpty(String name){
        if (name.length() < 1){
            return false;
        } else
            return true;
    }

    public void addReportLineSalaried(SalariedEmployee anEmployee){
        String s = EmployeeData.formatSalaried(anEmployee, SalariedEmployee.computeSalaryForSalariedEmployee(anEmployee));
        this.employees.add(s);
        this.weeklyRates.add(SalariedEmployee.computeSalaryForSalariedEmployee(anEmployee));
    }
    public void addReportLineHourly(HourlyEmployee anEmployee){
        String s = EmployeeData.formatHourly(anEmployee, HourlyEmployee.computeSalaryForHourlyEmployee(anEmployee));
        this.employees.add(s);
        this.weeklyRates.add(HourlyEmployee.computeSalaryForHourlyEmployee(anEmployee));
    }

    public void addReportLineCommissioned(CommissionedEmployee anEmployee){
        String s = EmployeeData.formatCommissioned(anEmployee, CommissionedEmployee.computeSalaryForCommissionedEmployee(anEmployee));
        this.employees.add(s);
        this.weeklyRates.add(CommissionedEmployee.computeSalaryForCommissionedEmployee(anEmployee));
    }

    public void print(Report report){
        System.out.println("Name \t\t\t\tClass \tHours \tSales \t\tRate \t  Weekly Pay");
        System.out.println("==============================================================================");
        for (String s : report.employees) {
            System.out.println(s);
        }
        System.out.println("==============================================================================");

        System.out.println(EmployeeData.formatTotal(EmployeeData.getTotal(report.weeklyRates)));
        if (report.employeeBonus){
            System.out.println("*A 10% bonus is awarded.");
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Report report = new Report();

        System.out.println("Welcome to the Weekly Payment Report.");
        System.out.println("How many employees do you want to enter information about?");
        int number = in.nextInt();

        for (int i = 1; i <= number; i++){
            System.out.println("Enter the name of Employee #" + i+":");
            String name = in.nextLine();
            while (!report.isNameNotEmpty(name)){
                name = in.nextLine();
            }
            System.out.println("Enter this employee's class: (1 = salaried, 2 = hourly, 3 = commissioned)");
            double type = in.nextDouble();

            while (!report.isTypeCorrect(type)){
                System.out.println("That is not a valid type. Please try again: (1 - salaried, 2 - hourly, 3 - commissioned)");
                type = in.nextDouble();
            }

            if (type == 1){
                SalariedEmployee anEmployee = new SalariedEmployee();
                anEmployee.setEmployeeName(name);
                anEmployee.setEmployeeClass('1');
                System.out.println("Enter this employee's monthly salary:");
                double monthlyRate = in.nextDouble();
                anEmployee.setMonthlyRate(monthlyRate);
                System.out.println("Is this employee eligible for a 10% bonus? (1 = Yes, 2 = No)");
                double bonus = in.nextDouble();
                while (!report.isBonusCorrect(bonus)){
                    bonus = in.nextDouble();
                }
                if (bonus == 1){
                    anEmployee.setBonus(true);
                    report.employeeBonus = true;
                } else {
                    anEmployee.setBonus(false);
                }
                report.addReportLineSalaried(anEmployee);
            }

            else if (type == 2){
                HourlyEmployee anEmployee = new HourlyEmployee();
                anEmployee.setEmployeeName(name);
                anEmployee.setEmployeeClass('2');
                System.out.println("Enter this employee's number of worked hours for the week:");
                int hoursWeek = in.nextInt();
                anEmployee.setHoursWeek(hoursWeek);
                System.out.println("Enter this employee's hourly pay rate:");
                double hourlyRate = in.nextDouble();
                anEmployee.setHourlyRate(hourlyRate);

                report.addReportLineHourly(anEmployee);
            }

            else if (type == 3){
                CommissionedEmployee anEmployee = new CommissionedEmployee();
                anEmployee.setEmployeeName(name);
                anEmployee.setEmployeeClass('3');
                System.out.println("Enter this week's sales:");
                double sales = in.nextDouble();
                anEmployee.setSales(sales);
                report.addReportLineCommissioned(anEmployee);
            }
            else {}
        }
        report.print(report);
    }
}
