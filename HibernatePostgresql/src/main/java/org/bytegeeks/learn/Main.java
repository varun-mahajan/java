package org.bytegeeks.learn;
import org.hibernate.SessionFactory;

public class Main {

    public static void main( String[] args )
    {
        SessionFactory sf = HibernatePersistence.getSessionFactory();
    }
}