package com.creat.myhash;

/**
 * Created by Administrator on 2017/8/12 0012.
 */
public class MyHash {

    public static int hash(String key, int tableSize){
        int hashValue = 0;
        for(int i = 0; i < key.length(); i++){
            hashValue = 37*hashValue + key.charAt(i);
        }
        hashValue %= tableSize;
        if(hashValue < 0){
            hashValue += tableSize;
        }
        return hashValue;
    }
}
