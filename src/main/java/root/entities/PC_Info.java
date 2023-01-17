package root.entities;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;

public abstract class PC_Info {


    public void getFullInfoAboutCurrentParameter(
            String command,
            Enum[] values,
            XWPFDocument document) {
        try {

            // Writing the Document in file system
            FileOutputStream out = new FileOutputStream(
                    new File("C:/Projects/SuperPuperPC_INFO.docx"));

            // Creating a table
            XWPFTable table = document.createTable();


            StringBuilder stringBuilder = new StringBuilder();


            for (int i = 0; i < values.length; i++) {

                if (table.getRow(i) == null) {
                    table.createRow();
                }
                XWPFTableRow tableRow = table.getRow(i);
                tableRow.getCell(0).setText(values[i].name());

                Scanner sc = runCommand(command, values[i].name());

                int counter = 1;
                while (sc.hasNextLine()) {
                    String next = sc.nextLine();

                    if (!next.contains(values[i].name()) && !StringUtils.isBlank(next.trim())) {
                        if (tableRow.getCell(counter) == null) {
                            tableRow.createCell();
                        }
                        tableRow.getCell(counter).setText(next);
                        counter++;
                    }

                }
                sc.close();


            }
            System.out.println(stringBuilder);
            document.write(out);
            out.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    protected Scanner runCommand(String command, String name) throws IOException {
        Process process = Runtime.getRuntime().exec(
                command + " " + name);

        process.getOutputStream().close();
        return new Scanner(process.getInputStream());
    }

    public abstract void writeToDocument(XWPFDocument document) throws IOException;

    protected void getCommandOutput(String command) {
            try {
                Scanner sc = runCommand(command, "");
                while (sc.hasNextLine()) {
                    String nextLine = sc.nextLine();
                    if (!StringUtils.isBlank(nextLine.trim())) System.out.println(nextLine);
                }
                sc.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
    }

    public abstract void showComponent();



}
