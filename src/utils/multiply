class Solution {
  public String multiply(String num1, String num2) {
    if(num1.equals("") || num2.equals("")) return "0";
    if(num1.length()<num2.length()){
      String t =  num2;
      num2 = num1;
      num1=t;
    }
    StringBuilder sb = new StringBuilder();
    int[] c = new int[num1.length()+num2.length()];
    int[] rowc = new int[num2.length()];
    int res, ans=0;
    boolean allzero=true;
    for(int i=0;i<num1.length()+(num2.length()-1); i++){
      res=0;
      for(int j=0;j<num2.length();j++){
        int t = num1.length()-1-i+j;
        int a = t>=0 && t<num1.length()? (int) num1.charAt(t) - 48: 0;
        int b = (int) num2.charAt(num2.length()-1-j) - 48;
        int mul = a*b+rowc[j];
        rowc[j]=mul/10;
        res+=mul%10;
        if(mul%10>0) allzero = false;
      }
      res+=c[i];
      c[i+1]=res/10;
      sb.append(res%10);
    }

    int last = 0;
    if(c[c.length-1]>0){
      last+=c[c.length-1];
    }
    if(rowc[num2.length()-1]>0){
      last+=rowc[num2.length()-1];
    }
    if(last>0){
      allzero = false;
      sb.append(last);
    }
    return allzero? "0": sb.reverse().toString();
  }
}