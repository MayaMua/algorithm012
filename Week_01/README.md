# 学习笔记

## 上课内容

### 第一课

- 进行刻意练习 —— 过变数（5遍刷题） 、 练习弱项 、 反馈（主动反馈：寻找各种解题思路 + 被动反馈：code review）
- 总结成脑图
- 切题：Clarification（看题+与面试官交流） 、Possible solutions（比较+优化） 、Coding、Test
- 5遍刷题
  - 刷题第一遍： 可直接看写法 ， 然后默写 。 比较各种解法
  - 不看答案
  - 过了一天练习
  - 过了一周练习
  - 恢复性训练

数据结构

| 一维                          | 二维                                                         | 特殊                 |
| ----------------------------- | ------------------------------------------------------------ | -------------------- |
| array, linked list            | tree, graph                                                  | Bitwise Bloom Filter |
| stack, queue, deque, set, map | binary search tree (red-black tree, AVL), heap, disjoint set, trie | LRU cache            |

算法：

if-else: Branch

loop: Iteration

Recursion

搜索

动态规划

二分查找

贪心

数学&集合

### 第二课

| **时间复杂度** | Array | Linked List |
| -------------- | ----- | ----------- |
| prepend        | O(1)  | O(1)        |
| append         | O(1)  | O(1)        |
| lookup         | O(1)  | O(n)        |
| insert         | O(n)  | O(1)        |
| delete         | O(n)  | O(1)        |

### 第三课 3sum and Linked List Cycle

#### 1. 3sum #15 

- 哈希表查找时间O(1) 遍历所有元素O(n)

- a+b=-c

- Arrays.sort(nums);    //  O(nlogn)

- 夹逼算法 （双指针：快&慢（数组排好序）：

  <img src="https://pic.leetcode-cn.com/030717e1cde175687fae914f3f49b3f17c6aaa75656b4be8ab49be14790d691c-Picture2.png"     alt="Markdown Monster icon"     style="float: left; margin-right: 10px;" />

  ```java
  if (-nums[k] > nums[i] + nums[j]) i++
  if (-nums[k] < nums[i] + nums[j]) j--
  ```

#### 2.  Linked List Cycle #141

​	a. 定义一个set，遍历过的元素放入set，如果set中有出现该元素，则说明有环。

```java
Set<ListNode> mySet = new HashSet<>();
if(contains(head)) return true;
else add(head)
```

​	b. 快慢指针

- 快指针移动两个节点，慢指

  针移动一个节点。 

```java
slow = slow.next;
fast = fast.next.next;
```

- [环的长度](https://leetcode-cn.com/problems/linked-list-cycle/solution/lian-biao-you-huan-zui-jia-jie-da-by-tinet-shenjg/ )

快慢指针法中，两个指针的速度差为1。所以当两个指针第二次相遇时，指针P1走了2倍环的长度，而指针1走了环的长度。所以指针第一次相遇到第二次相遇之间，指针的移动次数就是环的长度。

### 第四课 Stack & Queue

更经常用Deque (Double-End Queue) ， 插入/删除: O(1)

```java
Stack<Integer> stack = new Stack<Integer>(); 
Queue<Integer> queue = new LinkedList<String>();
```

**使用addFirst或addLast替换push：**

```java
deque.push("a");
deque.push("b");
deque.push("c");
//======================================
deque.addFirst("a");
deque.addFirst("b");
deque.addFirst("c");
//======================================
deque.addLast("c");
deque.addLast("b");
deque.addLast("a");
```

**Queue:**

- 先进先出
- 添加元素的操作中 ， 除了对长度判断 ， 还有元素类型做出判断（ClassCastException）以及元素对象属性的判断（如果此元素的某些属性阻止将其添加到此队列中 ， 则抛出一个IllegalArgumentException）

**Priority Queue：**

- insert: O(1)

- lookup: O(logN)

- insert: O(nlogN)

- PriorityQueue 是基于优先堆的一个无界队列 ， 通过comparator实时排序元素。有大顶堆和小顶堆存储方式。

  <img src="https://user-gold-cdn.xitu.io/2019/6/16/16b60bf59c20b068?imageView2/0/w/1280/h/960/format/webp/ignore-error/1"     alt="Markdown Monster icon"     style="float: left; margin-right: 10px;" />

#### 1. Largest Rectangle in Histogram #84

栈：左边的棒子都已经遍历过了 ， 只要用一个有序（小->大）的栈存储左边 ， 就能得知左边界的地方 。 



## 作业总结

### 列表类

1. #1 Two Sum (Hash Map)

   Java 中使用hash map: 

   ```Java
   Map<Integer, Integer> map = new HashMap<Integer, Integer>();
   map.containsKey(value); // map中是否找到value的key
   map.get(value); //  获取value的key
   map.put(nums[i], i); //  存入map的键值对
      
   ```

2. #283 Move Zeroes (双指针)

   ```java
   int i, j; // i遍历数组，j指向要记录非零数的位置
   if(i > j) 
      nums[i] = 0;
   // 如果i，j位置重叠 容易造成j位置元素又置为0
   // if(i != j) 运行速度慢 
   ```

3. #26 Remove Duplicates from Sorted Array

   a. 与283类似，定义双指即可

4. #66 Plus One

   ```java
   //  遍历每个元素，只要有一位小于9，这个位加1，就可以return了
   for (int i=digits.length-1; i>=0; i--) {
       if (digits[i] < 9) {
           digits[i]++;
           return digits;
       }
       digits[i] = 0;
   }
   ```

5. #206. Reverse Linked List

   双指针： cur 的 next 指向 pre

   <img src="https://pic.leetcode-cn.com/7d8712af4fbb870537607b1dd95d66c248eb178db4319919c32d9304ee85b602-%E8%BF%AD%E4%BB%A3.gif"     alt="Markdown Monster icon"     style="float: left; margin-right: 10px;" />

   ```java
   ListNode tmp = cur.next;
   cur.next = pre;
   pre = cur;
   cur = tmp;#206. Reverse Linked List
   ```

6. #21. Merge Two Sorted Lists

   [递归版本](https://leetcode-cn.com/problems/merge-two-sorted-lists/solution/die-dai-he-di-gui-ban-ben-dong-tai-tu-xiang-jie-by/)

   - 函数内要做什么：如果l1.val小于l2.val，那么将l1.next指向 l1的后续节点和l2中较小的一个

   - 终止条件比较好理解，函数内做的事情就不那么好懂了，这段话一定要明白：l1的后续节点和l2中较小的一个。
     l1.val<=l2.val后，我们就能确定一个较小的节点了，比如是l1。因为链表还没结束，我们要继续比较，这时候比较的是l1.next和l2。
   - l1.next和l2是在下一层递归函数中处理的，再下一层函数中，也会确定一个较小的节点，我们将这个较小的节点记做x，然后上一层的l1.next就指向这个x节点。

   - 后面就是不断的递归，最终把整个链表给串起来。

**TODO**

7. #88. Merge Sorted Array

8. #641. Design Circular Deque

9. #42. Trapping Rain Water

## 反思

对链表的操作并不熟练，比如节点指向，基础变换操作。

需要刻意练习和理解递归作作用和思路。