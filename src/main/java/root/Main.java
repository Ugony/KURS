package root;

import root.entities.PC_Info;
import root.utils.*;

import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

public class Main {

    public static void main(String[] args) throws IOException {
        Factory factory = new Factory();
        XWPFDocument document = new XWPFDocument();
        for (Component value : Component.values()) {
            PC_Info components = factory.getComponents(value);
            components.writeToDocument(document);
        }
        showWindowsWorkTime();
        showUserLOGONTime();
    }

    public static void showWindowsWorkTime() throws IOException {

        Process process = Runtime.getRuntime().exec(
                "powershell -command \"(get-date) - (gcim Win32_OperatingSystem).LastBootUpTime\" ");

        process.getOutputStream().close();
        Scanner sc = new Scanner(process.getInputStream());

        while (sc.hasNextLine()) {
            System.out.println(sc.nextLine());
        }

    }

    public static void showUserLOGONTime() throws IOException {

        Process process = Runtime.getRuntime().exec(
                "quser");

        process.getOutputStream().close();
        Scanner sc = new Scanner(process.getInputStream());

        while (sc.hasNextLine()) {
            String str = sc.nextLine();
            List<String> arr = Arrays
                    .stream(str.split(" "))
                    .filter(s -> !StringUtils.isBlank(s))
                    .collect(
                            Collectors.toList());
            for (int i = 0; i < arr.size(); i++) {
                if (arr
                        .get(i)
                        .matches(
                                "^([1-9]|([012][0-9])|(3[01]))\\.([0]{0,1}[1-9]|1[012])\\.\\d\\d\\d\\d")) {
                    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
                    String userLogonTime = arr.get(i) + " " + arr.get(i + 1);
                    LocalDateTime ld = LocalDateTime.parse(userLogonTime, dtf);
                    long duration = Duration.between(ld, LocalDateTime.now()).toMillis();
                    System.out.println("User LOGON date is "
                            + userLogonTime
                            + ". User spent  "
                            + duration
                            + " milliseconds in the system");
                    parseDuration(duration);
                }
            }

        }

    }

    private static void parseDuration(long difference_In_Time) {
        long difference_In_Days
                = (difference_In_Time
                / (1000 * 60 * 60 * 24));

        long difference_In_Hours
                = (difference_In_Time - difference_In_Days
                / (1000 * 60 * 60));

        long difference_In_Minutes
                = (difference_In_Time - difference_In_Hours
                / (1000 * 60));


        long difference_In_Seconds
                = (difference_In_Time - difference_In_Minutes
                / 1000);

        System.out.println(
                +(difference_In_Days % 365)
                        + " days, "
                        + (difference_In_Hours % 24)
                        + " hours, "
                        + (difference_In_Minutes % 60)
                        + " minutes, "
                        + (difference_In_Seconds % 60)
                        + " seconds");
    }


}