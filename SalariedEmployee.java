public class SalariedEmployee extends EmployeeData{
    private double monthlyRate;
    private boolean bonus;

    public SalariedEmployee(){
    }

    public void setMonthlyRate(double monthlyRate) {
        this.monthlyRate = monthlyRate;
    }

    public double getMonthlyRate() {
        return monthlyRate;
    }

    public void setBonus(boolean bonus){
        this.bonus = bonus;
    }

    public boolean getBonus(){
        return bonus;
    }

}
