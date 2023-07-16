
package vaccineapp;


public class Vaccine {
    
     //data member
    private String name;
    private String gender;
    private int age;
    private int vaccineStatus;
    
    //normal constructor
    public Vaccine(String name, String gender, int age, int vaccineStatus) {
        
        this.name = name;
        this.gender = gender ;
        this.age = age;
        this.vaccineStatus = vaccineStatus;
    }
    
    //mutatotrs
    public void setName(String name) { 
        
        this.name = name;
    }
    
    public void setGender(String gender) { 
        
        this.gender = gender;
    }
    
    public void setAge(int age) { 
        
        this.age = age;
    }
    
    public void setVaccineStatus(int vaccineStatus) { 
        
        this.vaccineStatus = vaccineStatus;
    }
    
    
    //accessor
    public String getName() { 
        
        return name;
    }
    
    public String getGender() { 
        
        return gender;
    }
    
    public int getAge() { 
        
        return age;
    }
    
    public int getVaccineStatus() { 
        
        return vaccineStatus;
    }
    
   public int countVisitorByVaccineStatus()
    {
        int count = 0;
        
        if(getVaccineStatus() == 1)
        {
            count++;
        }
        
        else if(getVaccineStatus() == 0)
        {
            count++;
        }
        
        if(getVaccineStatus() == -1)
        {
            count++;
        }
        
        return count;
    }
    
    //printer
    public String toString() 
    {
        return ("\t\t\t" + name + ";" + gender + ";" + age + ";" + vaccineStatus);
    }
}
