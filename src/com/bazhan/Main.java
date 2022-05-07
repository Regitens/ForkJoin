package com.bazhan;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;

public class Main {
    //с применением архитектуры вилочного соединения
    public static void main(String[] args) {
	final int SIZE=1000000;
    var numbers=new double[SIZE];
    for (int i=0; i<SIZE;i++) numbers[i]=Math.random();
    var counter=new Counter(numbers,0,numbers.length,x->x>0.5);
    var pool=new ForkJoinPool();
    //выполняет задачу в пуле
    pool.invoke(counter);
    System.out.println(counter.join());
    }
}
