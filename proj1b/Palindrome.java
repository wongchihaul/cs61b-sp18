

public class Palindrome
{
    public Deque<Character> wordToDeque(String word) {
        Deque<Character> res = new LinkedListDeque<>();
        for (int i = 0; i < word.length(); i++) {
            res.addLast(word.charAt(i));
        }
        return res;
    }

    public static int cnt = 0;

    public boolean isPalindrome(String word){
        if(word.length() == 0 || word.length() == 1){
            return true;
        }
        else{
            Deque<Character> d2 = new LinkedListDeque<>();
            d2 = wordToDeque(word);
            return palindromehelper(d2);
        }
    }

    private boolean palindromehelper(Deque<Character> d3){
        if(d3.size() == 0 || d3.size() == 1){
            return true;
        }
        else{
            return (d3.removeFirst().equals(d3.removeLast())
                    && palindromehelper(d3));
        }
    }

}
