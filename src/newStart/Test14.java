package newStart;

import DS.BinaryTree_.TreeNode;

import javax.print.DocFlavor;
import java.util.*;

public class Test14 {
    public static void main(String[] args) {
        Solution3 solution3 = new Solution3();
        System.out.println(solution3.countWays(new int[][]{{1, 3}, {10, 20}, {2, 5}, {4, 8}}));
    }

    public String[] getFolderNames(String[] names) {
        int len = names.length;
        String[] res = new String[len];
        //创造字典,String为存储的name,Integer为若重名后需要添加的K
        HashMap<String, Integer> dic = new HashMap<>();
        //遍历names
        for (int i = 0; i < len; i++) {
            //取出当前字符串
            String name = names[i];
            if (!dic.containsKey(name)) {
                //如果dic中不存在name,则直接输出结果到res,并添加到字典中
                res[i] = name;
                dic.put(name, 1);
            } else {
                //否则取出当前的K
                int k = dic.get(name);
                //同时查找添加后缀名后的文件名是否存在
                while (dic.containsKey(addSuffix(name, k))) {
                    k++;
                }
                //输出结果
                res[i] = addSuffix(name, k);
                //增加添加了后缀名的文件到dic中
                dic.put(addSuffix(name, k), 1);
                //更新k的值
                dic.put(name, k + 1);
            }
        }
        return res;
    }

    public String addSuffix(String name, int k) {
        return name + "(" + k + ")";
    }


    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 1 || nums.length == 0) return nums;
        //构造result数组
        int[] res = new int[nums.length - k + 1];
        MyQueue myQueue = new MyQueue();
        for (int i = 0; i < k; i++) {
            myQueue.push(nums[i]);
        }
        int count = 0;
        res[count++] = myQueue.getMax();
        for (int i = k; i < nums.length; i++) {
            myQueue.pop(nums[i - k]);
            myQueue.push(nums[i]);
            res[count++] = myQueue.getMax();
        }
        return res;
    }

}

class MyQueue {
    Deque<Integer> deque = new LinkedList<>();

    public void pop(int val) {
        //如果要弹出的是最大值
        if (!deque.isEmpty() && val == deque.peek()) {
            deque.poll();
        }
    }

    public void push(int val) {
        //若要加入队列的值比队尾的大
        while (!deque.isEmpty() && val > deque.getLast()) {
            deque.removeLast();
        }
        //添加到队尾
        deque.offer(val);
    }

    public int getMax() {
        if (!deque.isEmpty()) return deque.peek();
        return -1;
    }
}

class MaxQueue {
    //deque为单调队列,queue为真正的队列
    Deque<Integer> deque;
    Queue<Integer> queue;

    public MaxQueue() {
        queue = new LinkedList<>();
        deque = new LinkedList<>();
    }

    public int max_value() {
        if (queue.isEmpty() || deque.isEmpty()) return -1;
        return deque.peek();
    }

    public void push_back(int value) {
        while (!deque.isEmpty() && value > deque.getLast()) {
            deque.removeLast();
        }
        deque.offer(value);
        queue.offer(value);
    }

    public int pop_front() {
        if (queue.isEmpty()) return -1;
        int res = queue.poll();
        //若弹出的元素刚好是单调队列的队首元素
        if (!deque.isEmpty() && deque.peek() == res) {
            deque.poll();
        }
        return res;
    }


    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int count = 0;
        //模拟出入栈序列
        for (int num : pushed) {
            stack.push(num);
            while (!stack.isEmpty() && stack.peek() == popped[count]) {
                stack.pop();
                count++;
            }
        }
        return stack.isEmpty();
    }
}

class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "[]";
        StringBuilder res = new StringBuilder();
        res.append("[");
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (cur != null) {
                res.append(cur.val).append(",");
                //添加左右子树
                queue.offer(cur.left);
                queue.offer(cur.right);
            } else {
                res.append("null,");
            }
        }
        //去掉最后一个,
        res.deleteCharAt(res.length() - 1);
        res.append("]");
        return res.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("[]")) return null;
        String[] strings = data.substring(1, data.length() - 1).split(",");
        int index = 1;
        LinkedList<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(strings[0]));
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            //若不为null
            if (!strings[index].equals("null")) {
                TreeNode left = new TreeNode(Integer.parseInt(strings[index++]));
                cur.left = left;
                queue.offer(left);
            }
            if (!strings[index].equals("null")) {
                TreeNode right = new TreeNode(Integer.parseInt(strings[index++]));
                cur.right = right;
                queue.offer(right);
            }
        }
        return root;
    }

    public int splitNum(int num) {
        String str = "" + num;
        char[] chs = str.toCharArray();
        Arrays.sort(chs);
        int[] arr = new int[chs.length];
        int ans = 0;
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        //如果长度为偶数
//        if ((chs.length & 1) == 0) {
//
//        } else {
//
//        }
        for (int i = 0; i < chs.length; i += 2) {
            sb1.append(chs[i]);
        }
        for (int i = 1; i < chs.length; i += 2) {
            sb2.append(chs[i]);
        }
        return Integer.parseInt(sb1.toString()) + Integer.parseInt(sb2.toString());
    }
}

class Solution3 {
    public int countWays(int[][] ranges) {
        ArrayList<ArrayList<int[]>> groups = new ArrayList<>();
        ArrayList<int[]> temp = new ArrayList<>();
        temp.add(ranges[0]);
        groups.add(temp);
        for (int i = 1; i < ranges.length; i++) {
            int[] tmp = ranges[i];
            for (int j = 0; j < groups.size(); j++) {
                //取出一个组
                ArrayList<int[]> group = groups.get(j);
                boolean flag = false;
                for (int k = 0; k < group.size(); k++) {
                    if (tmp[0] < group.get(k)[1] && tmp[1] > group.get(k)[0]) {
                        group.add(tmp);
                        flag = true;
                        break;
                    }
                }
                if (!flag) {
                    //一轮下来没有加入旧的组
                    ArrayList<int[]> newGroup = new ArrayList<>();
                    newGroup.add(tmp);
                    groups.add(newGroup);
                } else {
                    break;
                }
            }
        }
        if (groups.size() == 1) return 2;
        int res = 1;

        return (int) ((groups.size() + 2) % (10E9 + 7));
    }

}


interface AB extends Bc, AAA {

}

class aaaaa implements AB {
    
}

interface Bc {
}

interface AAA {
}