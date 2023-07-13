package com.yn.redis.service.impl;

import com.yn.javacommon.service.RedisService;
import com.yn.redis.service.RedisDemoService;
import org.springframework.data.redis.core.Cursor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ScanOptions;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;

@Service
public class RedisDemoServiceImpl implements RedisDemoService {

    @Resource
    private RedisTemplate redisTemplate;
    @Resource
    RedisService redisService;

    @Override
    public void test() {


        fuzzySearch("te*");

    }

    /**
     * 模糊匹配查询
     * @param pattern
     */
    public void fuzzySearch(String pattern) {
        ScanOptions options = ScanOptions.scanOptions().match(pattern).build();
        redisTemplate.executeWithStickyConnection(connection -> {
            try (Cursor<byte[]> cursor = connection.scan(options)) {
                while (cursor.hasNext()) {
                    byte[] keyBytes = cursor.next();
                    String key = new String(keyBytes);
                    Integer value = (Integer) redisTemplate.opsForValue().get(key);
                    System.out.println("Key: " + key + ", Value: " + value);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return null;
        });
    }
}
