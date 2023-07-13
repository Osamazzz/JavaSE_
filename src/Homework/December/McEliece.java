package Homework.December;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//import Jama.Matrix;
//
//public class McEliece {
//    private static Matrix G;
//    private static Matrix H;
//    private static Matrix S;
//    private static Matrix P;
//    private static Matrix G1;
//    private static Matrix e;
//    private static Matrix y;
//    private static Matrix y1;
//    private static Matrix x1;
//    private static Matrix x0;
//    private static Matrix x;
//    private final static int LENGTH = 4;
//
//    public void generator(int type) {
//        double[][] array = null;
//        double[][] arrayH = null;
//        if (type == 1) {
//            array = new double[][] { { 1, 0, 0, 0, 1, 1, 0 },
//                    { 0, 1, 0, 0, 1, 0, 1 }, { 0, 0, 1, 0, 0, 1, 1 },
//                    { 0, 0, 0, 1, 1, 1, 1 } };
//            arrayH = new double[][] { { 1, 1, 0 }, { 1, 0, 1 }, { 0, 1, 1 },
//                    { 1, 1, 1 }, { 1, 0, 0 }, { 0, 1, 0 }, { 0, 0, 1 } };
//        }
//        G = new Matrix(array);
//        H = new Matrix(arrayH);
//    }
//
//    public void CreateSandP() {
//        double[][] array = { { 1, 0, 0, 1 }, { 1, 1, 0, 1 }, { 0, 1, 0, 1 },
//                { 1, 1, 1, 0 } };
//        S = new Matrix(array);
//        double[][] array1 = { { 0, 0, 1, 0, 0, 0, 0 }, { 1, 0, 0, 0, 0, 0, 0 },
//                { 0, 0, 0, 0, 1, 0, 0 }, { 0, 0, 0, 0, 0, 1, 0 },
//                { 0, 0, 0, 0, 0, 0, 1 }, { 0, 1, 0, 0, 0, 0, 0 },
//                { 0, 0, 0, 1, 0, 0, 0 } };
//        P = new Matrix(array1);
//    }
//
//    private void Mod2(Matrix ma) {
//        for (int i = 0; i < ma.getRowDimension(); i++)
//            for (int j = 0; j < ma.getColumnDimension(); j++)
//                ma.set(i, j, Math.abs(((int) ma.get(i, j)) % 2));
//    }
//
//    public void CaculateG1() {
//        G1 = S.times(G).times(P);
//        Mod2(G1);
//    }
//
//    public void GenerErrorVector() {
//        double[][] array = { { 0, 1, 0, 0, 0, 0, 0 } };
//        e = new Matrix(array);
//    }
//
//    public void CaculateCiphertext() {
//        y = x.times(G1).plus(e);
//        Mod2(y);
//    }
//
//    public void decrypt() {
//        int ErrorPosition = 0;
//        y1 = y.times(P.inverse());
//        Mod2(y1);
//        Matrix Syndrome = y1.times(H);// 计算得到校验子
//        Mod2(Syndrome);
//        // 与校验矩阵对比，进行校正
//        for (int i = 0; i < H.getRowDimension(); i++) {
//            boolean flag = true;
//            for (int j = 0; j < H.getColumnDimension() && flag; j++) {
//                if (H.get(i, j) != Syndrome.get(0, j))
//                    flag = false;
//            }
//            if (flag) {
//                ErrorPosition = i;
//                break;
//            }
//        }
//        System.out.println("错误的位置：" + ErrorPosition);
//        x1 = y1.copy();
//        x1.set(0, ErrorPosition,
//                (double) ((int) (y1.get(0, ErrorPosition)) + 1) % 2);
//        System.out.print("x1矩阵如下");
//        x1.print(0, 0);
//        x0 = x1.getMatrix(0, 0, 0, LENGTH - 1);
//        System.out.print("x0矩阵如下");
//        x0.print(0, 0);
//        System.out.print("解密得到明文：");
//        x = x0.times(S.inverse());
//        Mod2(x);
//        x.print(0, 0);
//    }
//
//    // test
//    public static void main(String args[]) {
//        /**
//         * 生成矩阵 这里我们使用2种hamming码
//         */
//        McEliece test = new McEliece();
//        test.generator(1);
//
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        test.CreateSandP();
//        test.CaculateG1();
//        test.GenerErrorVector();
//        System.out.print("G1矩阵(公钥)：如下");
//        G1.print(0, 0);
//        System.out.print("e矩阵：如下");
//        e.print(0, 0);
//
//        System.out.println("传输信息:");// 明文
//        try {
//            String secret = br.readLine();
//
//            double[][] array_x = new double[1][LENGTH];
//            for (int i = 0; i < LENGTH; i++) {
//                array_x[0][i] = Double.parseDouble(secret.charAt(i) + "");
//            }
//
//            x = new Matrix(array_x);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        long startTime = System.currentTimeMillis();
//        // 计算得到的密文
//        test.CaculateCiphertext();
//        System.out.print("得到的密文：如下");
//        y.print(0, 0);
//        // 解密
//        System.out.print("Bob解密结果如下");
//        test.decrypt();
//        long endTime = System.currentTimeMillis();
//        //long类型时间差，单位毫秒
//        long timeLong = endTime - startTime;
//        //long类型时间差转为double类型时间差，单位毫秒
//        double timeDouble= Double.parseDouble(Long.toString(timeLong));
//        System.out.println("该算法执行时间为" + timeDouble+ "毫秒，即" + timeDouble/(double)1000 + "秒");
//    }
//
//}