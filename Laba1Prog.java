import java.util.Random;
import java.lang.Math;

public class Laba1Prog{
    public static void main (String[] args) {

        System.out.println("Задание №1");
        for (long el : oddArray()){
            System.out.print(el + " ");
        }

        System.out.println();

        System.out.println("Задание №2");
        for (float el : floatArray()){
            System.out.print(el + " ");
        }
        System.out.println();

        System.out.println("Задание №3");
        double[][] array = twoDimArray();
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.printf("%12.4f", array[i][j]);
            }
            System.out.println();
        }
    }

    static long[] oddArray () {
        long[] c = new long[8];
        int index = 0;
        for (int i = 15;i >= 1; i--) {
            if (i % 2 != 0){
                c[index] = i;
                index++;
            }
        }
        return c;
    }

    static float[] floatArray() {
        float[] x = new float[10];
        float max = 6.0f;
        float min = -6.0f;
        Random rnd = new Random();

        for (int i = 0;i<x.length;i++) {
            x[i] = rnd.nextFloat(min,max);
        }
        return x;
    }

    static double[][] twoDimArray () {
        double[][] arr = new double[8][10];
        long[] c = oddArray();
        float[] xArr = floatArray();

        for (int i = 0;i < c.length;i++){
            for (int j = 0;j < 10;j++) {
                float x = xArr[j];
                switch ((int) c[i]){
                    case 13:
                        arr[i][j] = Math.cos(Math.pow(((0.25*Math.pow(x + 1,2))/2),3));
                        break;
                    case 1,5,9,15:
                        arr[i][j] =Math.asin(Math.pow(Math.pow((x/12),2),2));
                        break;
                    default:
                        arr[i][j] = mathFormula(x);
                        break;
                }
            }
        }
        return arr;
    }

    static double mathFormula (float x) {
        double res;
        if (x <= 0) {
            res = (1 - (Math.pow(Math.cbrt(-Math.pow(Math.abs(x), x / Math.PI)), 2))) / 1 / 3;
            if (res <= 0){
                res = -Math.pow(Math.abs(res),Math.pow(Math.E, Math.pow(Math.E, Math.log10(Math.abs(x)))));
            }
            else {
                res = Math.pow(res,Math.pow(Math.E, Math.pow(Math.E, Math.log10(Math.abs(x)))));
            }
        }
        else {
            res = (1 - (Math.pow(Math.cbrt(Math.pow(x, x / Math.PI)), 2))) / 1 / 3;
            if (res <= 0) {
                res = -Math.pow(Math.abs(res),Math.pow(Math.E, Math.pow(Math.E, Math.log10(Math.abs(x)))));
            }
            else {
                res = Math.pow(res,Math.pow(Math.E, Math.pow(Math.E, Math.log10(Math.abs(x)))));
            }
        }
        return res;
    }

}