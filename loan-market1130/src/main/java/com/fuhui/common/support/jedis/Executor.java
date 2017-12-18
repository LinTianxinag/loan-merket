package com.fuhui.common.support.jedis;

import redis.clients.jedis.ShardedJedis;

public interface Executor<K> {
	public K execute(ShardedJedis jedis);
}
