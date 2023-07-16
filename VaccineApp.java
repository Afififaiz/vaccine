package vaccineapp;

import java.util.*;
import java.util.StringTokenizer;
import java.io.*;
import java.util.ArrayList;

public class VaccineApp {

    public static Scanner in = new Scanner(System.in); //scanner to read input type of int, double, string
    public static Scanner inline = new Scanner(System.in); //scanner to read input sequence of string
    
    public static void main(String[] args) throws Exception 
    {
        try 
        {    
            ArrayList<Vaccine> vc = new ArrayList<>(); //ArrayList declaration and creation                                  
            int ch = 0;
		do
		{
			ch = menu();
                        
                        if(ch == 1)
			{
				/*call method addNewVisitor(vc) to add and store new visitor
				 * in ArrayList object name vc
				 */
				clear();
				addNewVisitor(vc);
				pause();
				clear();
			}
                        else if(ch == 2)
			{
				/*call method sortFollowedByGenderAndName(vc) to sort visitor in 
				 * ArrayList object name vc followed by gender
				 * and visitors's name
				 */
				clear();
				sortFollowedByGenderAndName(vc);
				pause();
				clear();
			}
                        else if(ch == 3)
			{
				/*call method sortFollowedByVaccineStatus(vc) to sort visitor information in 
				 * ArrayList object name vc followed by total 
				 * and visitors's vaccination status
				 */
				clear();
				sortFollowedByVaccineStatus(vc);
				pause();
				clear();
			}
                        else if(ch == 4)
			{
				//call method searchVisitor(vc) to check whether visitor's information that had been newly added by the function addNewVisitor(vc) at the bottom of the file data is exist or not 
				clear();
				searchVisitor(vc);
				pause();
				clear();
			}
                       		
		}
		
		while(ch != 5);//program will terminate if user enter 5

		System.out.print("\n\n\n\t\t\tThank You and See You Again! ");
        }       
        catch(Exception ex) { System.err.println(ex.getMessage()); }
    }  
    
    
    //menu method
    public static int menu(){
		
        Scanner sc = new Scanner(System.in);

	System.out.println("\n\n\n\t\t\tVACCINATION STATUS APPLICATION MAIN MENU");
	System.out.println("\t\t\t~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	System.out.println("\n\t\t\t1. Add new visitor");
	System.out.println("\t\t\t2. Display visitors by gender");
	System.out.println("\t\t\t3. Display visitor vaccination statistic");
	System.out.println("\t\t\t4. Search visitors by name");
	System.out.println("\t\t\t5. Exit");
	System.out.print("\n\t\t\t>>> ");

	int ch = Integer.parseInt(sc.nextLine());

	return ch;
}
    
    //clear all text in that page
    public static void clear() { System.out.println("\f\f\f");}
    
    //pause 
    public static void pause() 
    {
        System.out.print("\n\t\t\tPress [ENTER] to continue...");
        String contStr = inline.nextLine();
    }
    
    public static void readFile(ArrayList<Vaccine> vc) throws Exception 
    {
        try 
        {
            vc.clear(); //clear the list! or remove all elements from the list!
            
            /**
            *  WRITE A PROGRAM SEGMENT THAT READS THE DATA FROM FILE NAMED data.txt
            *  For each data retrieved, an object of Vaccine will be created using normal constructor before added into the ArrayList named vc.
            */ 
           
            BufferedReader br = new BufferedReader(new FileReader("data.txt"));
            String data = br.readLine();
            
            while(data != null )
            {              
                StringTokenizer token = new StringTokenizer(data,";");
                
                //input  
                String name = token.nextToken().trim();
                String gender = token.nextToken().trim();
                int age = Integer.parseInt(token.nextToken());
                int vaccineStatus = Integer.parseInt(token.nextToken());
                
                //normal constructor
                Vaccine vaksin = new Vaccine(name, gender, age, vaccineStatus);
                vc.add(vaksin);                
                data = br.readLine();
            }

            br.close();
        }
        catch(Exception e) { System.err.println(e.getMessage());}
    }
    
    //write into file
     public static void writeFile(ArrayList<Vaccine> vc) throws Exception 
    {
        try 
        {
            /**
            *  WRITE A PROGRAM SEGMENT THAT WRITES THE DATA FROM ARRAYLIST NAMED vc INTO FILE NAMED data.txt
            */ 
           
            PrintWriter in = new PrintWriter(new FileWriter("data.txt"));
            
            for (int x=0; x<vc.size(); x++) 
            {
                Vaccine vaksin = vc.get(x);
                in.println(vaksin.toString());
            }           
            in.close();
        }
        catch(Exception e) { System.err.println(e.getMessage());}
    }

    //display all information of visitor
    public static void displayVisitor(ArrayList<Vaccine> vc) throws Exception
    {
        System.out.println("\t\t\t========================");
        System.out.println("\t\t\t|   LIST OF VISITORS   |");
        System.out.println("\t\t\t========================");
        
        try 
        {
            readFile(vc); //invoke readFile() method
            /**
            * WRITE A PROGRAM SEGMENT TO DISPLAY THE information from Vaccine IN vc
            */
           
           PrintWriter pw = new PrintWriter(new FileWriter("displayParticipant.txt"));
           
           //process
            for (int x=0; x<vc.size(); x++) 
            {
                Vaccine vaksin = vc.get(x);
                System.out.println("\t" + vaksin.toString());
                pw.println("\t" + vaksin.toString());
            }
            
            writeFile(vc); //invoke writeFile() method
        }
        catch(Exception e) {System.err.println(e.getMessage());}
    }       
   
    public static void addNewVisitor(ArrayList<Vaccine> vc) throws Exception
    {
        try 
        {
            readFile(vc); //invoke readFile() method
            displayVisitor(vc); //invoke displayVisitor() method to display all elements
            System.out.println();
            
            while (true) 
            {                
                /*
                * WRITE A PROGRAM SEGMENT TO ADD NEW VISITOR OBJECT INTO ARRAYLIST OBJECT NAMED vc.
                * This program segment prompt the user a question, whether to proceed to enter data or not, if the user press 'Y' or 'y', 
                * the program will then prompt the visitor to enter name, gender, age and the vaccination status.
                * Otherwise, the program segment will break, and return to the main menu. 
                * For each data entered, the object of Vaccine will be created using normal constructor before added into the ArrayList named vc.
                */
               
                //CHOICE 1 BEGINS HERE...
                
                System.out.print("\t\t\tAdd New Data (Y/N) ? ");
                String opt = in.next().substring(0,1);
                
                if(opt.equalsIgnoreCase("N"))
                break;
                
                System.out.println("\n\t\t\tENTER FOLLOWING INFORMATION:-");
                System.out.println();
                
                System.out.print("\n\t\t\tENTER NAME    : ");
                String name = inline.nextLine();
                
                System.out.print("\n\t\t\tENTER GENDER     :");
                String gender = inline.nextLine();
                
                System.out.print("\n\t\t\tENTER AGE   :");
                int age = in.nextInt();
                
                System.out.print("\n\t\t\tENTER VACCINATION STATUS   :");
                int vaccineStatus = in.nextInt();
                
                Vaccine vaksin = new Vaccine(name, gender, age, vaccineStatus);
                vc.add(vaksin);  
                System.out.println();
                
                //...CHOICE 1 ENDS HERE
            }
            
            writeFile(vc); //invoke writeFile() method
        }
        catch(Exception ex) { System.err.println(ex.getMessage()); }        
    }  
    
    public static void sortFollowedByGenderAndName(ArrayList <Vaccine> vc) throws Exception
    {  
        /*
        QUESTION 1
        * WRITE A PROGRAM SEGMENT TO SORT THE LIST BY Gender and Name OF Vaccine IN ASCENDING ORDER
        */
        try 
        {  
            readFile(vc); //invoke readFile() method
            PrintWriter pw = new PrintWriter(new FileWriter("sortFollowedByGender.txt"));
            System.out.println("\t\t\tVisitor's Information After sort followed by gender and name.");
            System.out.println("\t\t\t----------------------------------------------------------------\n");
            pw.println("\t\t\tvVisitor's Information After sort followed by gender and name.");
            pw.println("\t\t\t----------------------------------------------------------------\n");
            
            //ANSWER QUESTION 1 BEGINS HERE...
            //CHOICE 2 BEGINS HERE...
            for (int x=0; x<vc.size()-1; x++)
            {
                for (int y=0; y<vc.size() - (x+1); y++) 
                {
                    Vaccine genderFirst = vc.get(y);
                    Vaccine genderSecond = vc.get(y+1);
                    
                    String g1 = genderFirst.getGender().substring(0,2);
                    String g2 = genderSecond.getGender().substring(0,2);
                    
                    char gdr1 = g1.charAt(0);
                    char gdr2 = g2.charAt(0);
                    
                    //sort by gender
                    if (gdr1 > gdr2)
                    {
                        vc.set(y, genderSecond);
                        vc.set(y+1, genderFirst);
                    }
                    
                    //sort name by alphabet 
                    if (genderFirst.getName().compareTo(genderSecond.getName()) > 0)
                    {
                        vc.set(y, genderSecond);
                        vc.set(y+1, genderFirst);
                    }
                }
            }
            
            char newGender1 = 'x', newGender2 = 'x';
            for(int gender=0; gender<=2; gender++)
            {
                System.out.println("\n");
                if(gender==1)
                {
                    newGender1 = 'F';
                    newGender2 = 'f';
                    System.out.println("\t\t\tFEMALE");
                }
		else if(gender==2)
		{
		    newGender1 = 'M';
                    newGender2 = 'm';
		    System.out.println("\t\t\tMALE");
		}
		
		  for(int x=0; x<vc.size(); x++)
		  {
			Vaccine vaksin = vc.get(x);
			String g = vaksin.getGender().substring(0,2);
			char genderChar = g.charAt(0);
						
			if(newGender1 == genderChar || newGender2 == genderChar)
			{
				System.out.println(" ");
				System.out.println(vaksin.toString());
			}
	          }
	   }
            //...ANSWER QUESTION 1 ENDS HERE
            //CHOICE 2 ENDS HERE...*/
            
            writeFile(vc); //invoke writeFile() method
            System.out.println("\n");
            System.out.println("\t\t\tSorting by gender and name are completed :)");
            
        }
        catch(Exception e) {System.err.println(e.getMessage());}   
    }
    
    public static void sortFollowedByVaccineStatus(ArrayList <Vaccine> vc) throws Exception
    {  
        /*
        QUESTION 2
        * WRITE A PROGRAM SEGMENT TO SORT THE LIST BY Vaccine Status OF Vaccine IN Descending ORDER
        */
        try 
        {  
            readFile(vc); //invoke readFile() method
            PrintWriter pw = new PrintWriter(new FileWriter("sortFollowedByVaccineStatus.txt"));
            System.out.println("\t\t\tParticipant's Information After sort followed by Vaccine Status.");
            System.out.println("\t\t\t----------------------------------------------------------------\n");
            pw.println("\t\t\tParticipant's Information After sort followed by Vaccine Status.");
            pw.println("\t\t\t----------------------------------------------------------------\n");
            
            //ANSWER QUESTION 2 BEGINS HERE...
            //CHOICE 3 BEGINS HERE...
            for (int x=0; x<vc.size()-1; x++)
            {
                for (int y=0; y<vc.size() - (x+1); y++) 
                {
                    Vaccine statusVaccineFirst = vc.get(y);
                    Vaccine statusVaccineSecond = vc.get(y+1);
                  
                    int sv1 = statusVaccineFirst.getAge();
                    int sv2 = statusVaccineSecond.getAge();
                    
                    //sort by Vaccine status
                    if (sv1 > sv2)
                    {
                        vc.set(y, statusVaccineFirst);
                        vc.set(y+1, statusVaccineSecond);
                    }
                }
            }
   
            int count = 0;
            for(int status=1; status>=-1; status--)
            {
                System.out.println("\n");
                
                if(status==-1)
                {
                    System.out.println("\t\t\tREFUSE (-1)");
                    
                    for(int x=0; x<vc.size(); x++)
                    {
                        Vaccine vaksin = vc.get(x);
                        int VacStat = vaksin.getVaccineStatus();
            
                    if(status == VacStat)
                    {
                    
                        count += vaksin.countVisitorByVaccineStatus();
                        System.out.println(" ");
                        System.out.println(vaksin.toString());
                    }
                }
                System.out.println("\n\t\t\tTotal : " + count);
                count = 0;
            }
                
            else if(status==0)
            {
            System.out.println("\t\t\tNOT YET (0)");
        
                for(int x=0; x<vc.size(); x++)
                {
                    Vaccine vaksin = vc.get(x);
                    int VacStat = vaksin.getVaccineStatus();
            
                        if(status == VacStat)
                        {
              
                            count += vaksin.countVisitorByVaccineStatus();
                            System.out.println(" ");
                            System.out.println(vaksin.toString());
                        }
                }
              System.out.println("\n\t\t\tTotal : " + count);
              count = 0;
            }
    
            else if(status==1)
            {
                System.out.println("\t\t\tDONE (1)");
        
                    for(int x=0; x<vc.size(); x++)
                    {
                        Vaccine vaksin = vc.get(x);
                        int VacStat = vaksin.getVaccineStatus();
            
                        if(status == VacStat)
                        {
             
                        count += vaksin.countVisitorByVaccineStatus();
                        System.out.println(" ");
                        System.out.println(vaksin.toString());
                        }
                    }
                    System.out.println("\n\t\t\tTotal : " + count);
                    count = 0;
            }
     }
            //...ANSWER QUESTION 2 ENDS HERE
            //CHOICE 3 ENDS HERE...*/
            
            writeFile(vc); //invoke writeFile() method
            System.out.println("\n");
            System.out.println("\t\t\tCOUNT, SORT and DISPLAY the number of visitors by vaccination status (in descending order) are completed :)");
            
        }
        catch(Exception e) {System.err.println(e.getMessage());} 
    }
    
    public static void searchVisitor(ArrayList <Vaccine> vc) throws Exception
    {  
        try
        {
            readFile(vc); //invoke readFile() method
            displayVisitor(vc);//invoke displayVisitor() method to display all elements
            
            //QUESTION 3 BEGINS HERE...
            //CHOICE 4 BEGINS HERE...
            System.out.print("\n\t\t\tENTER NAME VISITOR (Make sure first alphabet each of word in capital letter) : "); //key value to be search
            String findName = inline.nextLine(); //key value to be search
            
            /*** 
            QUESTION 3
            * WRITE A PROGRAM SEGMENT THAT PERFORM THE BINARY SEARCH OF THE vaccine IN THE ARRAYLIST NAMED vc.
            * If the key value is found, the program will display the information of the first product found in the list, otherwise, display findName " is not found.."
            * The program should also display the information of all participant that have visitor have similiar name with key value.
            */
            
            boolean found = false;//initialise the status of found with false
            
            for(int find=0; find<vc.size(); find++)
            {
                Vaccine vaksin = vc.get(find);
                
                if(vaksin.getName().equalsIgnoreCase(findName))
                {
                    found = true;
                    System.out.println("\n\t\t\t" + findName + " is found. ");
                    System.out.println("\n" + vaksin.toString());
                }
                
                else
                {
                    found = false;
                }
            }   
            
            if(found == false)
            {
                System.out.println("\n\t\t\tVisitor that have name similar with " + findName + " (If any):-");
                System.out.println("\n");
                
                for(int find=0; find<vc.size(); find++)
                {
                    Vaccine vaksin = vc.get(find);
                
                    if(vaksin.getName().contains(findName))
                    {
                        System.out.println(vaksin.toString());
                      
                    }
                }
            }
                
            //QUESTION 3 ENDS HERE...
            //CHOICE 4 ENDS HERE...    
                
            writeFile(vc); //invoke writeFile() method
        }
        catch(Exception e) { System.err.println(e.getMessage()); }         
    }
}

