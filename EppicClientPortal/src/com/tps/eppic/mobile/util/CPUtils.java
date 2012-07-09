package com.tps.eppic.mobile.util;

import android.content.res.TypedArray;

public class CPUtils {

    public static int[] convertTypeArrToIntegerArr(TypedArray imageArr, int arrayLength) {
        int[] intArr = new int[arrayLength];
        for (int i = 0; i < arrayLength; i++) {
            intArr[i] = imageArr.getResourceId(i, -1);
        }
        return intArr;
    }
}
