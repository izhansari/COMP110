package comp110;

/**
 * Author:
 *
 * ONYEN:
 *
 * Collaborator(s):
 *
 * UNC Honor Pledge: I certify that no unauthorized assistance has been received
 * or given in the completion of this work. I certify that I understand and
 * could now rewrite on my own, without assistance from collaborators or course
 * staff, the problem set code I am submitting.
 */
public class ArrayUtils {

  /* Part 1. Reducers */

  public static int reduceSum(int[] a) {
   int i = 0;
   int x = 0;
   while (i < a.length){
	   x = x + a[i];
	   i ++;
   }
	  return x;
  }

  public static int reduceProduct(int[] a) {
	   int i = 0;
	   int x = 1;
	   while (i < a.length){
		   x = x * a[i];
		   i ++;
	   }
	   return x;
  }

  public static int reduceCount(int[] a, int n) {
	  int i = 0;
	  int y = 0;
	  while(i < a.length){
		  if (n == a[i]){
			  y = y + 1 ;
			  }
		  i ++;
	  }
	   return y;
  }

  public static int reduceCountOdds(int[] a) {
	  int i = 0;
	  int x = 0;
	  while (i< a.length){
		 if (a[i] % 2 != 0){
			 x = x + 1;
		 	}
		 i++;
	  }
	  return x;
  }

  public static int reduceMin(int[] a) {
	  int i = 0;
	  int x = a[0];
	  while (i < a.length){
		  if (x <= a[i]){
		  }
		  else{
			  x = a[i];
		  }
		  i ++;
	  }
    return x;
  }

  public static int reduceMax(int[] a) {
	  int i = 0;
	  int x = a[0];
	  while (i < a.length){
		  if (x >= a[i]){
		  }
		  else{
			  x = a[i];
		  }
		  i ++;
	  }
    return x;
  }

  /* Part 2. Logical Tests */

  public static boolean contains(int[] a, int n) {
	  int i = 0;
		while (i < a.length){
			if (a[i] == n){
				return true;
			}
			i++;
		}
    return false;
  }

  public static boolean every(int[] a, int n) {
	  int i = 0;
	  while (i< a.length){
		  if (a[i] != n){
			  return false;
		  }
		 i++;
	  }
    return true;
  }

  public static boolean equals(int[] a, int[] b) {
	  int i = 0;
	  if(a.length == 0 && b.length == 0){
		  return true;
	  }
	  while ((a.length == b.length) && (i < b.length)){
		  if (a[i] == b[i]){
			 return true;
		  		}
		  i++;
	  }
    return false;
  }

  /* Part 3. Stringify and Clone */

  public static String stringify(int[] a) {
	  int i = 0;
	  String x = new String();
	  x = "";
	  while (i<a.length){
		  if (i+1 == a.length){
			  x = x + a[i];
		  }
		  else{
			  x= x + a[i] + ", ";
		  }
	  i++;
	  }
	  
    return ("{" + x + "}");
  }

  public static void print(int[] a) {
    System.out.println(ArrayUtils.stringify(a));
  }

  public static int[] clone(int[] a) {
	  int [] clone = new int [a.length];
	  int i = 0;
	  while(i < a.length){
		  clone[i]=a[i];
		  i++;
	  }
	  return clone ;
  }

  /* Part 4. Mappers */

  public static int[] mapSquare(int[] a) {
	  int [] b = new int [a.length];
	  int i = 0;
	  while (i < a.length){
		  b[i] = a[i]*a[i];
		  i++;
	  }
	  
	  return b; 
	  
  }

  public static int[] mapAdd(int[] a, int n) {
	  int [] b = new int [a.length];
	  int i = 0;
	  while (i < a.length){
		  b[i] = a[i]+n;
		  i++;
	  }
	  
    return b;
  }

  public static int[] mapMultiply(int[] a, int n) {
	  int [] b = new int [a.length];
	  int i = 0;
	  while (i < a.length){
		  b[i] = a[i]*n;
		  i++;
	  }
    return b;
  }

  /* Part 5. Utilities */

  public static int[] reverse(int[] a) {
	  int [] b= new int [a.length];
	  int i = 0;
	  int n = a.length;
	  while (i < a.length){
		  b[n-1] = a[i];
		  i++;
		  n--;
	  }
    return b;
  }

  public static int[] concatenate(int[] a, int[] b) {
	  int cLength = a.length+b.length;
	  int [] c = new int [cLength];
	  int i = 0;
	  while (i < a.length){
		  c[i] = a[i];
		  i++;
	  }
	  i = 0;
	  while(i < b.length){
		c[cLength-1 - i] = b[b.length - 1 - i];
		i++;
	  }
    return c;
  }

  public static int[] subarray(int[] a, int start, int end) {
	  int dif = end - start;
	  int [] b= new int [dif];
	  int i = 0;
	  while (start < end){
		  b[i] = a[start];
		  i++;
		  start ++;
	  }
	  
    return b;
  }

  public static int[] without(int[] a, int n) {
	  int x = 0;
	  int i = 0;
	  while (i < a.length){
			  if (a[i] != n){
			  x ++;
			  }
		  i++;
	  	  }
  
	  int [] b = new int [x];
	  int u = 0;
	  int h = 0;
	  while (u < a.length){
		  if (n != a[u]){
			  b[h] = a[u];
			  h++;}
		  u++;
	  }
	  
    return b;
  }

  public static int[] interleave(int[] a, int[] b) {
	  int i = 0;
	  int aa = 0;
	  int bb = 0;
	  int sum = a.length+b.length;
	  int [] c = new int [sum];
	  if (a.length != b.length){
		  return null;
	  }
	  else{
      while (i< sum){
	    	if (i % 2 == 0){
	    		c[i]= a[aa];
	    		aa++;
	    	}
	    	else if (i % 2 != 0){
	    		c[i] = b[bb];
	    		bb++;
	    	}
	    	i++;
	    }}
   	  
    return c;
  }

  public static int[] splice(int[] a, int offset, int[] b) {
	  int [] c = new int [a.length +b.length];
	  int i = 0;
	  int x = 0;
	  int y = 0;
	  
	  while (i < a.length +b.length){
		  if (i < offset){
			  c[i] = a[i];
		  }
		  else if(i < offset+b.length){
			  c[i]= b[x];
			  x++;
		  }
		  else{
			  c[i]= a[offset + y];
			  y++;
		  }
		  i++;
	  }
    return c;
  }

}