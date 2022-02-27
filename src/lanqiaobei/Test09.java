package lanqiaobei;

import java.util.*;
/**
 * @author Obamazzz
 * @version 1.0
 */
public class Test09 {
    final static int N = 20, M = 21;
    //	static int N = 2, M = 3;
    static Line[] q = new Line[1000000];
    final static double esp = 10E-8;
    //计算斜率
    public static double getK(int x1, int y1, int x2, int y2) {
        return (double) (y1 - y2) /(x1 - x2) ;
    }
    public static void main(String[] args) {
//        在平面直角坐标系中，两点可以确定一条直线。如果有多点在一条直线上， 那么这些点中任意两点确定的直线是同一条。
//        给定平面上 2 × 3 个整点{(x, y)|0 ≤ x < 2, 0 ≤ y < 3, x ∈ Z, y ∈ Z}(x,y)∣0≤x<2,0≤y<3,x∈Z,y∈Z
//        ，即横坐标 是 0 到 1 (包含 0 和 1) 之间的整数、纵坐标是 0 到 2 (包含 0 和 2) 之间的整数 的点。这些点一共确定了 11 条不同的直线。
//        给定平面上 20×21 个整点 {(x, y)|0 ≤ x < 20, 0 ≤ y < 21, x ∈ Z, y ∈ Z}(x,y)∣0≤x<20,0≤y<21,x∈Z,y∈Z，即横坐标是 0 到 19
//        (包含 0 和 19) 之间的整数、纵坐标是 0 到 20 (包含 0 和 20) 之 间的整数的点。请问这些点一共确定了多少条不同的直线。
        int t = 0;
        for(int i = 0; i < N; i ++) {
            for(int j = 0; j < M; j ++) {
                //(i, j) --> (x, y)
                for(int x = 0; x < N; x ++) {
                    if( i == x)
                        continue;
                    for(int y = 0; y < M; y ++) {
                        if( y == j)
                            continue;
                        double k = getK(i, j, x, y);
                        double b = j - k * i;
                        q[t++] = new Line(k, b);
                    }
                }
            }
        }
        //排序
        Arrays.sort(q, 0, t);

        int res = 1; //k ：{1,1,2,2,3,3}  {1,2,3}
        for( int i = 1; i < t; i ++)
            if( Math.abs(q[i].k - q[i - 1].k ) > esp || Math.abs(q[i].b - q[i - 1].b ) > esp)
                res++;
        System.out.println(res + N + M);
    }
}
class Line implements Comparable<Line>{
    double k, b;
    public Line(double kk, double bb){
        this.k = kk;
        this.b = bb;
    }
    @Override
    public int compareTo(Line o) {
        if( Double.compare(this.k, o.k) == 0 ) return Double.compare(this.b, o.b);
        return Double.compare(this.k, o.k);
    }
}
