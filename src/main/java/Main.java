import java.util.Scanner;

public class Main {
    private Scanner scanner = new Scanner(System.in);
    private UserService userService;

    public static void main(String[] args) {
        //W klasie main utwórz proste menu do obsługi hotelu, przykłady implementacji (prosta pętla
        //do…while + switch):

        //1. https://stackoverflow.com/a/13536215/5877109
        //2. http://chronicles.blog.ryanrampersad.com/2011/03/text-based-menu-in-java/

        do {
            Main main = new Main();
            main.display();
        } while (true);

    } //end main


    public void display() {
        System.out.println("======Hotel Menu=======");
        System.out.println(
                "Wybierz jedną z podanych opcji: \n " +
                        "1) Wyświetl listę pokoi wraz z ich statusem (wolny-zajęty) \n" +
                        "2) Wyświetl listę tylko dostępnych pokoi \n" +
                        "3) Zarezerwuj pokój \n" +
                        "4) Zwolnij pokój \n" +
                        "5) Wyjdź z programu"
        );
        try {
            int selection = scanner.nextInt();
            scanner.nextLine();
            switch (selection) {
                case 1:
                    System.out.println("Lista pokoi wraz z ich statusem (wolny-zajęty)");
                    //TODO: Dodać na koniec hotelService.funkcja we wszystkich czterech przypadkach
                    break;
                case 2:
                    System.out.println("Lista tylko dostępnych pokoi");
                    break;
                case 3:
                    System.out.println("Rezerwacja pokoju");
                    break;
                case 4:
                    System.out.println("Zwolnienie pokoju");
                    break;
                case 5:
                    exit();
                default:
                    System.out.println("Proszę podać numer opcji od 1 do 4");
                    break;
            }
        } catch (NumberFormatException ex) {
            System.out.println("Dopuszczalne są tylko cyfry od 1 do 4. Nie używaj innych znaków");
        }


    }

    private static void exit() {
        System.out.println("Wychodzę z programu");
        System.exit(1);
    }
}