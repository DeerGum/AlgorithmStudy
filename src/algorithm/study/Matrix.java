package algorithm.study;

import java.util.Random;

public class Matrix {

	public static final int THRESHOLD = 32;
	public static int mulCount = 0;
	public static void main(String[] args) {
		
		Random r = new Random();
		int[] n = {64, 256, 512};
		
		int[][] a;
		int[][] b;
		int[][] c;
		long startTime, endTime;
		for(int k=0;k<n.length;k++) {
			a = new int[n[k]][n[k]];
			b = new int[n[k]][n[k]];
			//init matrix
			for(int i=0;i<n[k];i++) {
				for(int j=0;j<n[k];j++) {
					a[i][j] = r.nextInt(4);
					b[i][j] = r.nextInt(4);
				}
			}
			System.out.println("#########################################");
			System.out.println(+n[k]+" x "+n[k]+" Matirx");
			System.out.println("Recursive multiplication");
			startTime = System.currentTimeMillis();
			c = recurMat(n[k],a,b);
			endTime = System.currentTimeMillis();
			System.out.println(" delay : "+(endTime-startTime)/1000.0+"s");
			System.out.println(" multiplication count : "+mulCount);
			mulCount = 0;
			
			System.out.println("Strassen multiplication");
			startTime = System.currentTimeMillis();
			c = strassenMat(n[k],a,b);
			endTime = System.currentTimeMillis();
			System.out.println(" delay : "+(endTime-startTime)/1000.0+"s");
			System.out.println(" multiplication count : "+mulCount);
			System.out.println("#########################################");
			System.out.println();
			mulCount = 0;
		}
	}
	
	public static int[][] recurMat(int n, int[][] a, int[][] b) {
		
		if(n==1) {
			int[][] result = new int[1][1];
			result[0][0] = a[0][0] * b[0][0];
			mulCount++;
			return result;
		}
		else {
			int[][] a11 = new int[n/2][n/2], a12 = new int[n/2][n/2], a21 = new int[n/2][n/2], a22 = new int[n/2][n/2];
			int[][] b11 = new int[n/2][n/2], b12 = new int[n/2][n/2], b21 = new int[n/2][n/2], b22 = new int[n/2][n/2];
			
			splitMat(a, b, a11, a12, a21, a22, b11, b12, b21, b22);
			
			int[][] c11 = addMat(recurMat(n/2, a11, b11), recurMat(n/2, a12, b21));
			int[][] c12 = addMat(recurMat(n/2, a11, b12), recurMat(n/2, a12, b22));
			int[][] c21 = addMat(recurMat(n/2, a21, b11), recurMat(n/2, a22, b21));
			int[][] c22 = addMat(recurMat(n/2, a21, b12), recurMat(n/2, a22, b22));
			
			//merge c
			int[][] c = new int[n][n];
			mergeMat(c, c11, c12, c21, c22);
			return c;
		}
	}
	
	public static int[][] strassenMat(int n, int[][] a, int[][] b) {
		if(n <= THRESHOLD) {
			return recurMat(n,a,b);
		} else {
			int[][] a11 = new int[n/2][n/2], a12 = new int[n/2][n/2], a21 = new int[n/2][n/2], a22 = new int[n/2][n/2];
			int[][] b11 = new int[n/2][n/2], b12 = new int[n/2][n/2], b21 = new int[n/2][n/2], b22 = new int[n/2][n/2];

			splitMat(a, b, a11, a12, a21, a22, b11, b12, b21, b22);
			
			int[][] m1 = strassenMat(n/2,addMat(a11,a22),addMat(b11,b22));
			int[][] m2 = strassenMat(n/2,addMat(a21,a22),b11);
			int[][] m3 = strassenMat(n/2,a11,subMat(b12,b22));
			int[][] m4 = strassenMat(n/2,a22,subMat(b21,b11));
			int[][] m5 = strassenMat(n/2,addMat(a11,a12),b22);
			int[][] m6 = strassenMat(n/2,subMat(a21,a11),addMat(b11,b12));
			int[][] m7 = strassenMat(n/2,subMat(a12,a22),addMat(b21,b22));
			
			int[][] c11 = subMat(addMat(m1,m4),addMat(m5,m7));
			int[][] c12 = addMat(m3,m5);
			int[][] c21 = addMat(m2,m4);
			int[][] c22 = subMat(addMat(m1,m3),addMat(m2,m6));
			
			//merge c
			int[][] c = new int[n][n];
			mergeMat(c, c11, c12, c21, c22);
			
			return c;
		}
	}
	
	public static void printMat(int n, int[][] a) {
		System.out.println("[");
		for(int i=0;i<n;i++) {
			System.out.print("[");
			for(int j=0;j<n;j++) {
				System.out.print(a[i][j]);
				if(j!=n-1)
					System.out.print(", ");
			}
			if(i!=n-1)
				System.out.println("],");
			else
				System.out.println("]");
		}
		System.out.println("]");
	}
	
	public static int[][] addMat(int[][] a, int[][] b) {
		int n = a.length;
		int[][] result = new int[n][n];
		for(int i=0;i<n;i++) 
			for(int j=0;j<n;j++) 
				result[i][j] = a[i][j] + b[i][j];
			
		return result;
	}
	
	public static int[][] subMat(int[][] a, int[][] b) {
		int n = a.length;
		int[][] result = new int[n][n];
		for(int i=0;i<n;i++) 
			for(int j=0;j<n;j++)
				result[i][j] = a[i][j] - b[i][j];
		
		return result;
	}
	
	public static void splitMat(int[][] a, int[][] b, int[][] a11, int[][] a12, int[][] a21, 
			int[][] a22, int[][] b11, int[][] b12, int[][] b21, int[][] b22) {
		int n = a.length;
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(i < n/2) {
					if(j < n/2) {
						a11[i][j] = a[i][j];
						b11[i][j] = b[i][j];
					}
					else { //j >= n/2
						a12[i][j-n/2] = a[i][j];
						b12[i][j-n/2] = b[i][j];
					}
				}
				else {	//i >= n/2
					if(j < n/2) {
						a21[i-n/2][j] = a[i][j];
						b21[i-n/2][j] = b[i][j];
					}
					else {	//j >= n/2
						a22[i-n/2][j-n/2] = a[i][j];
						b22[i-n/2][j-n/2] = b[i][j];
					}
				}
			}
		}
	}
	
	public static void mergeMat(int[][] c, int[][] c11, int[][] c12, int[][] c21, int[][] c22) {
		int n = c.length;
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(i < n/2) {
					if(j < n/2) 
						c[i][j] = c11[i][j];
					else  //j >= n/2
						c[i][j] = c12[i][j-n/2];
				}
				else {	//i >= n/2
					if(j < n/2) 
						c[i][j] = c21[i-n/2][j];
					else 	//j >= n/2
						c[i][j] = c22[i-n/2][j-n/2];
				}
			}
		}
	}

}
