package Entity;
public abstract class Person{
        private String name;
        private int age;
        private String nation;
        private double salary;
        private String type;
        private Date joiningDate;
        private double agreement;
        private int id;
        
        //constructor
        public Person(){}
        public Person(String name,int age,String nation,double salary,String type,Date joiningDate,double agreement, int id){
        this.name=name;
        this.age=age;
        this.nation=nation;
        this.salary=salary;
        this.type=type;
        this.joiningDate=joiningDate;
        this.agreement=agreement;
        this.id=id;
        }
        
        //set method
        public void setName(String name){
            this.name=name;
        }
        public void setAge(int age){
            this.age=age;
        }
        public void setNation(String nation){
            this.nation=nation;
        }
        public void setSalary(double salary){
            this.salary=salary;
        }
        public void setType(String type){
            this.type=type;
        }
        public void setJoiningDate(Date joiningDate){
            this.joiningDate=joiningDate;
        }
        public void setAgreement(double agreement){
            this.agreement=agreement;
        }
        public void setId(int id){
            this.id=id;
        }
        
        //get method
        public String getName(){
            return name;
        }
        public int getAge(){
            return age;
        }
        public String getNation(){
            return nation;
        }
        public double getSalary(){
            return salary;
        }
        public String getType(){
            return type;
        }
        public Date getJoiningDate(){
            return joiningDate;
        }
        public double getAgreement(){
            return agreement;
        }
        public int getId(){
            return this.id;
        }
        
        //show info
        public abstract void showInfo();
    }