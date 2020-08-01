# 学习笔记

## 上课内容

### 深搜广搜



### 贪心算法



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