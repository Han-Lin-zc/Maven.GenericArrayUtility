package com.zipcodewilmington.arrayutility;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by leon on 3/6/18.
 */
public class ArrayUtility<T> {

    private T[] arr1;

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
        ArrayList<T> newArr = new ArrayList<>();

        for (T t : this.arr1) {
            if (t != valueToRemove) {
                newArr.add(t);
            }
        }
        T[] result = (T[]) Array.newInstance(valueToRemove.getClass(), newArr.size());
        for (int i = 0; i < newArr.size() ; i++) {
            result[i] = newArr.get(i);
        }
        return result;
    }


    public T getMostCommonFromMerge(T[] arr2) {
        T[] newArr = mergeArr(arr2);
        Map<T, Integer> map = new HashMap<>();

        for (int i = 0; i < newArr.length; i++) {
            T key = newArr[i];
            if (map.containsKey(key)) {
                Integer freq = map.get(key);
                freq++;
                map.put(key,freq);
            } else {
                map.put(key,1);
            }
        }

        Integer maxCount = 0;
        T result = null;
        for(Map.Entry<T, Integer> val : map.entrySet()) {
            if (maxCount < val.getValue()) {
                result = val.getKey();
                maxCount = val.getValue();
            }
        }
        return result;
    }

    public Integer getNumberOfOccurrences(T valueToEvaluate) {
        Integer counter = 0;
        for (T type : this.arr1) {
            if (type.equals(valueToEvaluate)) counter++;
        }
        return counter;
    }
}







