# 学习笔记

## 上课内容

### 深搜广搜



### 贪心算法

| 贪心                                         | 动规                                                         | 回溯     |
| :------------------------------------------- | ------------------------------------------------------------ | -------- |
| 每一步选择中采取在当前状态下最好或最优的选择 |                                                              |          |
| 对每一个子问题的解决方案都做出选择不能回退   | **保存**以前运算的结果，并根据以前的结果对当前进行选择，可以**回退** | 能够回退 |

适用贪心算法的场景：问题能够分解成子问题来解决，子问题的最优解能递推到最终问题的最优解。这种子问题最优解成为最优子结构。

- 证明局部最优解就是全局最优解
- 可能从后往前贪心，也可能从某个地方切入贪心

#### [455. 分发饼干](https://leetcode-cn.com/problems/assign-cookies/)

```java
public int findContentChildren(int[] g, int[] s) {
    int res = 0;
    Arrays.sort(g);
    Arrays.sort(s);
    int i = 0, j = 0;
    // 双指针
    while (i < g.length && j < s.length) {
        // 分量满足目前小朋友
        if (g[i] <= s[j]) {
            res++;
            i++;
            j++;
        }
        else {
        // 分量不满足
            j++;
        }
    }
    return res;
}
```

#### [122. 买卖股票的最佳时机 II](https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/)

```java
public int maxProfit(int[] prices) {
    // 只要后一个数字大于前一个数字就可以买入
    int amount = 0;
    for (int i = 0; i < prices.length-1; i++) 
        if (prices[i] < prices[i+1]) amount += prices[i+1] - prices[i];
    return amount;
}
```

#### [55. 跳跃游戏](https://leetcode-cn.com/problems/jump-game/)

```java
public boolean canJump(int[] nums) {
    int endPoint = nums.length - 1;
    for (int i = nums.length - 1; i >= 0; i--)
        if (nums[i] + i >= endPoint) endPoint = i;
    return endPoint == 0;
}
```

### 二分查找

1. 目标函数单调性
2. 上下界
3. 索引

```java
public int binarySearch(int[] array, int target) {
    int left = 0, right = array.length - 1, mid;
    while (left <= right) {
        mid = (right - left) / 2 + left;
        if (array[mid] == target) {
            return mid;
        } else if (array[mid] > target) {
            right = mid - 1;
        } else {
            left = mid + 1;
        }
    }
    return -1;
}
```

#### [69. x 的平方根](https://leetcode-cn.com/problems/sqrtx/)



## 作业

#### [33. 搜索旋转排序数组](https://leetcode-cn.com/problems/search-in-rotated-sorted-array/)

二分法：对于不是严格意义的数组如何查找index。比较low，mid，high得出哪一部分是有序的。



#### [860. 柠檬水找零](https://leetcode-cn.com/problems/lemonade-change/)

```java
// 优先使用10元而不是5元
public boolean lemonadeChange(int[] bills) {
    int fiveCounts = 0, tenCounts = 0;
    for (int i = 0; i < bills.length; i++) {
        if (bills[i] == 5) {
            fiveCounts++;
        } else if (bills[i] == 10) {
            if (fiveCounts > 0) {
                fiveCounts--;
                tenCounts++;
            } else return false;
        } else {
            if (tenCounts > 0 && fiveCounts > 0) {
                tenCounts--;
                fiveCounts--;
            }
            else if (fiveCounts > 2) fiveCounts -= 3;
            else return false;
        }
    }
    return true;
}
```

