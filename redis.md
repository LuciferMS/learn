#1.数据类型:
##1.1 String类型 
####(二进制安全，可以存图片或者序列化的对象，最大可以存512M)
        1.set name "Elliot" 设置键值对
        2.get name 根据key获取value
        3.getset name "Shayla" 将给定的key值设置成相应的value,并返回原来的value，类似于HashMap的覆盖操作,如果不存在KEY,就会返回nil
        4.getrange name 0 10 获取子串
 ##1.2 hash类型 (对应Map类型,对比list，String，kv模式不变，v变成了一个个键值对)
        1.hmset user username "Elliot" password "123456"
        2.hget user username 获取对应的内同
        3.hdel key [key] 删除一个键值对
        4.hlen 键值对长度
        5.hexists key field 判断某个键是否存在，存在返回1，不存在返回0
        6.hvals key 获取所有值
        7.hkeys key 获取所有键
        8.hincrBy,hincrByfloat key field offset 自增
##1.3 list类型 (本质是双向链表)
        1.list类型支持左边插入(lpush)和右边插入(rpush)
        2.lpush mylist redis(左插)
        3.lpush mylist java
        4.rpush mylist c++(右插)
        5.lrange mylist 0 10(这句话是展示这个list的元素，从左边0开始到第10个结束，是闭区间,如果右边是-1,就是全部都取，还是倒叙)
        6.rpop 从右边开始出队
        7.lpop 从左边开始出队
        8.lindex key index 寻找列队中从左边开始排第index + 1的value
        9.llen key list长度
        10.lrem key nums value 删除list中nums个重复的value
        11.linsert key before ploit value0 在某个元素之前插入value
##1.4 set(集合类型,对应数学中集合的概念,基于HashTable实现的)
        1.sadd myset 1
        2.sadd myset 2
        3.smembers myset(展示set集合上的元素)
        4.sismember myset value 判断value是不是set上的元素
        5.scard key 获取集合元素个数
        6.srem key value 删除集合某个元素
        7.srandmember key [count] 在集合中随机选取几个(count可选，默认是1)元素
        8.spop key [count] 随机弹出元素
        9.smove soures des value 将soures中的value迁移到des中
        10.sdiff set1 set2 获取两个集合的差集,set1-set2
        11.sunion set set2 合并两个集合 set1 + set2 + 去重
##1.5 zset(有序集合)类型
        1.zset跟set一样,根据hashmap实现，不同的是zset会将元素与一个double类型的分数(score)作为关联,score可以相同，但是元素相同则覆盖
        2.zadd myzset 0(score) java
        3.zadd myzset 3(score) c++
        4.zadd myzset 1(score) c
        5.zadd myzset 2(score) redis
        6.zadd myzset 1(score) scala
        7.zrange myzset 0 10(跟list一样,是一个闭区间，用这个作为zset的展示其实跟set没有区别，都是按照添加的顺序展示的)
        8.zrange myzset 0 10 withscores 将score一起列出来，withscores是可选的
        9.zrangeByScore myzset 0 10(指定按照score顺序来展示，如果scored的值相同，则按照添加顺序排序)
        10.zrangeByScore myzset (0 (10 还可以这样写，表示大于0却不包含0 且小于10却不包含10
        11.zrangeByScore myzset 0 10 limit 2 2 还有类似分页的操作,这句表示从2开始截取2个
        12.zrem key value 移除某个元素
        13.zcount key minScore maxScore 统计在minScore和maxScore之间的元素个数，这里也可以用(minscore这样的操作表示不包含minscore
        14.zrank key member 获取元素索引值
        15.zscore key member 获取元素对应的score值
        16.zrevrange 反过来排序
#2.keys指令
    1.move key db 将key以及对应的value移到对应的库,顺利执行返回1
    2.select dbindex 切换库
    3.ttl key 获取key的生命周期 -1 表示永久有效，-2 表示已过期
    4.expire key time 设置key的生命周期，时间一过对应的键值对就会被清除，再也访问不到了
    5.getbit key index获取key对应value特定位置的值，这个获取的是对应二进制的值，超过长度或者key不存在就返回0
    6.mget key key 获取多个key对应的value值
    7.SETBIT key offset value 设置或者清除对应bit上的值