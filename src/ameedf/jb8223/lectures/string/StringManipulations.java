package ameedf.jb8223.lectures.string;

public class StringManipulations {
    public static void main(String[] args) {
        String abc = "abc";
        String abcAlso = new String(new char[]{'a', 'b', 'c'});
        System.out.println("abc = " + abc);
        System.out.println("abcAlso = " + abcAlso);
        System.out.println("abc == abcAlso ? " + (abc == abcAlso));
        System.out.println("abc.equals(abcAlso) ? " + abc.equals(abcAlso));
        abc.concat("def");
        System.out.println("abc is still " + abc);
        abc = abc.concat("def");
        System.out.println("abc is now " + abc);

        String myName = "Ameed";
        char c = myName.charAt(2);
        System.out.println("The character at in index 2 in " + myName + " is " + c);
        System.out.println(myName.replace('e', 'E'));
        System.out.println("my name is still " + myName);
        System.out.println("myName.startsWith(\"e\") ? " + myName.startsWith("e"));
        System.out.println("myName.startsWith(\"e\", 2) ? " + myName.startsWith("e", 2));

        System.out.println(String.format("String: %S, Integer: %d, Long: %, 8d, Character: %c, %%, %.2f" ,"aaa", 12, 34345L, 'b', 32.1f));
        System.out.printf("String: %S, Integer: %d, Long: %, 8d, Character: %c, %%, %9.2f" ,"aaa", 12, 34345L, 'b', 32.1f);
        System.out.println("  - no line break");
        System.out.printf("String: %S, Integer: %d, Long: %, 8d, Character: %c, %%, %9.2f\n" ,"aaa", 12, 34345L, 'b', 32.1f);
        System.out.println("Already with line break");

    }
}
