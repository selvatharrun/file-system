import java.util.Stack;

public class pathResolver {
    public static String Normalize(String path){
        String[] stuff  = path.split(" ");
        Stack<String> stack = new Stack<>();

        for(String s:stuff){
            if(s.equals(".") || s.equals(null))continue;

            else if(s.equals("..")){
                if(!stack.isEmpty()){
                    stack.pop();
                }
                else{
                    return null;
                }
            }
            else{
                stack.push(s);
            }
        }

        return "/" + String.join("/", stack);
    }
}
