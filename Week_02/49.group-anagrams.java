/*
 * @lc app=leetcode id=49 lang=java
 *
 * [49] Group Anagrams
 */

// @lc code=start
class Solution {
    // public List<List<String>> groupAnagrams(String[] strs) {
        
    //     HashMap<String, List<String>> hashMap = new HashMap<>();//根据String把元素放入对应的ListString
    //     List<String> anagramGroup;//组，存放字母一样的单词
    //     for (String curStr : strs) {
    //         String sortedStr = sortLetters(curStr);//每个单词按字母排序
    //         if (hashMap.containsKey(sortedStr)) {//存在该排序后单词的key，则取出value，将curStr插入
    //             anagramGroup = hashMap.get(sortedStr);
    //             anagramGroup.add(curStr);
    //         } else {//不存在该key 则新建一个链表，将curStr add进去，在将该value即list 以sortedStr为key put进去
    //             anagramGroup = new ArrayList<>();
    //             anagramGroup.add(curStr);
    //             hashMap.put(sortedStr, anagramGroup);
    //         }
    //     }
    //     return new ArrayList<>(hashMap.values());
    // }

    // //用于给单词 按字典顺序排序
    // private String sortLetters(String word) {
    //     char[] letters = word.toCharArray();
    //     Arrays.sort(letters);
    //     return new String(letters);
    // }

    public static List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) return new ArrayList();
        Map<String, List> ans = new HashMap<String, List>();
        int[] count = new int[26];
        for (String s : strs) {
            Arrays.fill(count, 0);
            for (char c : s.toCharArray()) count[c - 'a']++;

            StringBuilder sb = new StringBuilder("");
            for (int i = 0; i < 26; i++) {
                sb.append('#');
                sb.append(count[i]);
            }
            String key = sb.toString();
            if (!ans.containsKey(key)) ans.put(key, new ArrayList());
            ans.get(key).add(s);

        }
        return new ArrayList(ans.values());
    }



}
// @lc code=end

