package com.creat.testaa;

import java.util.HashMap;

/**
 * Created by Administrator on 2017/9/24.
 */
public class AlphaMatrix implements IAlphaMatrix{
    public int findAlphaMatrix(String[] dic, int n) {
                int result = 0;
                HashMap<String, Integer> map = new HashMap<String, Integer>();
                for(int i=0; i<dic.length; i++){
                        if(!map.containsKey(dic[i])) map.put(dic[i], 1);
                        else map.put(dic[i], map.get(dic[i])+1);
                }
                for(int i=0; i<dic.length; i++) {
                    result = Math.max(result, map.get(dic[i])*dic[i].length());
                }
            return result;
    }
}
