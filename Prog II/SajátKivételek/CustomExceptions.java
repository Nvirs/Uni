package SajátKivételek;

import java.util.Arrays;

public class CustomExceptions {
    public static void main(String[] args) {
        // A try-catch nem kell, ha InvalidFriendNameException extends RuntimeException
        try {
            FriendList list = new FriendList();
            list.addFriend("Anna");
            list.addFriend("Béla");
            list.addFriend("Marcell");
            //list.addFriend("asztal");
            //list.addFriend("");
            System.out.println(Arrays.toString(list.getFriends()));
        } catch (InvalidFriendNameException e)

        {
            //System.out.println("Valami baj történt");
            //System.out.println(e.getMessage());
            //e.printStackTrace();
            switch (e.getErrorCode()) {
                case NAME_NOT_STARTING_WITH_UPPER_CASE -> System.out.println("A névnek nagy betűvel kell kezdődnie!");
                case NAME_IS_BLANK -> System.out.println("A név nem lehet üres!");
            }
            e.printStackTrace();
        }
    }
}