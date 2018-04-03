package com.company;

import com.company.dal.DALConnection;

public class Main {

    public static void main(String[] args) {
	// write your code here
        try{
            DALConnection.getInstance().connect();

        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
