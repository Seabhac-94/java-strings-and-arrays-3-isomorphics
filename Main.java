import java.util.Arrays;

// import org.graalvm.compiler.lir.amd64.AMD64ControlFlow.FloatCondSetOp;

class Start {
    // Given two strings a and b, determine if they are isomorphic.
    static int size = 256;
    
    static boolean areIsomorphic(String string1, String string2){
        int lengthOfString1 = string1.length();
        int lengthOfString2 = string2.length();

        if (lengthOfString1 != lengthOfString2){
            return false;
        }

        Boolean[] visitedCharacters = new Boolean[size];
        Arrays.fill(visitedCharacters, Boolean.FALSE);

        int[] mapCharacters = new int[size];
        Arrays.fill(mapCharacters, -1);

        for (int index = 0; index < lengthOfString1; index++) {
            if (mapCharacters[string1.charAt(index)]== -1){
                if (visitedCharacters[string2.charAt(index)] == true){
                    return false;
                }
                visitedCharacters[string2.charAt(index)] = true;
                mapCharacters[string1.charAt(index)] = string2.charAt(index);
            }
            else if (mapCharacters[string1.charAt(index)] != string2.charAt(index)) {
                return false;
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        
        boolean test = areIsomorphic("egg", "add");
        System.out.println(test); //returns true
        test = areIsomorphic("egg", "ego");
        System.out.println(test); //returns false

    }
}