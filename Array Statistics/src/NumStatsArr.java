public class NumStatsArr{

    private final double[] arr;
  
    public NumStatsArr(double[] a){
      arr = a;
    }
  
    //Implement all methods as described
    public String toString(){
      String word = "{";
      for(int i = 0; i < arr.length - 1; i++){
        word += arr[i];
        word += ",";
      }
      word += arr[arr.length - 1];
      word += "}";
      return word;
    }
  
    public double average(){
      double sum = 0;
      for(double i : arr){
        sum += i;
      }
      sum /= arr.length;
      return sum;
    }
  
    public double range(){
      double max = 0;
      double min = arr[0];
      for(double i : arr){
        if(i > max){
          max = i;
        } else if(i < min){
          min = i;
        }
      }
      return (max - min);
    }
  
    public int sortStatus() {
      double sum = 0;
      int copies = 0;
      boolean extraChecker = false;
      boolean check = true;
      for(int i = 0; i < arr.length-1; i++){
        if(arr[i] < arr[i+1]){
          sum++;
          check = true;
          extraChecker = true;
        } else if(arr[i] > arr[i+1]){
          sum--;
          check = false;
          extraChecker = true;
        } else {
          copies++;
        }
      }

      if(check && extraChecker){
        sum += copies;
      } else if(!check && extraChecker) {
        sum -= copies;
      } else {
        sum = 0; 
      }
      
      if(sum/(arr.length-1) == 1){
        return 1;
      } else if(sum/(arr.length-1) == -1){
        return -1;
      } else {
        return 0;
      }
        
    }
  
  }