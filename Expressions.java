import java.util.*;
public class Expressions { //conversion of infix (user input) to postfix (output)
        public static void main(String[] args) {
        // accept user input for expression to be converted
        char tryAgain;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.print ("Enter Infix, put a # after the expression: ");
            String exp = sc.nextLine();
            if (exp.charAt(exp.length()-1) != '#'){
                System.out.println("Please end the expression with a '#'");
            }
        }while (exp.charAt(exp.length()-1) != '#');
        System.out.println("Token\t\tStack\t\tOutput");

                          //  "\nOriginal expression: "+exp+"\nTo Postfix: "+toPostfix(exp)); //calls toPostfix() method

        }

    public static int isp (char ch){//in stack priority
        if (ch=='+'||ch=='-'){
            return 1;
        } else if (ch=='*'||ch=='/'||ch=='%'){
            return 2;
        } else if (ch=='^'){
            return 3;
        } else if (ch=='('){
            return 0;
        } else {
            return -1;
        }
    }
    static int icp (char ch){ //in coming priority
        if (ch=='+'||ch=='-'){
            return 1;
        } else if (ch=='*'||ch=='/'||ch=='%'){
            return 2;
        } else if (ch=='^'){
            return 4;
        } else if (ch=='('){
            return 4;
        } else {
            return -1;
        }
    }
    static String toPrefix (String exp){
        //method converts to infix
        String prefix =" ";
        return prefix;
    }
    static String toPostfix (String exp){
        //method converts to postfix
        //A+(B*C-(D/E^F)*G)*H#
        Stack <Character> stack = new Stack ();
        String postfix =" ";
        for (int i=0; i<exp.length();i++){
            char token = exp.charAt(i);
            if ((Character.isLetterOrDigit(token))){ //if token is an operand, print in output
                postfix = postfix +token;
            } else if (token =='('){
                stack.push(token);
               // stack.pop();
            } else if (token ==')'){ //else if the token is ')'
                while (!stack.isEmpty()){ //&& stack.peek() != '(')
                    //all popped operators until '(' is reached is printed
                    while (stack.peek () != '('){
                       postfix = postfix + stack.pop();
                    }
                    if (stack.peek () == '('){
                        stack.pop();
                        break;
                    }
                }
            } else { //operator
                while (!stack.isEmpty() && icp(token)<= isp(stack.peek())){
                    postfix = postfix + stack.pop();
                }
                stack.push(token);
            }
        }
        return postfix;
    }
}