package com.liyuyu.demo.common.redis;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.RedisScript;

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
	private String value;
	private long timeout;
	private static final RedisScript<Long> UNLOCK_SCRIPT;
	
    static {
        StringBuilder sb = new StringBuilder();
        sb.append("if redis.call(\"get\",KEYS[1]) == ARGV[1] ");
        sb.append("then ");
        sb.append("    return redis.call(\"del\",KEYS[1]) ");
        sb.append("else ");
        sb.append("    return 0 ");
        sb.append("end ");
        UNLOCK_SCRIPT = RedisScript.of(sb.toString());
    }

	/**
	 * @param redisTemplate
	 * @param key	redis中的键值
	 * @param timeout	超时时间（秒）
	 */
	public RedisLock(RedisTemplate<String, String> redisTemplate, String key, long timeout) {
		super();
		this.redisTemplate = redisTemplate;
		this.key = key;
		this.value = UUID.randomUUID().toString();
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
			String status = client.set(key, value, "NX", "EX", timeout);
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
	 * 解锁
	 * @return
	 */
	public boolean unlock() {
		Long result = redisTemplate.execute(UNLOCK_SCRIPT, Arrays.asList(key), value);
		
		return result != null;
	}

}
