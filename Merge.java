public class Merge{
  /*sort the array from least to greatest value. This is a wrapper function*/
  public static void mergesort(int[]data){
    mergesort(data, 0, data.length - 1);
  }

  //helper
  public static void mergesort(int[]data, int lo, int hi){
    //if parameters unacceptable, stop method
    if (lo > hi){
      return;
    }
    //make pivot the middle integer
    int p = (lo + hi) / 2;
    //make make left and right sides of pivot
    int[] left = new int[data.length / 2];
    int[] right = new int[data.length - left.length];
    //fill left and right arrays
    for (int x = 0; x < left.length; x++){
      left[x] = data[x];
    }
    for (int x = 0; x < right.length; x++){
      right[x] = data[x + p];
    }
    //break arrays even further
    mergesort(left, 0, left.length - 1);
    mergesort(right, p, right.length - 1);

    }
  }
}
