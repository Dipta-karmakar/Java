package Entity;
public class Date{
    private int day;
    private int month;
    private int year;

    //cons
    public Date(){}
    public Date(int day, int month, int year){
        this.day = day;
        this.month = month;
        this.year = year;
    }

    //setter method
    public void setDay(int day){
        this.day = day;
    }
    public void setMonth(int month){
        this.month = month;
    }
    public void setyear(int year){
        this.year = year;
    }

    //getter method
    public int getDay(){
        return this.day;
    }
    public int getMonth(){
        return this.month;
    }
    public int getyear(){
        return this.year;
    }

    public void showDate(){
        System.out.println(this.day +"/" + this.month + "/" + this.year);
    }
}