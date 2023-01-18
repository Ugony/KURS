package root.entities;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

public class RunningApplication extends PC_Info {

    private static final String powershell = "powershell \"gps | where  {$_.MainWindowTitle } | Select ";

    enum RunningParameters {
        ProcessName, Handles, NPM, PM, WS, CPU, Id, SI
    }


    public  void writeToDocument(XWPFDocument document) {

        XWPFParagraph paragraph = document.createParagraph();
        XWPFRun run = paragraph.createRun();
        run.setText("\n *********************** Running Apps Information ***********************  ");

        getFullInfoAboutCurrentParameter(powershell, RunningParameters.values(),document);

    }

    @Override
    public void showComponent() {
        getCommandOutput(powershell + "| format-list");
    }

}
