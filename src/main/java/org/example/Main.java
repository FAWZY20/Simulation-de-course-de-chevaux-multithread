package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        Cheval cheval1 = new Cheval("thor", 0);
        Cheval cheval2 = new Cheval("zeus", 0);
        Cheval cheval3 = new Cheval("athena", 0);

        System.out.println("Vous parier sur quel cheval ? " + " (" + cheval1.getNom() + "," + cheval2.getNom() + "," +cheval3.getNom() + ") " );
        String cheval = scanner.next();

        cheval1.start();
        cheval2.start();
        cheval3.start();

        try {
            cheval1.join();
            cheval2.join();
            cheval3.join();

            System.out.println("----------------------");
            System.out.println("La course est terminée !");
            System.out.println("Le gagnant est " + Cheval.gagnant);
            if (cheval.equals(Cheval.gagnant)) {
                System.out.println("VOUS AVEZ GAGNEE !!");
            } else {
                System.out.println("VOUS AVEZ PERDU");
            }
            System.out.println("----------------------");

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }
}