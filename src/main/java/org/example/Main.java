package org.example;

import org.example.package_1.Message;

public class Main {

    public static void main(final String[] args) {
        final Message messageFromPackageOne = new Message("Message from package one");
        System.out.println(messageFromPackageOne.getMessage());

        final org.example.package_2.Message messageFromPackageTwo = new org.example.package_2.Message("Message from package two");
        System.out.println(messageFromPackageTwo.getMessage());
    }
}
