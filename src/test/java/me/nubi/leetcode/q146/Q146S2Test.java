package me.nubi.leetcode.q146;

import org.junit.Assert;
import org.junit.Test;
import me.nubi.leetcode.q146.Solution.LRUCache;

public class Q146S2Test {

    @Test
    public void test1() {
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(1, 1); // 缓存是 {1=1}
        lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
        Assert.assertEquals(1, lRUCache.get(1));    // 返回 1
        lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
        Assert.assertEquals(-1, lRUCache.get(2)); ;    // 返回 -1 (未找到)
        lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
        Assert.assertEquals(-1, lRUCache.get(1));    // 返回 -1 (未找到)
        Assert.assertEquals(3, lRUCache.get(3));    // 返回 3
        Assert.assertEquals(4, lRUCache.get(4)); ;    // 返回 4
        System.out.println("run success");
    }

    @Test
    public void test2() {
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(1, 0); // 缓存是 {1=0}
        lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
        Assert.assertEquals(0, lRUCache.get(1));    // 返回 0
        lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
        Assert.assertEquals(-1, lRUCache.get(2)); ;    // 返回 -1 (未找到)
        lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
        Assert.assertEquals(-1, lRUCache.get(1));    // 返回 -1 (未找到)
        Assert.assertEquals(3, lRUCache.get(3));    // 返回 3
        Assert.assertEquals(4, lRUCache.get(4)); ;    // 返回 4
        System.out.println("run success");
    }
    //[[2],[2,1],[2,2],[2],[1,1],[4,1],[2]]

    @Test
    public void test3() {
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(2, 1); // 缓存是 {1=0}
        lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
        Assert.assertEquals(2, lRUCache.get(2));    // 返回 0
        lRUCache.put(1, 1);
        lRUCache.put(4, 1);
        Assert.assertEquals(-1, lRUCache.get(2));    // 返回 -1 (未找到)
        System.out.println("run success");
    }

    // [[3],[1,1],[2,2],[3,3],[4,4],[4],[3],[2],[1],[5,5],[1],[2],[3],[4],[5]]

    @Test
    public void test4() {
        LRUCache lRUCache = new LRUCache(3);
        lRUCache.put(1, 1); // 缓存是 {1=0}
        lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
        lRUCache.put(3, 3); // 缓存是 {1=1, 2=2}
        lRUCache.put(4, 4); // 缓存是 {1=1, 2=2}
        Assert.assertEquals(4, lRUCache.get(4));    // 返回 0
        Assert.assertEquals(3, lRUCache.get(3));    // 返回 0
        Assert.assertEquals(2, lRUCache.get(2));    // 返回 0
        Assert.assertEquals(-1, lRUCache.get(1));    // 返回 0
        lRUCache.put(5, 5); // 缓存是 {1=1, 2=2}
        Assert.assertEquals(-1, lRUCache.get(1));    // 返回 0
        Assert.assertEquals(2, lRUCache.get(2));    // 返回 -1 (未找到)
        Assert.assertEquals(3, lRUCache.get(3));    // 返回 0
        Assert.assertEquals(-1, lRUCache.get(4));    // 返回 0
        Assert.assertEquals(5, lRUCache.get(5));    // 返回 0
        System.out.println("run success");
    }
}
