package org.bytegeeks.learn;

import com.lambdaworks.redis.RedisClient;
import com.lambdaworks.redis.RedisHashesConnection;

public class CacheProvider {
	
	public CacheProvider() {
        RedisClient client = RedisClient.create("redis://" + System.getProperty("redis_server_ip"));
		RedisHashesConnection connection = client.connect();
		Object value = connection.hget("5","v");
		
		System.err.println(value);
		connection.hset("5","v","m");
	}

	public static void main(String[] args) {
		new CacheProvider();
	}
	

}
