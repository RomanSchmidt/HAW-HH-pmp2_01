package de.task;

import org.jetbrains.annotations.NotNull;

import java.util.Collection;

public abstract class Task3 {
    private static int sum;

    static int sum(@NotNull Collection<Integer> coll) {
        Task3.sum = 0;
        coll.forEach((element) -> {
            int sumBefore = sum;
            sum += element;
            if ((element > 0 && sumBefore > sum) || (element < 0 && sumBefore < sum)) {
                throw new ArithmeticException();
            }
        });
        return sum;
    }
}

