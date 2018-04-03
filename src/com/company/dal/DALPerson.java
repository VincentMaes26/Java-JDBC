package com.company.dal;

public class DALPerson {
    private static DALPerson dalPerson;

    public DALPerson getInstance(){
        if(dalPerson==null)
            dalPerson = new DALPerson();

        return dalPerson;
    }
}
