package com.naz_kovalchuk.libraryApp.utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {


    private static Properties properties = new Properties();

    static {

        try {
            //Opening file in java memory. If file is in the same directory as this class then we can just pass filename. Otherwise full path.
            FileInputStream file = new FileInputStream("configuration.properties");

            //Here Properties object can use our file.
            properties.load(file);

            //Good practice to close the file
            file.close();

        }catch (IOException e){
            e.printStackTrace();
        }

    }

    //Ми таким способом зробили тому шо, якшо в нас тут буде багато методів то треба було б в кожному прописувати
    //FIleInput і тд., плюс нам лише раз треба змінити path в статік блоці  і для всіх методів він зміниться
    public static String getProperty(String keyWord){

        return properties.getProperty(keyWord);

    }



}