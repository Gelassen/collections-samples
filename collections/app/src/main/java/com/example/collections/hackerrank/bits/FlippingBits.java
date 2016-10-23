package com.example.collections.hackerrank.bits;

import android.util.Log;

import com.example.collections.App;

/**
 * Created by John on 9/8/2016.
 */
public class FlippingBits {

    public static Integer solveme(Integer value) {
        return ~value;
    }

    public static Integer testMe(Integer value) {
        Log.d(App.TAG, "Value: " + Integer.toBinaryString(value));
        Log.d(App.TAG, "Value simply inverted: " + Long.toBinaryString(value));
        Log.d(App.TAG, "Value with mask: " + Long.toBinaryString(value & 0x00000000000000000000000000000010));
        Log.d(App.TAG, "Value with max mask: " + Long.toBinaryString(value & 0x0f));
        return value;
    }

    private static int invert(int x) {
        if (x == 0) return 0; // edge case; otherwise returns -1 here
        int nlz = nlz(x);
        return ~x & (0xFFFFFFFF >>> nlz);
    }

    private static int nlz(int x) {
        // Replace with whatever number leading zero algorithm you want - I can think
        // of a whole list and this one here isn't that great (large immediates)
        if (x < 0) return 0;
        if (x == 0) return 32;
        int n = 0;
        if ((x & 0xFFFF0000) == 0) {
            n += 16;
            x <<= 16;
        }
        if ((x & 0xFF000000) == 0) {
            n += 8;
            x <<= 8;
        }
        if ((x & 0xF0000000) == 0) {
            n += 4;
            x <<= 4;
        }
        if ((x & 0xC0000000) == 0) {
            n += 2;
            x <<= 2;
        }
        if ((x & 0x80000000) == 0) {
            n++;
        }
        return n;
    }
}
