# 学习笔记

## 课程内容

### 泛型递归

1. 不要人肉递归 直接看函数写
2. 找最近重复子问题

```java
public void recur(int level, int param) { 
  // terminator 
  if (level > MAX_LEVEL) { 
    // process result 
    return; 
  }
  // process current logic 
  process(level, param); 
  // drill down 
  recur( level: level + 1, newParam); 
  // restore current status 
}
```



### 分治回溯

碰到一个题目就寻找其重复性 最近重复性（递归） 最优重复性（动规）

```java
private static int divide_conquer(Problem problem, ) {
  
  if (problem == NULL) {
    int res = process_last_result();
    return res;     
  }
  // 准备子问题
  subProblems = split_problem(problem)
  // drill down
  res0 = divide_conquer(subProblems[0])
  res1 = divide_conquer(subProblems[1])
  // conquer
  result = process_result(res0, res1);
  
  // revert the current level states  
    
  return result;
}
```

#### [50. Pow(x, n)](https://leetcode-cn.com/problems/powx-n/)

审题：a) x，n范围 b) x，n整数？

```
2^10 --> 2^5 --> 2^2 * 2
pow(x, n):
	subproblem: subresult = pow(x, n/2)
merge:
	if n % 2 == 1 : result = subresult * subresult * x
	else : result = subresult * subresult	
```

## 作业

#### [236. 二叉树的最近公共祖先](https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/)

此解法很简洁，但是目前似懂非懂，需要回头看[说明](https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/solution/236-er-cha-shu-de-zui-jin-gong-gong-zu-xian-hou-xu/)。

![Picture2.png](https://pic.leetcode-cn.com/e48705d412500d43fa81c1d8fdd107bb2d0c7dfa12bdc588cd88f481b4b9f7d8-Picture2.png)

```java
public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null && right == null) return null; // root 左右子树不包含left right
        if (left == null) return right;
        if (right == null) return left;
        return root;
    }
```

#### [46. 全排列](https://leetcode-cn.com/problems/permutations/)

![img](https://pic.leetcode-cn.com/6a464ba95a7ad1c247aa39610535984c241e6b95148f8bc36b02908a190b1d54-image.png)