package newStart;

import DS.BinaryTree_.TreeNode;

import java.util.*;


public class Test12 {
    public static void main(String[] args) {
        int[] res = new MedianFinder().spiralOrder(new int[][]{{1,2,3},{4,5,6},{7,8,9}});
    }

    public String minNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++)
            strs[i] = String.valueOf(nums[i]);
        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o1 + o2).compareTo(o2 + o1);
            }
        });
        StringBuilder res = new StringBuilder();
        for (String s : strs)
            res.append(s);
        return res.toString();
    }

    public int[] getLeastNumbers(int[] arr, int k) {
        Arrays.sort(arr);
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = arr[i];
        }
        return ans;
    }
}

class MedianFinder {
    Queue<Integer> A, B;

    public MedianFinder() {
        A = new PriorityQueue<>(); // 小顶堆，保存较大的一半
        B = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        }); // 大顶堆，保存较小的一半
    }

    public void addNum(int num) {
        if (A.size() != B.size()) {
            A.add(num);
            B.add(A.poll());
        } else {
            B.add(num);
            A.add(B.poll());
        }
    }

    public double findMedian() {
        if (A.size() != 0 || B.size() != 0)
            return A.size() != B.size() ? A.peek() : (A.peek() + B.peek()) / 2.0;
        return 0;
    }

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        return recur(root) != -1;
    }

    public int recur(TreeNode root) {
        if (root == null) return 0;
        int leftDepth = recur(root.left);
        int rightDepth = recur(root.right);
        if (leftDepth == -1 || rightDepth == -1) return -1;
        if (Math.abs(leftDepth - rightDepth) <= 1) return 1 + Math.max(leftDepth, rightDepth);
        else return -1;
    }

//    public int recur(TreeNode treeNode) {
//        if (treeNode == null) return 0;
//        return 1 +
//     }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> map = new HashMap<>();
        // 构造map,便于获取中序序列的索引
        for (int i = 0; i < preorder.length; i++) {
            map.put(inorder[i], i);
        }
        return recur(0, 0, inorder.length - 1, preorder, map);
    }


    //  root为根节点在前序序列中的索引,left为在中序序列中的左边界,right为在中序序列中的右边界
    public TreeNode recur(int root, int left, int right, int[] preorder, HashMap<Integer, Integer> map) {
        if (left > right) return null;
        TreeNode node = new TreeNode(preorder[root]);
        //获取root在中序序列中的索引
        int index = map.get(preorder[root]);
        node.left = recur(root + 1, left, index - 1, preorder, map);
        node.right = recur(root + 1 + index - left, index + 1, right, preorder, map);
        return node;
    }

    public double myPow(double x, int n) {
        double res = x;
        for (int i = 0; i < n; i++) {
            res = res * res;
        }
        return res;
    }

    List<List<Integer>> res;
    HashMap<Integer, Integer> dic;

    public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        res = new ArrayList<>();
        dic = new HashMap<>();
        //构建map存放value-weight对，并合并
        if (items1.length > items2.length) {
            for (int i = 0; i < items1.length; i++) {
                dic.put(items1[i][0], items1[i][1]);
            }
            for (int i = 0; i < items2.length; i++) {
                int weight = dic.getOrDefault(items2[i][0], -1);
                if (weight != -1) {
                    dic.put(items2[i][0], weight + items2[i][1]);
                } else {
                    dic.put(items2[i][0], items2[i][1]);
                }
            }
        } else {
            for (int i = 0; i < items2.length; i++) {
                dic.put(items2[i][0], items2[i][1]);
            }
            for (int i = 0; i < items1.length; i++) {
                int weight = dic.getOrDefault(items1[i][0], -1);
                if (weight != -1) {
                    dic.put(items1[i][0], weight + items1[i][1]);
                } else {
                    dic.put(items1[i][0], items1[i][1]);
                }
            }
        }
        Set<Map.Entry<Integer, Integer>> entrySet = dic.entrySet();
        for (Map.Entry<Integer, Integer> entry : entrySet) {
            ArrayList<Integer> tmp = new ArrayList<>();
            tmp.add(entry.getKey());
            tmp.add(entry.getValue());
            res.add(tmp);
        }
        res.sort(new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                return o1.get(0) - o2.get(0);
            }
        });
        return res;
    }

    public int[][] findContinuousSequence(int target) {
        List<int[]> res = new ArrayList<>();
        int left = 1, right = 2;
        int sum = left + right;
        while (left < right) {
            if (sum == target) {
                // 记录结果
                int[] temp = new int[right - left + 1];
                for (int i = left; i <= right; i++) {
                    temp[i - left] = i;
                }
                res.add(temp);
            }
            if (sum >= target) {
                //继续往前搜
                sum -= left;
                left++;
            } else {
                right++;
                sum += right;
            }
        }
        return res.toArray(new int[res.size()][]);
    }

    public int[] spiralOrder(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int[] res = new int[row * col];
        int i = 0, j = 0;//matrix的索引
        int k = 0;//res的索引
        int top = 0, bottom = row - 1;
        int left = 0, right = col - 1;
        int direction = 0;//方向:0为右，1为下，2为左，3为上
        while(k < res.length) {
            switch(direction) {
                case 0:
                    while(j <= right) {
                        res[k++] = matrix[i][j++];
                    }
                    j--;
                    top++;
                    direction = 1;
                    break;
                case 1:
                    while(i <= bottom) {
                        res[k++] = matrix[i++][j];
                    }
                    i--;
                    right--;
                    direction = 2;
                    break;
                case 2:
                    while(j >= left) {
                        res[k++] = matrix[i][j--];
                    }
                    j++;
                    bottom--;
                    direction = 3;
                    break;
                case 3:
                    while(i >= top) {
                        res[k++] = matrix[i--][j];
                    }
                    i++;
                    left++;
                    direction = 0;
                    break;
            }
        }
        return res;
    }
}

