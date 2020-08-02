# 学习笔记

## 课程内容

### 泛型递归



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

