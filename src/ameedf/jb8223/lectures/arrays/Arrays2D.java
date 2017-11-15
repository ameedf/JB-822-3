package ameedf.jb8223.lectures.arrays;

public class Arrays2D {
    public static void main(String[] args) {
        String[][] personsFriends;
        personsFriends = new String[3][];
        personsFriends[0] = new String[3]; // person at index 0 has 3 friends
        personsFriends[0][0] = "Avi";
        personsFriends[0][1] = "Nissim";
        personsFriends[0][2] = "Dan";
        System.out.println("Person 0 has " + personsFriends[0].length + " friends:");
        System.out.println(personsFriends[0][0] + ", " + personsFriends[0][1] + ", " + personsFriends[0][2]);

        personsFriends[1] = new String[]{"Tami", "Ami"};
        System.out.println("Person 1 has " + personsFriends[1].length + " friends:");
        System.out.println(personsFriends[1][0] + ", " + personsFriends[1][1]);

        System.out.println("The whole list:");
        for (String[] friends : personsFriends) {
            if (friends != null) {
                System.out.print(friends.length + " friends found: ");
                for (String friendName : friends) {
                    System.out.print(friendName + ", ");
                }
                System.out.println("\n--------------------");
            }
        }


    }
}
