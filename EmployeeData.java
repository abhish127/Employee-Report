import java.text.NumberFormat;
import java.util.ArrayList;

public class EmployeeData {
    private String employeeName;
    private char employeeClass;
    public boolean bonus;

    public EmployeeData(){
    }

    public void setEmployeeName(String employeeName){
        this.employeeName = employeeName;
    }

    public String getEmployeeName(){
        return this.employeeName;
    }

    public void setEmployeeClass(char employeeClass){
        this.employeeClass = employeeClass;
    }

    public char getEmployeeClass() {
        return employeeClass;
    }
    public void setBonus(boolean bonus){
        this.bonus = bonus;
    }

    public boolean getBonus(){
        return bonus;
    }

    public static double computeSalaryForSalariedEmployee(SalariedEmployee anEmployee){
        double weeklySalary = anEmployee.getMonthlyRate()/4;
        if (anEmployee.getBonus()){
            weeklySalary = weeklySalary*1.1;
        }
        return weeklySalary;
    }

    public static double computeSalaryForHourlyEmployee(HourlyEmployee anEmployee){
        double weeklySalary;
        if (anEmployee.getHoursWeek() <= 40){
            weeklySalary = anEmployee.getHourlyRate()*anEmployee.getHoursWeek();
        } else {
            weeklySalary = (40 * anEmployee.getHourlyRate() + (anEmployee.getHoursWeek() - 40) * 2 * anEmployee.getHourlyRate());
        }
        return weeklySalary;
    }

    public static double computeSalaryForCommissionedEmployee(CommissionedEmployee anEmployee){
        double weeklySalary = anEmployee.getSales()*0.2;
        return weeklySalary;
    }

    public static String formatSalaried(SalariedEmployee anEmployee, double weeklySalary){
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        String listItem = anEmployee.getEmployeeName() + "\t\t   Salaried \t\t\t\t\t\t\t   " + formatter.format(weeklySalary);
        if (anEmployee.getBonus()){
            listItem = listItem + "*";
        }
        return listItem;
    }
    public static String formatHourly(HourlyEmployee anEmployee, double weeklySalary){
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        String listItem = anEmployee.getEmployeeName() + "\t    Hourly   " + anEmployee.getHoursWeek() + "\t\t\t\t   " + formatter.format(anEmployee.getHourlyRate()) + "\t   " + formatter.format(weeklySalary);
        return listItem;
    }

    public static String formatCommissioned(CommissionedEmployee anEmployee, double weeklySalary){
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        String listItem = anEmployee.getEmployeeName() + "\t Commissioned  \t   " + formatter.format(anEmployee.getSales()) + " \t\t\t   " + formatter.format(weeklySalary);
        return listItem;
    }

    static double total = 0;

    public static double getTotal(ArrayList<Double> weeklyRates) {
        for (Double d : weeklyRates) {
            total += d;
        }
        return total;
    }

    public static String formatTotal(double total) {
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        String totalLine = "TOTAL: " + formatter.format(total);
        return totalLine;
    }
}