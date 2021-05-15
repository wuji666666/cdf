package com.yong.cdf.util;

import java.time.Instant;
import java.util.UUID;

public class UniqueKey {
    public static  synchronized String  createId(){
       UUID uuid= UUID.randomUUID();
       return uuid.toString().replace("-","");
    }

    public static synchronized String  generatedKey(){
        long timestamp= Instant.now().toEpochMilli();
        int rdStatics=(int)Math.random()*900000;
        return timestamp+String.valueOf(rdStatics);
    }
}
