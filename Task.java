package com.task;

import nl.flotsam.xeger.Xeger;
import org.apache.commons.validator.routines.EmailValidator;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task {
    public static void main(String[] args) {
        String username, password, email, newEmail, tel, newTel;

        // wzorce przed kompilacją
        String userPattern = ".{3,}";
        String lower = "[a-z]{5,}";
        String upper = "[A-Z]";
        String digits = "[0-9]";
        String specialChars = "[^\\[a-zA-Z0-9\\]]";

        String passwordPattern = lower + upper + digits + specialChars;
        String telPattern = "\\d{9}";
        String provideUser = "Podaj nazwę użytkownika";

        // wzorce po kompilacji
        Pattern pUser = Pattern.compile(userPattern);
        Pattern pTel = Pattern.compile(telPattern);

        Xeger generator = new Xeger(passwordPattern);
        password = generator.generate();

        // Scanner
        Scanner scanner = new Scanner(System.in);
        System.out.println("REJESTRACJA");
        System.out.println(provideUser);
        username = scanner.nextLine();
        Matcher userMatcher = pUser.matcher(username);

        if (userMatcher.find()){
            System.out.printf("Nazwa użytkownika: %s %n", username);
        }
        else {
                System.err.println("Podałeś za krótką nazwę użytkownika");          
        }
        System.out.printf("Wygenerowane hasło: %s %n", password);
        System.out.println("Podaj adres email");
        email = scanner.nextLine();

        boolean valid = EmailValidator.getInstance().isValid(email);
        if (valid) {
            System.out.printf("Email: %s %n", email);
        } else {
            System.err.println("Niepoprawny email");
        }
        System.out.println("Podaj nr telefonu");
        tel = scanner.nextLine();
        Matcher telMatcher = pTel.matcher(tel);

        if (telMatcher.find()) {
            System.out.printf("Nr telefonu: %s %n", tel);
        } else {
            System.err.println("Niepoprawny nr telefonu");
        }

        System.out.println("LOGOWANIE");
        System.out.println(provideUser);
        username = scanner.nextLine();
        System.out.printf("Hasło: %s %n", password);

        System.out.println("KONTO");
        System.out.printf("Witaj %s %n", username);
        System.out.println("Zmiana adresu email");
        newEmail = scanner.nextLine();
        System.out.printf("Nowy adres email: %s %n", newEmail);
        System.out.println("Zmiana nr telefonu");
        newTel = scanner.nextLine();
        System.out.printf("Nowy nr telefonu: %s %n", newTel);
    }
}
