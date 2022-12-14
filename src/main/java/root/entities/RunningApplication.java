package root.entities;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

public class RunningApplication extends PC_Info {

    enum Parameters {
        ProcessName, Handles, NPM, PM, WS, CPU, Id, SI
    }


    public  void writeToDocument(XWPFDocument document) {

        XWPFParagraph paragraph = document.createParagraph();
        XWPFRun run = paragraph.createRun();
        run.setText("\n *********************** Running Apps Information ***********************  ");

        getFullInfoAboutCurrentParameter("powershell \"gps | where  {$_.MainWindowTitle } | Select ", Parameters.values(), document);

    }
}
