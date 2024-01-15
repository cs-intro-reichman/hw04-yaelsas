public class ArrayOps {
    public static void main(String[] args) {
        int[] arr = {5, 4, 3, 2, 1};
        System.out.println(findMissingInt(arr));
        System.out.println(secondMaxValue(arr));
        //System.out.println(containsTheSameElements(new int[] {3, 2, 2, 1}, new int[] {1}));
        System.out.println(isSorted(arr));
    }
    
    public static int findMissingInt (int [] array) {
        int sum = 0;
        int expectedSum = array.length;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
            expectedSum += i;
        }
        return expectedSum - sum;
    }

    public static int secondMaxValue(int [] array) {
        int firstMax = Math.max(array[0],array[1]);
        int secondMax = Math.min(array[0], array[1]);
        for (int i = 2; i < array.length; i++){
            if (array[i] >= firstMax) {
                secondMax = firstMax;
                firstMax = array[i];
            } else if (array[i] > secondMax) {
                secondMax = array[i];
            }
        }
        return secondMax;
    }

    public static boolean containsTheSameElements(int [] array1,int [] array2) {
        for (int i = 0; i < array1.length; i++) {
            boolean found = false;
            for (int j = 0; j <array2.length; j++) {
                if (array1[i] == array2 [j]) {
                    found = true;
                }
            }
            if (!found) {
                return false;
            }
        }
        return true;
    }

    public static boolean isSorted(int [] array) {
        int num = array[0];
        for (int i = 1; i < array.length-1 && array.length > 2; i++) {
            if ((array[i] >= array[i + 1] && num <= array[i]) || (array[i] <= array[i + 1] && num >= array[i])) {
                return false;
            }
            num = array[i];
        }
        return true;
    }

}
