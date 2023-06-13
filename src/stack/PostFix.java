package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class PostFix {

    public void solution() throws IOException {
        //input processing
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();


        //Stack 선언
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < input.length(); i++) {
            char token = input.charAt(i);

            //숫자일 경우 push
            //숫자가 아닐경우 두번 pop, 계산후 push
            if(Character.isDigit(token)){
                st.push(token-'0');
            }
            else{
                int num1 = st.pop();
                int num2 = st.pop();

                switch (token){
                    case '*':
                        st.push(num1*num2);
                        break;

                    case '+':
                        st.push(num1+num2);
                        break;

                    case '-':
                        st.push(num1-num2);
                        break;

                    case '/':
                        st.push(num1/num2);

                    default:
                        break;
                }
            }

            System.out.println(st.pop());
        }

    }




    public static void main(String[] args) throws IOException {
        PostFix pf = new PostFix();
        pf.solution();
    }
}
