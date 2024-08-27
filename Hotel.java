/*
 * Title : Hotel Management System
 * Date : 06/10/2023
 * Subject : JAVA-II
 */

 /*
  * In hotel management system there are different types of rooms available. Array is used to execute check-in and
    check out process. Used concept of jdbc to store data in database. Prepared statement is pre compiled SQL 
    statement. We can get data using prepared statement by Result Set object.Result Set is used to execute query
    (fetch query results). A simple create statement is used to store rooms details in database. Prepared Statement 
    is used to store person's details in database and used to get room_info. 
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

class Hotel
{
    public static void main(String[] args) throws SQLException 
    {
        Booking b=new Booking();
        Scanner sc=new Scanner(System.in);

        //load driver
        String driverName="com.mysql.cj.jdbc.Driver";
        System.out.println("Driver loaded successfully");

        //Connection 
        String dburl="jdbc:mysql://localhost:3306/project";
        String dbuser="root";
        String dbpass="";
        Connection con=DriverManager.getConnection(dburl,dbuser,dbpass);
        if(con!=null)
        {
            System.out.println("Connection successful");
        }
        else
        {
            System.out.println("Connection not successful");
        }

        // Statement to insert rooms details
        // this process can be done by hotel management staff only

        // Statement st=con.createStatement();
        // String sql1="Insert into rooms_info(Room_type,Rent,Available_rooms) values ('Standard room',3000,10)";
        // String sql2="Insert into rooms_info(Room_type,Rent,Available_rooms) values ('Minimalist room',4500,6)";
        // String sql3="Insert into rooms_info(Room_type,Rent,Available_rooms) values ('Deluxe room',15000,5)";
        // String sql4="Insert into rooms_info(Room_type,Rent,Available_rooms) values ('Luxurious room',25000,5)";
        // int s=st.executeUpdate(sql4);
        // if(s>0)
        // {
        //     System.out.println("Rooms details are inserted");
        // }
        // else 
        // {
        //     System.out.println("details can't be inserted");
        // }
        
        //Array for booking of different rooms
        Booking sr[] = new Booking[10];
        Booking dr[] = new Booking[6];
        Booking mr[] = new Booking[5];
        Booking lr[] = new Booking[5];
        int choice;
    
    do
    { 
       System.out.println("# CHECK-IN will be only done by user # ");

        System.out.println();
        System.out.println();

        System.out.println(" \t 1. -> ROOM'S INFORMATION AND CHECK IN <- ");
        System.out.println(" \t 2. -> VIEW NEAR-BY LANDMARKS <- ");
        System.out.println(" \t 3. -> CALCULATOR <- ");
        System.out.println(" \t 4. -> CHECK-OUT <- ");
        System.out.println(" \t 5. -> VIEW HOW MANY ROOMS ALREADY BOOKED <- ");
        System.out.println(" \t 6. -> EXIT <- ");
        System.out.println();

        System.out.print("Enter the choice : ");
        choice = sc.nextInt();
        switch(choice)
        {
        case 1 : 
        b.room_info(); 
        
        System.out.println("1. Standard room");
        System.out.println("2. Minimalist room");
        System.out.println("3. Deluxe room");
        System.out.println("4. Luxury room");
        System.out.println();

        System.out.print ("Enter which room do you want : ");
        int m = sc.nextInt();

            switch(m) 
            {
                case 1: 
                boolean srb = true;
                while(srb)
                {
                    b.viewStandardRoomCount();

                    int i = 0;
                    sr[i] = new Booking();
                    sr[i].check_in();
                    i++;
                    b.count_sr++;
                    if(i > 10) 
                    {
                        srb = false;
                        System.out.println("Rooms are full");
                    }
                    break;
                }
                break;

                case 2:
                boolean mrb = true;
                while(mrb)
                {
                    b.viewMinimalistRoomCount();

                    int i = 0;
                    mr[i] = new Booking();
                    mr[i].check_in();
                    i++;
                    b.count_mr++;
                    if(i > 6) 
                    {
                        mrb = false;
                        System.out.println("\tROOMS ARE FULL");
                    }
                   
                    break;
                }
                break;

                case 3: 
                boolean drb = true;
                while(drb == true)
                {
                    b.viewDeluxeRoomCount();

                    int i = 0;
                    dr[i] = new Booking();
                    dr[i].check_in();
                    i++;
                    b.count_dr++;
                    if(i > 5) 
                    {
                        drb = false;
                        System.out.println("\tROOMS ARE FULL");
                    }
                    break;
                }
                break;

                case 4:
                boolean lrb = true;
                while(lrb == true)
                {
                    b.viewLuxuryRoomCount();
                    int i = 0;
                    lr[i] = new Booking();
                    lr[i].check_in();
                    i++;
                    b.count_lr++;
                    if(i > 5) 
                    {
                        lrb = false;
                        System.out.println("\tROOMS ARE FULL");
                    }   
                    break;
                }
                break;       
            }
            break;
            
        case 2:
        b.nearbyLocation();
        break;

        case 3:
        b.calculator();
        break;

        case 4:

        System.out.println("1. standard room");
        System.out.println("2. Minimalist room");
        System.out.println("3. Deluxe room");
        System.out.println("4. Luxury room");
        System.out.println();

        System.out.print("Which type of room are you checking out : ");
        int co = sc.nextInt();
            
            switch(co) 
            {
                case 1: 
                b.count_sr--;
                if(b.count_sr<0)
                {
                    System.out.println("ALL ROOMS ARE ALREADY EMPTY");
                }
                b.calculator();
                System.out.println();
                System.out.println("    # THANK YOU FOR THE VISIT, ENJOY YOUR JOURNEY AHEAD #");
                break;

                case 2:
                b.count_mr--;
                if(b.count_mr<0)
                {
                    System.out.println("ALL ROOMS ARE ALREADY EMPTY");
                }
                b.calculator();
                System.out.println();
                System.out.println("    # THANK YOU FOR THE VISIT, ENJOY YOUR JOURNEY AHEAD #");
                break;

                case 3:
                b.count_dr--;
                if(b.count_dr<0)
                {
                    System.out.println("ALL ROOMS ARE ALREADY EMPTY");
                }
                b.calculator();
                System.out.println();
                System.out.println("    # THANK YOU FOR THE VISIT, ENJOY YOUR JOURNEY AHEAD #");
                break;

                case 4:
                b.count_lr--;
                if(b.count_lr<0)
                {
                    System.out.println("ALL ROOMS ARE ALREADY EMPTY");
                }
                b.calculator();
                System.out.println();
                System.out.println("    # THANK YOU FOR THE VISIT, ENJOY YOUR JOURNEY AHEAD #");
                break;

                default : System.out.println("Incorrect input");
                break;

            }

        case 5: 
        System.out.println();
        b.viewStandardRoomCount();
        b.viewDeluxeRoomCount();
        b.viewMinimalistRoomCount();
        b.viewLuxuryRoomCount();
        break;
        
        case 7: 
        System.out.println("\t THANK YOU FOR VISITING");
        System.exit(0);
        break;

        default : System.out.println("Incorrect input");
        break;
      }
    }
    while(choice != 6);
  }
}

class Booking 
{
    Scanner sc=new Scanner(System.in);
        int standard_rooms = 10;
        int minimalist_rooms =6 ;
        int deluxe_rooms = 5;
        int luxury_rooms = 5;

        int count_sr = 0;
        int count_dr = 0;
        int count_mr = 0;
        int count_lr = 0;
        
    //         ------------------------------- SHOWING ROOM INFO-------------------------------

    void room_info() throws SQLException
    {

        String dburl="jdbc:mysql://localhost:3306/project";
        String dbuser="root";
        String dbpass="";
        Connection con=DriverManager.getConnection(dburl,dbuser,dbpass);

      System.out.println("---------------------------AVAILABLE ROOMS-----------------------------");
      System.out.println();
      System.out.print("Standard room Info: ");
      System.out.println(" It includes basic amenities such as a bed, a private bathroom, a desk, a chair, a wardrobe, and a telephone.");
      System.out.println();

      System.out.print("Minimalist room Info: ");
      System.out.println("It includes basic amenities with a more modern and streamlined design such as a bed, a private bathroom with basic toiletries, a desk, a chair, a wardrobe, a television, and a telephone.\n Some additional amenities such as free Wi-Fi, a mini-fridge, and a coffee make are also provided.");
      System.out.println();

      System.out.print("Deluxe room Info: ");
      System.out.println("Deluxe rooms would be typically larger than standard or minimalist providing additional facilities such as larger beds, private bathrooms with bathtubs or jacuzzi, a seating area,a safe and a balcony with additional to basi features as a work desk with a chair, a wardrobe or closet, a television, a telephone, a free wifi and a mini-fridge.");
      System.out.println();

      System.out.print("Luxury room Info : ");
      System.out.println("Luxury rooms provide the highest level of comfort such as large and luxurious bed or beds, a spacious private bathroom with high-end toiletries, a seating area with comfortable chairs or sofas, a work desk with a chair, a wardrobe or closet, a television, a telephone, a mini-fridge, and a safe.\n The additional amenities provided are balcony or terrace with a stunning view, a fireplace, a hot tub or Jacuzzi, a private pool, or a personal butler or concierge service."); 
      System.out.println();

      //  Prepared Statement to get details about rooms
      String sql5="Select * from rooms_info";
      PreparedStatement pst=con.prepareStatement(sql5);
      ResultSet rs=pst.executeQuery();
      while(rs.next())
      {
        System.out.println("Room_name               : "+rs.getString(1));
        System.out.println("Rent for one night stay : "+rs.getDouble("Rent"));
        System.out.println("Available_rooms         : "+rs.getInt(3));
        System.out.println();
      }
    }

    void nearbyLocation()
    {
    System.out.println();
    System.out.println("Near by places to visit in UDAIPUR");
    System.out.println("1.City Palace        : City palace is a wide and complex palace built over a peroid of nearly 400 years.");
    System.out.println("2.Saheliyon ki bari  : Saheliyon-ki-Bari is a major garden and a popular tourist space");
    System.out.println("3.Fateh sagar lake   : It is an artificial lake named after Maharana Fateh Singh of Udaipur and Mewar, constructed north-west of Udaipur, to the north of Lake Pichola in the 1680s");
    System.out.println("4.The monsoon palace : The Monsoon Palace, also known as the Sajjan Garh Palace, is a hilltop palatial residence in the city of Udaipur, Rajasthan in India, overlooking the Fateh Sagar Lake. ");
    System.out.println("5.Lake pichola       : Lake Pichola is an artificial fresh water lake, created in the year 1362, named after the nearby Picholi village. ");
    System.out.println();
    }
    
    //         ------------------------------- SHOWING ROOM COUNT-------------------------------

    void viewStandardRoomCount()
    {
        System.out.print("Number of Standard room(s) already booked: ");
        System.out.println(count_sr);
        System.out.println();
    }

    void viewDeluxeRoomCount()
    {
        System.out.print("Number of Deluxe room(s) already booked: ");
        System.out.println(count_dr);
        System.out.println();
    }

    void viewMinimalistRoomCount()
    {
        System.out.print("Number of Minimalist room(s) already booked: ");
        System.out.println(count_mr);
        System.out.println();
    }

    void viewLuxuryRoomCount()
    {
        System.out.print("Number of Luxury room(s) already booked: ");
        System.out.println(count_lr);
        System.out.println();
    }

    void check_in() throws SQLException
    {
        String dburl="jdbc:mysql://localhost:3306/project";
        String dbuser="root";
        String dbpass="";
        Connection con=DriverManager.getConnection(dburl,dbuser,dbpass);

        // Taking details from user to check-in
        System.out.println("# CHECK-IN will only done by user # ");
        System.out.println();

        System.out.print("Identity proof : ");
        String id = sc.nextLine();

        System.out.print("Enter Name : ");
        String name = sc.nextLine();

        System.out.print("Enter phone number : ");
        String phone_no = sc.nextLine();
        if(phone_no.length()!=10)
        {
            System.out.println("Please enter valid phone_no of 10 digits");
            phone_no=sc.nextLine();
        }

        System.out.print("Gender : ");
        String gender = sc.next();
        sc.nextLine();

        System.out.print("Enter Email id : ");
        String email_id = sc.nextLine();
                email_id = sc.nextLine();
        

        System.out.print("Enter City : ");
        String address = sc.nextLine();

        //Prepared Statement to add person info in table
        String sql="Insert into person_info(Identity,Name,Phone_no,Gender,Email_id,City) values(?,?,?,?,?,?) ";
        PreparedStatement pst=con.prepareStatement(sql);
        pst.setString(1, id);
        pst.setString(2, name);
        pst.setString(3, phone_no);
        pst.setString(4, gender);
        pst.setString(5, email_id);
        pst.setString(6, address);
        int u=pst.executeUpdate();

        if(u>0)
        {
            System.out.println("Inserted person details successfully");
        }
        else
        {
            System.out.println("information not inserted");
        }
    }

    //         -------------------------------TO CALCULATE TOTAL-------------------------------
    void calculator() 
    {

	 int eroom;
	 int edays;

     System.out.println("room types");
     System.out.println("1 : Standard room      [ONE NIGHT STAY -3000rs]");
     System.out.println("2 : Minimalist room    [ONE NIGHT STAY -4500rs]");
     System.out.println("3 : Deluxe room        [ONE NIGHT STAY -15000rs]");
     System.out.println("4 : Luxurious room     [ONE NIGHT STAY -25000rs]");

     Scanner sc=new Scanner(System.in); 
     System.out.println("enter your room type from above option");
     eroom=sc.nextInt();

    switch(eroom)
    {	
	   case 1:
	   System.out.println("enter number of days");
       edays=sc.nextInt();
	   int sum=3000*edays;
	   System.out.println("Amount you have to pay: "+sum);
	   break;

	   case 2:
	   System.out.println("enter number of days");
	   edays=sc.nextInt();
	   sum=4500*edays;
	   System.out.println("Amount you have to pay: "+sum);
	   break;

	   case 3:
	   System.out.println("enter number of days");
	   edays=sc.nextInt();
	   sum=15000*edays;
	   System.out.println("Amount you have to pay: "+sum);
	   break;

	   case 4:
	   System.out.println("enter number of days");
	   edays=sc.nextInt();
	   sum=25000*edays;
	   System.out.println("Amount you have to pay: "+sum);

       default : System.out.println("Invalid Input");
    }
   }
}