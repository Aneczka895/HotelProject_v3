import java.time.LocalDate;

public class Guest {
    private String name;
    private LocalDate birthday;

    public Guest(String name, String birthday) {
        this.name = name;
        this.birthday = LocalDate.parse(birthday);
    }

    public LocalDate getBirthday() {
        return birthday;
    }
}
