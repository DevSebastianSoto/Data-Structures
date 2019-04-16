package com.devssm;

public class Main {

    public static void main(String[] args) {
        SimpleList<String> names = new SimpleList<>();
        names.add("Sebas");
        names.add("Carlos");
        names.add("Karla");
        names.add("Sofia");
        String [] namesArr = names.toArray(String[].class);
        for(String s:namesArr){
            System.out.println(s);
        }

    }
}
