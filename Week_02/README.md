# 学习笔记

## 上课内容

### 第五课

[Map](https://docs.oracle.com/en/java/javase/12/docs/api/java.base/java/util/Map.html): key-value (key 不重复)

```java
new HashMap() / new TreeMap()
map.put(key, value)
map.set(key, value)
map.set(key)
map.has(key)
map.size()
map.clear()
```

[Set](https://docs.oracle.com/en/java/javase/12/docs/api/java.base/java/util/Set.html): 不重复元素

```java
new HashSet() / new TreeSet()
set.add(value)
set.delet(value)
set.has(value)
```

### 第六课

#### 树

二叉搜索树(Binary Search Tree)： 1). 左子树上**所有结点**的值均小于它的根结点的值。2). 右子树上**所有结点**的值均大于它的根结点的值。3). 左右子树也分别为二叉查找树。

树的遍历： 1). 前序：根-左-右。2). 中序：左-根-右。2). 后序：左-右-根。

<img src="https://pic.leetcode-cn.com/bd95aab8e74b7b999fc7cc826fd01377b6c5ed95ff1dd54ff43085b022293f36-file_1587549768626"     alt="Markdown Monster icon"     style="float: left; margin-right: 10px;" />

[94. Binary Tree Inorder Traversal](https://leetcode.com/problems/binary-tree-inorder-traversal/)

```java
// 递归 左中右
 public void inorder(TreeNode root, List<Integer>res) {
     if(root==null)
     return;
     inorder(root.left, res);
     res.add(root.val);
     inorder(root.right, res);
}
// ==================================================================
// 栈的方式模拟树的遍历 总是找到树的最左边结点
// 栈 迭代
Stack<TreeNode> stack = new Stack<>();        
// 定义指针遍历
TreeNode cur = root;
// 指针不能和栈同时为空
while(!stack.isEmpty() || cur!=null) {
    // 找到树的最左边的叶子
    while(cur != null) {
        stack.push(cur);
        cur = cur.left;
    }
    // 如果此时指针指向的是最左边的叶子，则先输出
    // 如果不是，则说明找到了之前经历过的中间的root的位置，同样将其输出
    // 并进一步把指针指向root的右子树
    TreeNode node = stack.pop();
    res.add(node.val);
    cur = node.right;
}
```

#### [堆](https://shimo.im/docs/Lw86vJzOGOMpWZz2/read)

**Heap**：找最大值或者最小值。有二叉堆、斐波那契堆（多叉树）···

1. 二叉堆一般通过“数组”实现
2. 假设“第一个元素”在数组中的索引为0的话，则父结点和子结点的位置关系：
   - 索引为i的左孩子的索引是(2*i+1)
   - 索引为i的右孩子的索引是(2*i+2)
   - 索引为i的父结点的索引是floor((i-1)/2)

**Insert（HeapifyUp）**

1. 新元素一律先插入到堆的尾部
2. 依次向上调整整个堆的结构（一直到根）（维护堆的结构：最大或最小堆）（与自己父亲结点作比较、交换）

**Delete Max（HeapifyDown）**

1. 将堆尾元素替换到顶部（即对顶被替代删除掉）
2. 依次从根部向下调整整个堆的结构（一直到堆尾即可）

[剑指 Offer 40. 最小的k个数](https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof/)

```java
PriorityQueue<Integer> heap = new PriorityQueue<>(); // 直接声明堆
for (int i = 0; i < arr.length; i++) {
    heap.add(arr[i]);
}
```

[293. Sliding Window Maximum](https://leetcode.com/problems/sliding-window-maximum/)

```java
// 双端队列


//==============================================
// 大顶堆 （少量数据可用）
int n = nums.length;
int [] result = new int[n - k + 1];

PriorityQueue<Integer> maxPQ = new PriorityQueue<>((o1, o2) -> (o2 - o1));

for (int i = 0; i < n; i++) {
    int start = i - k;
    if (start >= 0) {
        maxPQ.remove(nums[start]);
    }

    maxPQ.offer(nums[i]);
    if (maxPQ.size() == k) {
        result[i - k + 1] = maxPQ.peek();
    }
}
return result;
```

#### 图 —— **visit = set()**

- DFS
- BFS

## 作业

[49. Group Anagrams](https://leetcode.com/problems/group-anagrams/)

```java
// 把异位字符串排序并用作key
for s in strings：
    char[] ca = s.toCharArray();  // 将字符串转换成可排序的字符数组
    Arrays.sort(ca);
    String key = String.valueOf(ca);  // 删除头尾空白符的字符串，转换回字符串
    if (!ans.containsKey(key))	// 利用HashMap构建key-array
        ans.put(key, new ArrayList());  
    ans.get(key).add(s);  // 往对应的key的array添加字符串
//=======================================================
//  统计异位字符的每个字母频率作为key
int[] counts = new int[26];
for s in strings：
    Arrays.fill(counts, 0);	// 对于每一个字符串 初始化它的计数数组
	for c in s:
		counts[c-'a']++;	// 开始统计每个字母频率
	StringBuilder sb = new StringBuilder("");
	for i in [0:26]:
		sb.append('#');
		sb.append(count[i]);	// 构建散列化的key
	key = sb.toString();
	if(map not contains(key))
        map.put(key, new ArrayList()):
	map.get(key).add(s)			// 把异位字符串添加到对应key的list中
```

[589.N-ary Tree Preorder Traversal](https://leetcode.com/problems/n-ary-tree-preorder-traversal/description/)

```java
// 递归
private void preOrder(Node root, List<Integer> res)
{
    if(root == null)
    return;
    res.add(root.val);
    for(int i=0; i<root.children.size(); i++) {
    	preOrder(root.children.get(i), res);
    }
}
// ==================================================================
// 栈 迭代 后进先出
List<Integer> res = new ArrayList<>();
if(root==null)
    return res;
Stack<Node>stack = new Stack<>();
stack.push(root);
while(!stack.isEmpty()) {
    Node pop = stack.pop(); // 探索父结点是否有子结点
    res.add(pop.val);
    for(int i=pop.children.size()-1; i>=0; i--)  // 将子结点从右到左入列
        stack.push(pop.children.get(i));
}
return res;
```



## 总结

学会使用Java自带的Map ，Set的API。

每道题都会有对树的定义的类，在做题之前需要理解类的属性。



