package com.elmir.question_2;
import java.util.concurrent.*;


public class Main {
    public static void main(String[] args) {
        double n = 100;
        double m = 100;
        int threads_num = 4;
        CalculatorMonteCarlo integrator = new CalculatorMonteCarlo(n, m, threads_num);
        try{
            double result = integrator.integrate();
            System.out.println(result);
        }
        catch (ExecutionException | InterruptedException e){
            e.printStackTrace();
        }
    }
}


