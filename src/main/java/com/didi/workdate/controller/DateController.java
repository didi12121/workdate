package com.didi.workdate.controller;

import com.alibaba.fastjson.JSONObject;
import com.didi.workdate.modle.Results;
import com.didi.workdate.redis.RedisCache;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.io.IOException;

@RestController
public class DateController {
    @Resource
    RedisCache redisCache;

    @GetMapping("getdate")
    public Results test(){
//        redisCache.getCacheObject()
        return Results.success(1);
    }

    @PostConstruct
    public void cacheDate(){
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        Request request = new Request.Builder()
                .url("https://api.apihubs.cn/holiday/get")
                .method("GET", null)
                .build();
        try {
            Response response = client.newCall(request).execute();
            String string = response.body().string();
            System.out.println(string);
//            JSONObject.parseObject(string).getJSONObject("data").getJSONArray("list").toJavaList()
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
