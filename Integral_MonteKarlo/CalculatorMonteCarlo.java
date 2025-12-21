package com.elmir.question_2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

import static java.util.concurrent.Executors.newFixedThreadPool;

class CalculatorMonteCarlo{
    double n, m;
    int total_in_func_points = 0;
    final int point_num = (int) Math.pow(10, 6);
    int threads_num;

    CalculatorMonteCarlo(double n, double m, int threads_num){
        this.n = n;
        this.m = m;
        this.threads_num = threads_num;
    }

    public double integrate() throws InterruptedException, ExecutionException {
        ExecutorService executor = newFixedThreadPool(threads_num);

        List<Callable<Integer>> tasks = new ArrayList<>();

        int thread_points_num;
        for (int i = 0; i < threads_num; i++){
            thread_points_num = point_num / threads_num;
            if (i == 0){
                thread_points_num += point_num % threads_num;
            }

            Callable<Integer> task = new MonteCarloTask(n, m, thread_points_num);
            tasks.add(task);
        }

        List<Future<Integer>> futures = executor.invokeAll(tasks);

        for (Future<Integer> future : futures){
            total_in_func_points += future.get();
        }

        executor.shutdown();
        return (n * m) * ((double) total_in_func_points / point_num);

    }

    private class MonteCarloTask implements Callable<Integer>{
        double n, m;
        int thread_points_num;
        int in_func_points = 0;

        MonteCarloTask(double n, double m, int thread_points_num){
            this.n = n;
            this.m = m;
            this.thread_points_num = thread_points_num;
        }

        @Override
        public Integer call() throws Exception{
            double x, y;
            double [] point;
            for (int i = 0; i < thread_points_num; i++){
                point = GenerateRandomXY();
                x = point[0];
                y = point[1];
                double fx = (Math.pow(x, 5) / (x * x + 1)) * Math.log(Math.sqrt(x));

                if ((y >= 0 && fx >= 0 && y <= fx) || (y < 0 && fx < 0 && y >= fx)){
                    in_func_points += 1;
                }
            }
            return in_func_points;
        }
    }

    public double[] GenerateRandomXY(){
        ThreadLocalRandom random = ThreadLocalRandom.current();
        return new double[]{random.nextDouble() * n, random.nextDouble() * m};
    }
}




