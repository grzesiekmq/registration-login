package com.task;

import nl.flotsam.xeger.Xeger;
import dk.brics.automaton;
import org.apache.commons.validator.routines.EmailValidator;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Login {
    public void login() {
        System.out.printf("LOGOWANIE %s %n", getProvideUser());
        username = scanner.nextLine();
        setUsername(username);

        System.out.printf("Hasło: %s %n", getPassword());
    }
}

class Account {
    private String newEmail, newTel;

    public void showAccount() {
        System.out.printf("KONTO %n %s %n Witaj %s %n", getUsername());
        System.out.println("Zmiana adresu email");
        newEmail = scanner.nextLine();
        System.out.printf("Nowy adres email: %s %n Zmiana nr telefonu %n", newEmail);

        newTel = scanner.nextLine();
        System.out.printf("Nowy nr telefonu: %s %n", newTel);
    }
}

class Register {
    private String username, password, email, tel;

    // wzorce przed kompilacją
    String userPattern = ".{3,}";
    String telPattern = "\\d{9}";

    String lower = "[a-z]{5,}";
    String upper = "[A-Z]";
    String digits = "[0-9]";
    String specialChars = "[^\\[a-zA-Z0-9\\]]";

    String passwordPattern = lower + upper + digits + specialChars;
    // wzorce po kompilacji
    Pattern pUser = Pattern.compile(userPattern);
    Pattern pTel = Pattern.compile(telPattern);

    String provideUser = "Podaj nazwę użytkownika";

    public String PasswordPattern(String lower, String upper, String digits, String specialChars) {
        this.lower = lower;
        this.upper = upper;
        this.digits = digits;
        this.specialChars = specialChars;

        return passwordPattern;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return passwordPattern;
    }

    public void setPassword(String passwordPattern) {
        this.passwordPattern = passwordPattern;
    }

    public String getProvideUser() {
        return provideUser;
    }

    Xeger generator = new Xeger(passwordPattern);
    password = generator.generate();

    public void register() {
        System.out.printf("REJESTRACJA %n %s %n", getProvideUser());
        username = scanner.nextLine();
        setUsername(username);

        Matcher userMatcher = pUser.matcher(getUsername());

        if (userMatcher.find())

        {
            System.out.printf("Nazwa użytkownika: %s %n", getUsername());
        } else

        {
            System.err.println("Podałeś za krótką nazwę użytkownika");
        }
        System.out.printf("Wygenerowane hasło: %s %n Podaj adres email %n", password);

        email = scanner.nextLine();

        boolean valid = EmailValidator.getInstance().isValid(email);
        if (valid)

        {
            System.out.printf("Email: %s %n", email);
        } else

        {
            System.err.println("Niepoprawny email");
        }
        System.out.println("Podaj nr telefonu");
        tel = scanner.nextLine();
        Matcher telMatcher = pTel.matcher(tel);

        if (telMatcher.find())

        {
            System.out.printf("Nr telefonu: %s %n", tel);
        } else

        {
            System.err.println("Niepoprawny nr telefonu");
        }
    }


}

public class Task {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        register();
        login();
        showAcount();

    }
}
