package com.terzeron.grammar.prime;

public class Sieve {
    public static void main(String[] args) {
        int max = 100;
        // argument를 읽어 int max에 저장한다.
        try {
            max = Integer.parseInt(args[0]);
        } catch (Exception e) {
        }
        if (max < 2) {
            System.out.println("Can't find a largest com.terzeron.grammar.prime number of this value");
            return;
        }

        boolean[] isprime = new boolean[max + 1];

        for (int i = 0; i <= max; i++)
            isprime[i] = true;
        isprime[0] = isprime[1] = false;

        int n = (int) Math.ceil(Math.sqrt(max));

        for (int i = 0; i <= n; i++) {
            if (isprime[i])
                for (int j = 2 * i; j <= max; j += i)
                    isprime[j] = false;
        }

        int largest;
        for (largest = max; !isprime[largest]; largest--)
            ;

        System.out.println("The largest com.terzeron.grammar.prime less than or equal to " + max + " is "
                + largest);
    }
}

