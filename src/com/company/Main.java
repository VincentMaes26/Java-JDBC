package com.company;

import com.company.dal.DALConnection;
import com.company.dal.DALPerson;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class Main {

    public static void main(String[] args) {
	// write your code here
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Enter the ID of the teacher: ");
            int iD = parseInt(br.readLine()) ;

            DALConnection.getInstance().connect();

            String personName = DALPerson.getInstance().getPersonName(iD);
            String personEmail = DALPerson.getInstance().getPersonEmail(iD);
            System.out.println("The name of teacher with ID " + iD + ": " + personName);
            System.out.println("The email of teacher with ID " + personName + ": " + personEmail);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
