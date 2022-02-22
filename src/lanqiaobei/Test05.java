package lanqiaobei;

/**
 * @author Obamazzz
 * @version 1.0
 */
//        数码管中一共有 7 段可以发光的二极管，分别标记为 a, b, c, d, e, f, g。
//        小蓝要选择一部分二极管（至少要有一个）发光来表达字符。
//        在设计字符的表达时，要求所有发光的二极管是连成一片的。
//        例如：b 发光，其他二极管不发光可以用来表达一种字符。
//        例如：c 发光，其他二极管不发光可以用来表达一种字符。这种方案与上一行的方案可以用来表示不同的字符，尽管看上去比较相似。
//        例如：a, b, c, d, e 发光，f, g 不发光可以用来表达一种字符。
//        例如：b, f 发光，其他二极管不发光则不能用来表达一种字符，因为发光的二极管没有连成一片。
//        请问，小蓝可以用七段码数码管表达多少种不同的字符？80

public class Test05 {
//    思路： dfs搜索所有状态，判断每种状态可不可行。判断的方法是把每条灯管当作一个节点，编号，连边建图，
//    对搜索出的亮灯方案使用并查集判断点亮的灯管是否在同一个集合。
    public static int[] fa = new int[10];
    public static int[] use = new int[10];
    public static int ans;
    public static int[][] e = new int[10][10];
    public static void main(String[] args) {
        /*
		连边建图，e[i][j]==1表示i和j相邻
		a b c d e f g
		1 2 3 4 5 6 7
	*/
        for (int i = 0; i < e.length; i++) {
            for (int j = 0; j < e[i].length; j++) {
                e[i][j] = 0;
            }
        }
        e[1][2] = 1;
        e[1][6] = 1;
        e[2][1] = 1;
        e[2][7] = 1;
        e[2][3] = 1;
        e[3][2] = 1;
        e[3][4] = 1;
        e[3][7] = 1;
        e[4][3] = 1;
        e[4][5] = 1;
        e[5][4] = 1;
        e[5][6] = 1;
        e[5][7] = 1;
        e[6][1] = 1;
        e[6][5] = 1;
        e[6][7] = 1;
//        for (int[] i : e) {
//            for (int j : i) {
//                System.out.print(j + " ");
//            }
//            System.out.println();
//        }
        dfs(1);
        System.out.println(ans);//80
    }

    public static int find(int u) {
        if (fa[u] == u)
            return u;
        fa[u] = find(fa[u]);
        return fa[u];
    }//并查集

    public static void dfs(int d) {
        if (d > 7) {
            /* 并查集判是否在同一集合 */
            for (int i = 1; i <= 7; i++) fa[i] = i;//初始化父亲集合
            for (int i = 1; i <= 7; i++)//遍历所有边集
                for (int j = 1; j <= 7; j++)
                    if (e[i][j] * use[i] * use[j] == 1) {
                        int fx = find(i), fy = find(j);
                        if (fx != fy) fa[fx] = fy;//如果不在同一集合,合并
                    }
            int k = 0;
            for (int i = 1; i <= 7; i++)
                if (use[i] * fa[i] == i)
                    k++;
            if (k == 1)
                ans++;//如果所有亮灯都属于同一个集合
            return ;
        }
        use[d]=1;//打开d这个灯，继续开关下一个灯
        dfs(d+1);
        use[d]=0;//关闭d这个灯，继续开关下一个灯
        dfs(d+1);
    }
}
