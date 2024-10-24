package org.example;

import java.util.Random;

public class Cheval extends Thread {

    Random random = new Random();
    public static String gagnant;
    private static volatile boolean courseTerminee = false;

    private String nom;

    private int position;

    public Cheval(String nom, int position) {
        this.nom = nom;
        this.position = position;
    }

    public String getNom() {
        return nom;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition() throws InterruptedException {
        int nextMove = random.nextInt(10 - 1 + 1) + 1;
        if (this.position + nextMove > 100) {
            this.position = 100;
        } else {
            this.position += nextMove;
        }
        Thread.sleep(1000);
    }

    @Override
    public void run() {
        try {
            while (!courseTerminee && getPosition() < 100) {
                setPosition();
                System.out.println(getNom() + " : position " + getPosition());

                if (getPosition() >= 100) {
                    courseTerminee = true;
                    System.out.println(getNom() + " a gagné la course !");
                    gagnant = getNom();
                }
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
