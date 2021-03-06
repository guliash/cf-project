package com.github.guliash.math;

import java.util.ArrayList;

/**
 * Created by gulash on 18.05.15.
 */
public class Utils {

    public static final int[][] ADJ_CELLS = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
    public static final int[][] NEIGHBOURS = {{0, -1}, {-1, -1}, {-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}};

    public static boolean checkBorders(int x, int y, int n, int m) {
        return x >= 0 && x < n && y >= 0 && y < m;
    }

    public static ArrayList<Integer> finDivisors(int a) {
        int iter = 1;
        ArrayList<Integer> res = new ArrayList<>();
        for(; iter * iter < a; iter++) {
            if(a % iter == 0) {
                res.add(iter);
                res.add(a / iter);
            }
        }
        if(iter * iter == a) {
            res.add(iter);
        }
        return res;
    }

    public static ArrayList<Long> findDivisors(long a) {
        long iter = 1;
        ArrayList<Long> res = new ArrayList<>();
        for(; iter * iter < a; iter++) {
            if(a % iter == 0) {
                res.add(iter);
                res.add(a / iter);
            }
        }
        if(iter * iter == a) {
            res.add(iter);
        }
        return res;
    }

    public static ArrayList<Integer> factorize(int a) {
        int cur = a;
        ArrayList<Integer> primes = new ArrayList<>();
        for(int i = 2; i * i <= a; i++) {
            while(cur % i == 0) {
                primes.add(i);
                cur /= i;
            }
        }
        if(cur != 1) {
            primes.add(cur);
        }
        return primes;
    }

    public static ArrayList<Long> factorize(long a) {
        long cur = a;
        ArrayList<Long> primes = new ArrayList<>();
        for(long i = 2; i * i <= a; i++) {
            while(cur % i == 0) {
                primes.add(i);
                cur /= i;
            }
        }
        if(cur != 1) {
            primes.add(cur);
        }
        return primes;
    }


    public static boolean isPrime(long a) {
        if(a <= 1) {
            return false;
        }
        for(long i = 2; i * i <= a; i++) {
            if(a % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static int addMod(int a, int b, int mod) {
        return ((a + b) % mod + mod) % mod;
    }

    public static long addMod(long a, long b, long mod) {
        return ((a + b) % mod + mod) % mod;
    }

    public static long binpow(long a, long pow, long mod) {
        if(pow == 0) {
            return 1;
        }
        long res = binpow(a, pow / 2, mod);
        if(pow % 2 == 0) {
            return (res * res) % mod;
        } else {
            return (((res * res) % mod) * a) % mod;
        }
    }

    public static long gcd(long a, long b) {
        if(b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    public static int gcd(int a, int b) {
        if(b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    public static long inv(long a, long mod) {
        return binpow(a, mod - 2, mod);
    }

    public static boolean nextPermutation(int[] a) {
        int temp, mid, n;
        n = a.length;
        for(int i = n - 1; i > 0; i--) {
            if(a[i] > a[i - 1]) {
                for(int j = n - 1; j >= i; j--) {
                    if(a[j] > a[i - 1]) {
                        temp = a[i - 1];
                        a[i - 1] = a[j];
                        a[j] = temp;
                        break;
                    }
                }
                mid = i + (n - i) / 2;
                for(int j = i, z = 0; j < mid; z++, j++) {
                    temp = a[j];
                    a[j] = a[n - z - 1];
                    a[n - z - 1] = temp;
                }
                return true;
            }
        }
        return false;
    }

    public static long divAndCeil(long a, long b) {
        if(a % b == 0) {
            return a / b;
        } else {
            return a / b + 1;
        }
    }
}
