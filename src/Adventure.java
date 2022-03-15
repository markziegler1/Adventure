import java.util.Scanner;

public class Adventure {

  Scanner scan = new Scanner(System.in);
  PlayerInfo playerName = new PlayerInfo();
  Room Room1 = new Room(" Azeroth (world 1)");
  Room Room2 = new Room(" Stormwind (room 2)");
  Room Room3 = new Room(" Draenor (world 3)");
  Room Room4 = new Room(" Outland (world 4)");
  Room Room5 = new Room(" Shadowlands (world 5)");
  Room Room6 = new Room(" Orgrimmar (room 6)");
  Room Room7 = new Room(" Oribos (room 7)");
  Room Room8 = new Room(" The Maw (room 8)");
  Room Room9 = new Room(" Undercity (room 9)");

  private Room currentRoom;
  private boolean isPlaying = true;

  void Rooms () {

    Room1.setEast(Room2);
    Room1.setSouth(Room4);
    Room1.setDescription("This is the world where the adventure begins!\n\n" +
        "This is Azeroth. A dangerous, beautiful, magical, and inspiring world. A world filled with discovery, innovation, and wonder.\n" +
        " A world worth fighting for. A world worth protecting..\n");

    Room2.setEast(Room3);
    Room2.setWest(Room1);
    Room2.setDescription("Welcome to Stormwind.\n" +
        "Stormwind is the jewel of the Alliance in Azeroth. The grandest human city left, it has weathered three wars, ransacking by the orcs, and invasions by the Alliance to take it back\n " +
        "Although mostly a human city, Stormwind does house dwarves, high elves, night elves, worgen, pandaren, and other Alliance races.\n");

    Room3.setSouth(Room6);
    Room3.setWest(Room2);
    Room3.setDescription("Welcome to Draenor.\n" +
        "Draenor is a land of magma and metal, stone and steam.\n ");

    Room4.setNorth(Room1);
    Room4.setSouth(Room7);
    Room4.setDescription("Outland.\n" +
        "Outland is the shattered floating remnants of the destroyed world of Draenor, the homeworld of the orcs and refuge of the draenei.");

    Room5.setSouth(Room8);
    Room5.setDescription("You are in the Shadowlands!\n" +
        "The Shadowlands are home to an entire universe of the departed.\n"  +
        "Journey through hidden realms of wonders and horrors that await any who pass to the other side..");

    Room6.setNorth(Room3);
    Room6.setSouth(Room9);
    Room6.setDescription("You arrived in Orgrimmar\n" +
        "Orgrimmar was founded in the valleys and caverns of northern Durotar as the new home of the orcish race and the capital of the Horde.\n");

    Room7.setEast(Room8);
    Room7.setNorth(Room4);
    Room7.setDescription("Oribos " +
        "Oribos is the gateway to the afterlives of the Shadowlands.\n" +
        "where souls begin their journey in the thereafter and the first sight a soul beholds with their newly unliving eyes after their arrival is the eternal city.\n.\n");

    Room8.setNorth(Room5);
    Room8.setWest(Room7);
    Room8.setEast(Room9);
    Room8.setDescription("Arriving at The Maw.\n" +
        "This horrific place houses the most vile and irredeemable souls in existence.\n");

    Room9.setNorth(Room6);
    Room9.setWest(Room8);
    Room9.setDescription("You are now standing at Undercity.\n" +
        "Far beneath the ruined capital city of Lordaeron, the royal crypts have been turned into a bastion of evil and undeath.\n");

  }
  void Welcome () {
    System.out.println("Please enter your player name: ");
    playerName.setPlayerName(scan.nextLine());
    System.out.println("Hi " + playerName.getPlayerName());
    System.out.println("Welcome to the adventure game!");

  }
  void playerChoice() {
    char input;
    currentRoom = Room1;
    while (isPlaying) {
      System.out.println("Enter one of the following: [n]orth, [s]outh, [e]ast, [w]est, [l]ook, [h]elp, or [E]xit: ");
      input = scan.next().charAt(0);
      switch (input) {
        case 'n':
          Rooms();
          if(currentRoom.getNorth() != null) {
            currentRoom = currentRoom.getNorth();
            System.out.println("Going north");
            System.out.println("You are standing in: " + currentRoom.getName());
          }else {
            System.out.println("You can't go that direction");

          }
          break;
        case 's':
          Rooms();
          if(currentRoom.getSouth() != null) {
            currentRoom = currentRoom.getSouth();
            System.out.println("Going south");
            System.out.println("You are standing in: " + currentRoom.getName());
          }else {
            System.out.println("You can't go that direction");
          }
          break;
        case 'e':
          Rooms();
          if(currentRoom.getEast() != null) {
            currentRoom = currentRoom.getEast();
            System.out.println("Going East");
            System.out.println("You are standing in: " + currentRoom.getName());
          }else {
            System.out.println("You can't go that direction");
          }
          break;
        case 'w':
          Rooms();
          if(currentRoom.getWest() != null) {
            currentRoom = currentRoom.getWest();
            System.out.println("Going west");
            System.out.println("You are standing in: " + currentRoom.getName());
          }else {
            System.out.println("You can't go that direction");
          }
          break;
        case 'l':
          System.out.println(playerName.getPlayerName() + " looks around the room.\n\n");
          System.out.println(currentRoom.getDescription());
          break;
        case 'h':
          System.out.println("You generally have six actions at any given time you can perform:\n" +
              "Press n and press enter to go to the room north of your current position.\n" +
              "Press s and press enter to go to the room south of your current position.\n" +
              "Press e and press enter to go to the room east of your current position.\n" +
              "Press w and press enter to go to the room west of your current position.\n" +
              "press l and enter to get a description of the room your standing in.\n" +
              "press E and enter to terminate the program.\n" +
              "You can always press h and enter again to get a list of commands. Hope you have fun! :)");
          break;
        case 'E':
          System.out.println("The program is shutting down, Thanks for playing!");
          isPlaying = false;
      }
    }
  }

  void go() {
    Welcome();
    playerChoice();
  }

  public static void main(String[] args) {
    new Adventure().go();
  }
}