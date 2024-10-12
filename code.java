
import java.util.*;
public class Main {
    public static void main(String[] args) {
        System.out.println(factorial(5));
        System.out.println(fabonacci(6));
        System.out.println(sum_of_digit(5));

        k_multipleOf_n(12,5);
        System.out.println();
        System.out.println(sumOfNo_with_Alternate_sign(5));
        int []a= {3,5,7,3,8,3};
        array_print(a,a.length-1);
        System.out.println();
        System.out.println(array_max(a,a.length-1));
        System.out.println(array_sum(a,a.length-1));
        System.out.println(array_checkTarget(a,80,a.length-1));
        array_checkRepeatation(a,3,a.length-1);
        System.out.println();
        String s= "hello world";
        System.out.println(string_occurence(s,'l',s.length()-1));
        String s1= "abc";
        System.out.println(check_pallindrome(s1,0,s1.length()-1));
        System.out.println(string_reverse(s1,s1.length()-1));
        ArrayList<String>l =new ArrayList<>();
        l=string_subsequences(s1,s1.length()-1);
        System.out.println(l);
        string_subsequences2(s1,"",0);
        System.out.println();
        int []a1 ={1,2,3};
        ArrayList<Integer>l1 =new ArrayList<>();
//        array_subset(a,l1,0);
//        System.out.println();
        array_subset_sum(a1,0,0);
        System.out.println();
        int []a2= {10,30,40,20};
        System.out.println(frog_problem(a2,0));







    }
   static int factorial(int n){
        if(n==1) return 1;
       return factorial(n-1)*n;

    }
    static int fabonacci(int n){
        if(n==0) return 0;
        if(n==1||n==2) return 1;
        return fabonacci(n-1)+fabonacci(n-2);

    }
    public static int sum_of_digit(int n){
        if(n%10==n) return n;
        int p= n%10;
        return sum_of_digit(n/10)+p;
    }
    public static int exponential(int p,int q){
        if(q==1) return p;
       return exponential(p,q-1)*q;
    }
    public static void k_multipleOf_n(int n,int k){
        if(k==1){
            System.out.println(n);
            return;
        }
        k_multipleOf_n(n,k-1);
        System.out.print(n*k+" ");


    }



    public static int sumOfNo_with_Alternate_sign(int n){
        if(n==1) return 1;
       int sum= sumOfNo_with_Alternate_sign(n-1);
       if(n%2!=0){
           return sum+n;
       }else{
           return sum-n;
       }
    }
    public static void array_print(int []a,int idx){
        if(idx==0){
            System.out.print(a[idx]+" ");
            return;
        }
        array_print(a,idx-1);
        System.out.print(a[idx]+" ");
    }
    public static int array_max(int []a,int idx){
        if(idx==0) return a[idx];
        int s= array_max(a,idx-1);
        if(s>a[idx]) return s;
        else return a[idx];
    }
    public static int array_sum(int []a,int idx){
        if(idx==0) return a[idx];
        return array_sum(a,idx-1)+a[idx];

    }
    public static boolean array_checkTarget(int []a,int t,int idx){
        if(idx==0){
            if(a[idx]==t) return true;
            else return false;
        }
        if(array_checkTarget(a,t,idx-1)) return true;
        else{
            if(a[idx]==t) return true;
            else return false;
        }
    }
    public static void array_checkRepeatation(int []a,int x,int idx){
        if(idx==0){
            if(a[idx]==x) System.out.print(idx+" ");
            return;
        }
        array_checkRepeatation(a,x,idx-1);
        if(a[idx]==x) System.out.print(idx+" ");


    }
    public static String string_occurence(String s,char ch,int idx){
        if(idx==0){
            if(s.charAt(idx)==ch){
                return "";
            }else{
                String s2= s.charAt(idx)+"";
                return s2;
            }

        }
        String s1= string_occurence(s,ch,idx-1);

            if(s.charAt(idx)==ch){

                return s1;
            }else{
                return s1+s.charAt(idx);

            }
    }
    public static boolean check_pallindrome(String s,int i,int j){
        if(i==j) return true;
        if(check_pallindrome(s,i+1,j-1)){
            if(s.charAt(i)==s.charAt(j)) return true;
            else return false;

        }else{
            return false;

        }
    }
    public static String string_reverse(String s,int idx){
        if(idx==0){
            String s3 =s.charAt(idx)+"";
            return s3;
        }
        String s1= string_reverse(s,idx-1);
        String s2 =s.charAt(idx)+s1;
        return s2;
    }
    public static ArrayList string_subsequences(String s,int idx){
        ArrayList<String>l1 =new ArrayList<>();
        ArrayList<String>l2 =new ArrayList<>();
        if(idx==0){
            String s1 =s.charAt(idx)+"";
          l1.add(s1);
          return l1;
        }
        l2= string_subsequences(s,idx-1);
        for(int i=0;i<l2.size();i++){
            l1.add(l2.get(i));
        }
        String s2= s.charAt(idx)+"";
        l1.add(s2);
        for(int i=0;i<l2.size();i++){
            l1.add(l2.get(i)+s.charAt(idx));
        }
        return l1;

    }
    public static void string_subsequences2(String s, String str, int idx){
        if(idx==s.length()){
            System.out.print(str+" ");
            return;
        }
        string_subsequences2(s,str+s.charAt(idx),idx+1);
        string_subsequences2(s,str,idx+1);

    }
//    public static void array_subset(int []a,ArrayList l1,int idx){
//        if(idx==a.length){
//            System.out.print(l1+" ");
//            return;
//        }
//        l1.add(a[idx]);
//        array_subset(a,l1,idx+1);
//        l1.removeLast();
//        array_subset(a,l1,idx+1);
//
//    }

    public static void array_subset_sum(int []a,int sum,int idx){
        if(idx>=a.length){
            System.out.print(sum+" ");
            return;
        }
        array_subset_sum(a,sum+a[idx],idx+1);
        array_subset_sum(a,sum,idx+1);
    }
    public static int frog_problem(int []a,int idx){
        if(idx>=a.length){
            return 0;
        }
        int s1=0;int s2=0;
      if(idx+1<a.length) {
          s1 = frog_problem(a, idx + 1) + Math.abs(a[idx] - a[idx + 1]);
      }
        if(idx+2<a.length) {
             s2 = frog_problem(a, idx + 2) + Math.abs(a[idx] - a[idx + 2]);
        }
        return Math.min(s1,s2);
    }


}
