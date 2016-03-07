package org.bytegeeks.learn;

import java.util.ArrayList;
import java.util.List;

public class Main {

    List<String> list = new ArrayList<String>();

    public Main() {
        // Following call will be intercepted
        list.add("item");
        System.out.println("Done");
    }

    public static void main(String[] args) {
        new Main();
    }

}
