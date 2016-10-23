package com.example.collections.hackerrank.bits;

import java.util.Scanner;

/**
 * Created by John on 9/8/2016.
 */
public class MaximizingXor {

    static int maxXor(int l, int r, int max) {
        if (l > r) return max;

        int idx = l;
        for (; idx <= r; idx++) {
            int xor = l ^ idx;
            max = (xor) > max ? xor : max;
        }
        return maxXor(l + 1, r, max);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int res;
        int _l;
        _l = Integer.parseInt(in.nextLine());

        int _r;
        _r = Integer.parseInt(in.nextLine());

        res = maxXor(_l, _r, 0);
        System.out.println(res);

    }

}
