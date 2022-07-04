public class StringStatsArr {

    private final String[] arr;

    public StringStatsArr(String[] a){
        arr = a;
    }

    public String toString(){
        String word = "{";
        for(int i = 0; i < arr.length - 1; i++){
            word += "\"";
            word += arr[i];
            word += "\"";
            word += ",";
        }
        word += "\"" + arr[arr.length - 1] + "\"";
        word += "}";
        return word;
    }

    public double averageLength(){
        double sum = 0;
        for(String i : arr){
            sum += i.length();
        }
        sum /= arr.length;
        return sum;
    }

    public int search(String target){
        int tarLen = target.length();
        int num = 0;
        for(String i : arr){
            int wordLen = i.length();
            if(wordLen >= tarLen){
                for(int j = 0; j <= wordLen - tarLen; j++){
                    if(i.substring(j, j+tarLen).equals(target)){
                        return num;
                    }   
                }
            } 
            num++; 
        }
        return -1; 
    }

    public int sortStatus(){
        boolean check = false;
        boolean isChanging = false;
        boolean isIncr = true; 
        int sum = 0;
        int copies = 0; 
        int j = 0;
        if(arr.length != 1){
            for(int i = 0; i < arr.length-1; i++){
                while(!check){
                    String let1 = arr[i].substring(j, j+1);
                    String let2 = arr[i+1].substring(j, j+1);
                    if(compare(let1, let2) == 1){
                        sum++;
                        check = true;
                        isChanging = true;
                        isIncr = true;
                    } else if(compare(let1, let2) == -1){
                        sum--;
                        check = true;
                        isChanging = true;
                        isIncr = false;
                    } else {
                        j++;
                        if(j >= arr[i].length() && j >= arr[i+1].length()){
                            copies++;
                            check = true;
                        } else if(j >= arr[i+1].length()){
                            check = true;
                            sum--;
                        } else if(j >= arr[i].length()){
                            check = true;
                            sum++;
                        }
                    }
                }
                check = false;
                j = 0;
                System.out.println(i + ": Sum is " + sum);
                System.out.println(i + ":Copies is " + copies);
            }
            
            if(isIncr && isChanging){
                sum += copies;
              } else if(!isIncr && isChanging) {
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
        } else {
            return 0;
        }
        
    }

    public int compare(String str1, String str2){
        str1.toLowerCase();
        str2.toLowerCase();
        String[] letters = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
        int s1 = -1;
        int s2 = -1;
        
        for(int i = 0; i < letters.length; i++){
            if(str1.equals(letters[i])){
                s1 = i;                    
                break;
            } 
        }
        for(int i = 0; i < letters.length; i++){
            if(str2.equals(letters[i])){
                s2 = i;
                break;
            } 
        }

        if(s1 < s2){
            return 1;
        } else if(s1 > s2){
            return -1;
        } else {
            return 0;
        }
        
     }
}