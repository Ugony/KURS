package root.entities;

import java.io.IOException;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

public class Display extends PC_Info {

    private static final String wmic_path_Win32_DesktopMonitor_get = "wmic path Win32_DesktopMonitor ";

    enum Display_Parameters {
        Availability,
        Bandwidth,
        Caption,
        ConfigManagerErrorCode,
        ConfigManagerUserConfig,
        CreationClassName,
        Description,
        DeviceID,
        DisplayType,
        ErrorCleared,
        ErrorDescription,
        InstallDate,
        IsLocked,
        LastErrorCode,
        MonitorManufacturer,
        MonitorType,
        Name,
        PixelsPerXLogicalInch,
        PixelsPerYLogicalInch,
        PNPDeviceID,
        PowerManagementCapabilities,
        PowerManagementSupported,
        ScreenHeight,
        ScreenWidth,
        Status,
        StatusInfo,
        SystemCreationClassName,
        SystemName

    }

    public void writeToDocument(XWPFDocument document) throws IOException {


        XWPFParagraph paragraph = document.createParagraph();
        XWPFRun run = paragraph.createRun();
        run.setText("\n *********************** Display Desktop Information ***********************  ");

        System.out.println(
                "\n *********************** Display Desktop Information ***********************  ");
       getFullInfoAboutCurrentParameter(wmic_path_Win32_DesktopMonitor_get + "get", Display_Parameters.values(),  document);

    }

    @Override
    public void showComponent() {
        getCommandOutput(wmic_path_Win32_DesktopMonitor_get);
    }

}



