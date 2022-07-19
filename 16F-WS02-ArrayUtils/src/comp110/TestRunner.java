package comp110;

public class TestRunner {

  public static void main(String[] args) {

    TestRunner.testReduceSum();
    TestRunner.testReduceProduct();
    TestRunner.testReduceCount();
    TestRunner.testReduceCountOdds();
    TestRunner.testReduceMin();
    TestRunner.testReduceMax();
    TestRunner.testContains();
    TestRunner.testEvery();
    TestRunner.testEquals();
    TestRunner.testStringify();
    TestRunner.testClone();
    TestRunner.testMapSquare();
    TestRunner.testMapAdd();
    TestRunner.testMapMultiply();
    TestRunner.testReverse();
    TestRunner.testConcatenate();
    TestRunner.testSubarray();
    TestRunner.testWithout();
    TestRunner.testInterleave();
    TestRunner.testSplice();

    // TODO: add additional static methods (and calls!)
    // for each of the other parts of the assignment.

  }

  public static void testReduceSum() {
    System.out.println("=======================");
    System.out.println("   1.1 reduceSum       ");
    System.out.println("=======================");

    System.out.println("1. reduceSum - expected: 0 - actual: " + ArrayUtils.reduceSum(new int[] {}));
    System.out.println("2. reduceSum - expected: 1 - actual: " + ArrayUtils.reduceSum(new int[] { 1 }));
    System.out.println("3. reduceSum - expected: 5 - actual: " + ArrayUtils.reduceSum(new int[] { 2, 3 }));
    System.out.println("4. reduceSum - expected: 15 - actual: " + ArrayUtils.reduceSum(new int[] { 4, 5, 6 }));
  }

  public static void testReduceProduct() {
	    System.out.println("=======================");
	    System.out.println("   1.2 reduceProduct       ");
	    System.out.println("=======================");

	    System.out.println("1. reduceProduct - expected: 0 - actual: " + ArrayUtils.reduceProduct(new int[] {}));
	    System.out.println("2. reduceProduct - expected: 1 - actual: " + ArrayUtils.reduceProduct(new int[] { 2 }));
	    System.out.println("3. reduceProduct - expected: 5 - actual: " + ArrayUtils.reduceProduct(new int[] { 2, 3 }));
	    System.out.println("4. reduceProduct - expected: 15 - actual: " + ArrayUtils.reduceProduct(new int[] { 4, 5, 6 }));
	  }

public static void testReduceCount() {
    System.out.println("=======================");
    System.out.println("   1.3 reduceCount       ");
    System.out.println("=======================");
    
    System.out.println("1. reduceCount - expected: 0 - actual: " + ArrayUtils.reduceCount(new int[]{}, 1));
    System.out.println("2. reduceCount - expected: 0 - actual: " + ArrayUtils.reduceCount(new int[]{2}, 1));
    System.out.println("3. reduceCount - expected: 1 - actual: " + ArrayUtils.reduceCount(new int[] {2, 1}, 1));
    System.out.println("4. reduceCount - expected: 3 - actual: " + ArrayUtils.reduceCount(new int[]{1, 1, 1}, 1));
  }

public static void testReduceCountOdds() {
    System.out.println("=======================");
    System.out.println("   1.4 reduceCountOdds       ");
    System.out.println("=======================");
    
    System.out.println("1. reduceCountOdds - expected: 0 - actual: " + ArrayUtils.reduceCountOdds(new int[]{2}));
    System.out.println("2. reduceCountOdds - expected: 1 - actual: " + ArrayUtils.reduceCountOdds(new int[]{2, 1}));
    System.out.println("3. reduceCountOdds - expected: 2 - actual: " + ArrayUtils.reduceCountOdds(new int[] {2, 1, 3}));
    System.out.println("4. reduceCountOdds - expected: 3 - actual: " + ArrayUtils.reduceCountOdds(new int[]{1, 1, 1}));
  }

public static void testReduceMin() {
    System.out.println("=======================");
    System.out.println("   1.5 reduceMin       ");
    System.out.println("=======================");
    
    System.out.println("1. reduceMin - expected: 2 - actual: " + ArrayUtils.reduceMin(new int[]{2}));
    System.out.println("2. reduceMin - expected: 3 - actual: " + ArrayUtils.reduceMin(new int[]{5, 3}));
    System.out.println("3. reduceMin - expected: 1 - actual: " + ArrayUtils.reduceMin(new int[] {4, 7, 1}));
    System.out.println("4. reduceMin - expected: 4 - actual: " + ArrayUtils.reduceMin(new int[]{8, 9, 7, 4}));
  }

public static void testReduceMax() {
    System.out.println("=======================");
    System.out.println("   1.6 reduceMax       ");
    System.out.println("=======================");
    
    System.out.println("1. reduceMax - expected: 2 - actual: " + ArrayUtils.reduceMax(new int[]{2}));
    System.out.println("2. reduceMax - expected: 5 - actual: " + ArrayUtils.reduceMax(new int[]{5, 3}));
    System.out.println("3. reduceMax - expected: 7 - actual: " + ArrayUtils.reduceMax(new int[] {4, 7, 1}));
    System.out.println("4. reduceMax - expected: 9 - actual: " + ArrayUtils.reduceMax(new int[]{8, 9, 7, 4}));    
  }

public static void testContains() {
    System.out.println("=======================");
    System.out.println("   2.1 Contains       ");
    System.out.println("=======================");
    
    System.out.println("1. Contains - expected: F - actual: " + ArrayUtils.contains(new int[]{2}, 1));
    System.out.println("2. Contains - expected: T - actual: " + ArrayUtils.contains(new int[]{2}, 2));
    System.out.println("3. Contains - expected: F - actual: " + ArrayUtils.contains(new int[]{1, 3, 5}, 4));
    System.out.println("4. Contains - expected: T - actual: " + ArrayUtils.contains(new int[]{1, 3, 5}, 3));
  }

public static void testEvery () {
    System.out.println("=======================");
    System.out.println("   2.2 Every       ");
    System.out.println("=======================");
    
    System.out.println("1. Every - expected: F  - actual: " + ArrayUtils.every(new int[]{2}, 1));
    System.out.println("2. Every - expected: T - actual: " + ArrayUtils.every(new int[]{2}, 2));
    System.out.println("3. Every - expected: F - actual: " + ArrayUtils.every(new int[]{1, 3, 5}, 1));
    System.out.println("4. Every - expected: T - actual: " + ArrayUtils.every(new int[]{1, 1, 1}, 1));
  }

public static void testEquals () {
    System.out.println("=======================");
    System.out.println("   2.3 Equals       ");
    System.out.println("=======================");
    
    System.out.println("1. Equals - expected: T - actual: " + ArrayUtils.equals(new int[]{}, new int[]{}));
    System.out.println("2. Equals - expected: F - actual: " + ArrayUtils.equals(new int[]{2}, new int[]{}));
    System.out.println("3. Equals - expected: F - actual: " + ArrayUtils.equals(new int[]{1, 3}, new int[]{3, 1}));
    System.out.println("4. Equals - expected: T - actual: " + ArrayUtils.equals(new int[]{1, 3}, new int[]{1, 3}));
    System.out.println("4. Equals - expected: F - actual: " + ArrayUtils.equals(new int[]{1, 3}, new int[]{1, 3, 1}));
  }

public static void testStringify () {
    System.out.println("=======================");
    System.out.println("   3.1 Stringify       ");
    System.out.println("=======================");
    
    System.out.println("1. Stringify - expected: '{}' - actual: " + ArrayUtils.stringify(new int[]{}));
    System.out.println("2. Stringify - expected: '{1}' - actual: " + ArrayUtils.stringify(new int[]{1}));
    System.out.println("3. Stringify - expected: '{1, 2}' - actual: " + ArrayUtils.stringify(new int[]{1, 2}));
    System.out.println("4. Stringify - expected: '{1, 2, 3}' - actual: " + ArrayUtils.stringify(new int[]{1, 2, 3}));
  }

public static void testClone () { 
    System.out.println("=======================");
    System.out.println("   3.2 Clone       ");
    System.out.println("=======================");
  
	int[] original = new int[]{1, 2, 3};
	int[] clone = ArrayUtils.clone(original);
	ArrayUtils.print(clone); // output: {1, 2, 3}
	System.out.println(original == clone); // false
	System.out.println(ArrayUtils.equals(original, clone)); // true
  }

public static void testMapSquare (){
    System.out.println("=======================");
    System.out.println("   4.1 Map Square       ");
    System.out.println("=======================");
    System.out.println("1. MapSquare - expected: '{1, 4}' - actual: " + ArrayUtils.stringify(ArrayUtils.mapSquare(new int[]{1, 2})));
    System.out.println("2. MapSquare - expected: '{4, 9, 16}' - actual: " + ArrayUtils.stringify(ArrayUtils.mapSquare(new int[]{2, 3, 4})));
}

public static void testMapAdd (){
    System.out.println("=======================");
    System.out.println("   4.2 Map Add       ");
    System.out.println("=======================");
    
    System.out.println("1. MapAdd - expected: '{2, 3, 4}' - actual: " + ArrayUtils.stringify(ArrayUtils.mapAdd(new int[]{1, 2, 3}, 1)));
    System.out.println("2. MapAdd - expected: '{10, 11, 12}' - actual: " + ArrayUtils.stringify(ArrayUtils.mapAdd(new int[]{1, 2, 3}, 9)));
}

public static void testMapMultiply (){
    System.out.println("=======================");
    System.out.println("   4.3 Map Multiply       ");
    System.out.println("=======================");
    
    System.out.println("1. MapMultiply - expected: '{2, 4, 6}' - actual: " + ArrayUtils.stringify(ArrayUtils.mapMultiply(new int[]{1, 2, 3}, 2)));
    System.out.println("2. MapMultiply - expected: '{3, 6, 9}' - actual: " + ArrayUtils.stringify(ArrayUtils.mapMultiply(new int[]{1, 2, 3}, 3)));
}

public static void testReverse (){
    System.out.println("=======================");
    System.out.println("   5.1 Reverse       ");
    System.out.println("=======================");
    
    System.out.println("1. Reverse - expected: '{1}' - actual: " + ArrayUtils.stringify(ArrayUtils.reverse(new int[]{1})));
    System.out.println("2. Reverse - expected: '{2, 1}' - actual: " + ArrayUtils.stringify(ArrayUtils.reverse(new int[]{1, 2})));
    System.out.println("3. Reverse - expected: '{3, 2, 1}' - actual: " + ArrayUtils.stringify(ArrayUtils.reverse(new int[]{1, 2, 3})));
}

public static void testConcatenate (){
    System.out.println("=======================");
    System.out.println("   5.2 Concatenate       ");
    System.out.println("=======================");
    
    System.out.println("1. Concatenate - expected: '{1, 2}' - actual: " + ArrayUtils.stringify(ArrayUtils.concatenate(new int[]{1}, new int[]{2})));
    System.out.println("2. Concatenate - expected: '{1, 2, 3}' - actual: " + ArrayUtils.stringify(ArrayUtils.concatenate(new int[]{1, 2}, new int[]{3})));
    System.out.println("2. Concatenate - expected: '{1, 2, 3}' - actual: " + ArrayUtils.stringify(ArrayUtils.concatenate(new int[]{1}, new int[]{2, 3})));
    System.out.println("1. Concatenate - expected: '{1, 2, 3}' - actual: " + ArrayUtils.stringify(ArrayUtils.concatenate(new int[]{}, new int[]{1, 2, 3})));

}


public static void testSubarray (){
    System.out.println("=======================");
    System.out.println("   5.3 subarray       ");
    System.out.println("=======================");

    int[] input = new int[] {2, 4, 6, 8, 10};
    System.out.println("1. Subarray - expected: '{2}' - actual: " + ArrayUtils.stringify(ArrayUtils.subarray(input, 0, 1)));
    System.out.println("2. Subarray - expected: '{2, 4}' - actual: " + ArrayUtils.stringify(ArrayUtils.subarray(input, 0, 2)));
    System.out.println("3. Subarray - expected: '{6}' - actual: " + ArrayUtils.stringify(ArrayUtils.subarray(input, 2, 3)));
    System.out.println("4. Subarray - expected: '{6, 8, 10}' - actual: " + ArrayUtils.stringify(ArrayUtils.subarray(input, 2, input.length)));
}

public static void testWithout (){
    System.out.println("=======================");
    System.out.println("   5.4 without       ");
    System.out.println("=======================");
    
    int[] input = new int[] {1, 2, 1, 2, 1};
    System.out.println("1. without - expected: '{2, 2}' - actual: " + ArrayUtils.stringify(ArrayUtils.without(input, 1)));
    System.out.println("2. without - expected: '{1, 1, 1}' - actual: " + ArrayUtils.stringify(ArrayUtils.without(input, 2)));
    System.out.println("3. without - expected: '{1, 2, 1, 2, 1}' - actual: " + ArrayUtils.stringify(ArrayUtils.without(input, 3)));


}


public static void testInterleave (){
    System.out.println("=======================");
    System.out.println("   5.5 interleave       ");
    System.out.println("=======================");
    
    int[] a = new int[] {1, 1, 1};
    int[] b = new int[] {2, 2, 2};
    System.out.println("1. interleave - expected: '{1, 2, 1, 2, 1, 2}' - actual: " + ArrayUtils.stringify(ArrayUtils.interleave(a, b)));
    System.out.println("2. interleave - expected: '{2, 1, 2, 1, 2, 1}' - actual: " + ArrayUtils.stringify(ArrayUtils.interleave(b, a)));
    System.out.println("3. interleave - expected: 'null' - actual: " + ArrayUtils.interleave(a, new int[] {2}));
    
}

public static void testSplice (){
    System.out.println("=======================");
    System.out.println("   5.6 splice       ");
    System.out.println("=======================");
    
    int[] a = new int[] {1, 2, 3};
    int[] b = new int[] {9, 9};
    System.out.println("1. splice - expected: '{9, 9, 1, 2, 3}' - actual: " + ArrayUtils.stringify(ArrayUtils.splice(a, 0, b)));
    System.out.println("2. splice - expected: '{1, 9, 9, 2, 3}' - actual: " + ArrayUtils.stringify(ArrayUtils.splice(a, 1, b)));
    System.out.println("3. splice - expected: '{9, 1, 2, 3, 9}' - actual: " + ArrayUtils.stringify(ArrayUtils.splice(b, 1, a)));
    System.out.println("4. splice - expected: '{9, 9, 1, 2, 3}' - actual: " + ArrayUtils.stringify(ArrayUtils.splice(b, 2, a)));
    

    
}


}