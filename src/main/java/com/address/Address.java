package com.address;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Address{
    private static ArrayList<Contact> list = new ArrayList<Contact>();

    // Add contact details in AddressBookContact ::
    public void AddContactsDetails() {
        Scanner userInput = new Scanner(System.in);
        System.out.println("Enter the First Name => ");
        String firstName = userInput.nextLine();
        System.out.println("Enter the Last Name => ");
        String lastName = userInput.nextLine();
        System.out.println("Enter the Address => ");
        String address = userInput.nextLine();
        System.out.println("Enter the City => ");
        String city = userInput.nextLine();
        System.out.println("Enter the State => ");
        String state = userInput.nextLine();
        System.out.println("Enter the Zip Code => ");
        int zip = userInput.nextInt();
        System.out.println("Enter the Phone Number => ");
        long phoneNumber = userInput.nextLong();
        System.out.println("Enter the Email => ");
        String email = userInput.nextLine();
        email = userInput.nextLine();
        Contact details = new Contact(firstName, lastName, address, city, state, zip, phoneNumber,
                email);
        list.add(details);
        details.display();
    }
    private void IO_File() throws IOException {
        FileWriter csvWriter = new FileWriter("addressBook.csv");
        csvWriter.append("firstName");
        csvWriter.append(",");
        csvWriter.append("lastName");
        csvWriter.append(",");
        csvWriter.append("address");
        csvWriter.append(",");
        csvWriter.append("city");
        csvWriter.append(",");
        csvWriter.append("state");
        csvWriter.append(",");
        csvWriter.append("Zip Code");
        csvWriter.append(",");
        csvWriter.append("Phone no");
        csvWriter.append(",");
        csvWriter.append("email-ID");
        csvWriter.append("\n");
        for (Contact rowData : list) {
            csvWriter.append(String.join(",",
                    rowData.getFirstName()
                            + "," + rowData.getLastName()
                            + "," + rowData.getAddress()
                            + "," + rowData.getCity()
                            + "," + rowData.getState()
                            + "," + rowData.getZip()
                            + "," + rowData.getPhoneNumber()
                            + "," + rowData.getEmail()));
            csvWriter.append("\n");
        }

        csvWriter.flush();
        csvWriter.close();
    }

    public static void main(String[] args) {
        Address a1=new Address();
        a1.AddContactsDetails();

        Address m=new Address();
        try {
            m.IO_File();
        } catch (IOException e) {

            e.printStackTrace();
        }
        a1.AddContactsDetails();


        File file = new File("C:\\MY STORAGE FILESSSSSSSSSSSSSSSSS\\eclippsesee\\Day28AddressBookSystem"); //initialize File object and passing path as argument
        boolean result;
        try
        {
            result = file.createNewFile();  //creates a new file
            if(result)      // test if successfully created a new file
            {
                System.out.println("file created "+file.getCanonicalPath()); //returns the path string
            }
            else
            {
                System.out.println("File already exist at location: "+file.getCanonicalPath());
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();    //prints exception if any
        }
    }



    }

