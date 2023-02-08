public class Contest {

    public boolean isCircularSentence(String sentence) {
        int StringLength =0;
        for(var ch : sentence.toCharArray()){
            if(ch == ' ')
                StringLength++;
        }
       if(StringLength == 0){
           if(sentence.charAt(0) != sentence.charAt(sentence.length()-1))
               return false;
           else
               return true;
       }

       String[] str = new String[StringLength+1];
       int i = 0;
       int j =0;
       while (i<sentence.length()){
           if (sentence.charAt(i) == ' '){
               i++;
               continue;
           }else{
               String newString = "";
               while ( i<sentence.length() && sentence.charAt(i) != ' '){

                   newString+=sentence.charAt(i);
                   i++;
               }
               str[j++] = newString;
           }

       }

   for (int k = 0;k<str.length-1;k++){
       if(str[k].charAt(str[k].length()-1) != str[k+1].charAt(0))
           return false;
       if(k == str.length-2){
           if(str[k+1].charAt(str[k+1].length()-1) != str[0].charAt(0))
               return false;
       }
   }

   return true;



    }

}
