package oop.lection9;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class MyCharacter {
    char b;

    public MyCharacter(char b) {
        this.b = b;
    }

    public char getB() {
        return b;
    }

    public void setB(char b) {
        this.b = b;
    }
}

class WordFactory {
    private static WordFactory instance = new WordFactory();
    public static WordFactory getInstance() {
        return instance;
    }

    public List<MyCharacter> getWord(String word) {
        List<MyCharacter> myCharacters = new ArrayList<>();
        for(char ch : word.toCharArray()) {
            MyCharacter symbol = null;
            for(MyCharacter mc : myCharacters) {
                if (mc.getB() == ch) {
                    symbol = mc;
                    break;
                }
            }
            if (symbol == null) {
                myCharacters.add(new MyCharacter(ch));
            } else {
                myCharacters.add(symbol);
            }
        }
        return myCharacters;
    }
}


public class Flyweight {
    public static boolean test(String testString) {
        Pattern p = Pattern.compile("^[a-z]+");
        Matcher m = p.matcher(testString);
        return m.matches();
    }
    public static void main(String[] args) {
        System.out.println(test("pizza"));   //true
        System.out.println(test("@pizza"));  //false
        System.out.println(test("pizza3"));  //false
    }
}
