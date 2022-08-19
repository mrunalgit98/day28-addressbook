package com.address;


import com.google.gson.Gson;
import net.projectmonkey.object.mapper.ObjectMapper;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;


public class Address{
    private static ArrayList<Contact> list = new ArrayList<Contact>();


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

    public void write() throws IOException {
        Path file= Paths.get("h1.json");
        Gson gson=new Gson();
        String json=gson.toJson(list);
        FileWriter writer=new FileWriter(String.valueOf(file));
        writer.write(json);
        writer.close();
    }

    public void read(){
        ArrayList<Contact>con=null;
        Path filepath=Paths.get("h1.json");
        try (Reader reader = Files.newBufferedReader(filepath);){
            Gson gson=new Gson();
            con=new ArrayList<Contact>(Arrays.asList(gson.fromJson(reader,Contact[].class)));
      for (Contact c1:list){
          System.out.println("Firstname " +c1.getFirstName());
      }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws IOException {
    Address n=new Address();
n.AddContactsDetails();
        n.write();
n.read();


    }



}
