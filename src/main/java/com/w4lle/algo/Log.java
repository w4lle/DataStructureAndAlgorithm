package com.w4lle.algo;

/**
 * Created by w4lle on 2018/11/27.
 * Copyright (c) 2018 51nb, Inc. All rights reserved.
 */


public class Log {
    public static void d(String string) {
        if (!string.endsWith("\n")) {
            string = string + "\n";
        }
        System.out.print(string);
    }
}
