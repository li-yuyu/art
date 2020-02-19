package com.liyuyu.demo.common.redis;

import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import redis.clients.jedis.JedisCommands;

/**
 * @Description:
 *  注意springboot2.0以上的spring-boot-starter-data-redis，
 *  请排除默认实现lettuce-core包，使用Jedis
 * @author Lyle
 * @date 2019-06-14
 */
public class RedisLock {

	private RedisTemplate<String, String> redisTemplate;
	private String key;
	private long timeout;

	/**
	 * @param redisTemplate
	 * @param key	redis中的键值
	 * @param timeout	超时时间（秒）
	 */
	public RedisLock(RedisTemplate<String, String> redisTemplate, String key, long timeout) {
		super();
		this.redisTemplate = redisTemplate;
		this.key = key;
		this.timeout = timeout;
	}

	/**
	 * 尝试获取锁
	 * @return
	 */
	public boolean tryLock() {
		RedisConnection connection = null;
		try {
			RedisConnectionFactory redisConnectionFactory = redisTemplate.getConnectionFactory();
			connection = redisConnectionFactory.getConnection();
			JedisCommands client = (JedisCommands) connection.getNativeConnection();
			String status = client.set(key, "", "NX", "EX", timeout);
			if ("OK".equals(status)) {
				return true;
			}
			return false;
		} finally {
			if (connection != null) {
				connection.close();
			}
		}
	}

	/**
	 * 极端情况下,当任务执行时间大于key的过期时间时，会误删其他进程的锁
	 */
	public void unlock() {
		redisTemplate.delete(key);
	}

}
