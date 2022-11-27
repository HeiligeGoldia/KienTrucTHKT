package com.se.passenger.controller;

import com.se.passenger.entity.Passenger;
import com.se.passenger.repository.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.SerializationUtils;
import org.springframework.web.bind.annotation.*;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/passenger")
public class PassengerController {

    @Autowired
    private PassengerRepository passengerRepository;

    JedisPool jedisPool = new JedisPool("127.0.0.1");
    Jedis jedis = jedisPool.getResource();

    @PostMapping("/addToRedis")
    public String addToCart(@RequestBody Passenger passenger){
        byte[] key = SerializationUtils.serialize("queue");
        byte[] data = SerializationUtils.serialize(passenger);
        jedis.sadd(key, data);
        return "Added to queue";
    }

    @GetMapping("/getFromRedis")
    public List<Object> getFromCart(){
        List<Object> q = new ArrayList<>();
        byte[] key = SerializationUtils.serialize("queue");
        Set<byte[]> queue_item = jedis.smembers(key);
        for (byte[] b : queue_item){
            Object deserialized = SerializationUtils.deserialize(b);
            q.add(deserialized);
        }
        System.out.println(queue_item);
        return q;
    }

    @DeleteMapping("/removerAllFromRedis")
    public String removerAllFromCart(){
        byte[] key = SerializationUtils.serialize("queue");
        jedis.del(key);
        return "Deleted";
    }

    @GetMapping("/getById/{pid}")
    public Passenger getById(@PathVariable("pid") int pid){
        return passengerRepository.getById(pid);
    }

}
