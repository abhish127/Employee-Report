public class HourlyEmployee extends EmployeeData{
    private int hoursWeek;
    private double hourlyRate;

    public HourlyEmployee(){
    }

    public void setHoursWeek(int hoursWeek) {
        this.hoursWeek = hoursWeek;
    }

    public int getHoursWeek() {
        return hoursWeek;
    }

    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }
}
