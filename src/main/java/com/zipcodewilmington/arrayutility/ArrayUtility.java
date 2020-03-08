package com.zipcodewilmington.arrayutility;

import java.util.Arrays;

/**
 * Created by leon on 3/6/18.
 */
public class ArrayUtility<T> {

    private T[] arr1;
    private Integer length;


    public ArrayUtility(T[] arr1) {
        this.arr1 = arr1;

    }

    public T[] mergeArr(T[] arr2) {
        T[] mergeArr = Arrays.copyOf(this.arr1, this.arr1.length + arr2.length);
        System.arraycopy(arr2, 0, mergeArr, this.arr1.length, arr2.length);
        return mergeArr;
    }

    public Integer countDuplicatesInMerge(T[] arr2, T valueToEvaluate) {
       T[] newArr = mergeArr(arr2);

        Integer counter = 0;
        for (T t : newArr) {
            if (t == valueToEvaluate) {
                counter++;
            }
        }
        return counter;
    }

    public T[] removeValue(T valueToRemove) {
        return null;
    }

    public T getMostCommonFromMerge(T[] arr2) {
        return null;
    }

    public Integer getNumberOfOccurrences(T valueToEvaluate) {
        return null;
    }
}