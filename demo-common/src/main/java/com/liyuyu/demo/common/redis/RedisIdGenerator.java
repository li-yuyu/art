package com.liyuyu.demo.common.redis;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.springframework.data.redis.core.RedisTemplate;

/**
 * @Description: ID生成器，支持每分钟1千万个id
 * @author Lyle
 * @date 2019-07-08
 */
public class RedisIdGenerator {

	private RedisTemplate<String, String> redisTemplate;
	private String idPrefix;
	private String redisKeyPrefix;

	/**
	 * @param redisTemplate
	 * @param idPrefix
	 *            id前缀 例：0119070819290000001中的01
	 * @param redisKeyPrefix
	 *            redis中的键值前缀 例：order:orderId:1907081929 中的order:orderId:
	 */
	public RedisIdGenerator(RedisTemplate<String, String> redisTemplate, String idPrefix, String redisKeyPrefix) {
		super();
		this.redisTemplate = redisTemplate;
		this.idPrefix = idPrefix;
		this.redisKeyPrefix = redisKeyPrefix;
	}

	/**
	 * 生成 idPrefix + 17位唯一数字
	 * @return 例：0119070819290000001
	 */
	public String genId() {
		String minutesStr = new SimpleDateFormat("yyMMddHHmm").format(new Date());
		String suffix = idPrefix +  minutesStr;
		String key = redisKeyPrefix + minutesStr;
		Long increment = redisTemplate.opsForValue().increment(key, 1);
		redisTemplate.expire(key, 1, TimeUnit.MINUTES);
		return suffix + zeroPaddingLeft(increment.toString(), 7);
	}

	private static String zeroPaddingLeft(String input, int toltalLength) {
		if (input == null) {
			throw new NullPointerException("input cant not be null");
		}
		if (input.length() > toltalLength) {
			throw new IllegalArgumentException("input length must < toltal length");
		}
		StringBuilder sb = new StringBuilder(input);
		for (int i = 0; i < toltalLength - input.length(); i++)
			sb.insert(0, '0');
		return sb.toString();
	}

}
