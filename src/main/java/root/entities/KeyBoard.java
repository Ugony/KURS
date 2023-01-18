package root.entities;

import java.io.IOException;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

public class KeyBoard extends PC_Info {

    private static final String wmic_path_Win32_Keyboard_get = "wmic path Win32_Keyboard get ";

    enum KeyBoard_Parameters {
        Availability,
        Caption,
        ConfigManagerErrorCode,
        ConfigManagerUserConfig,
        CreationClassName,
        Description,
        DeviceID,
        ErrorCleared,
        ErrorDescription,
        InstallDate,
        IsLocked,
        LastErrorCode,
        Layout,
        Name,
        NumberOfFunctionKeys,
        Password,
        PNPDeviceID,
        PowerManagementCapabilities,
        PowerManagementSupported,
        Status,
        StatusInfo,
        SystemCreationClassName,
        SystemName

    }

    public  void writeToDocument(XWPFDocument document) throws IOException {

        XWPFParagraph paragraph = document.createParagraph();
        XWPFRun run = paragraph.createRun();
        run.setText("\n *********************** Keyboard Information ***********************  ");


        System.out.println(
                "\n *********************** Keyboard Information ***********************  ");
        getFullInfoAboutCurrentParameter(wmic_path_Win32_Keyboard_get , KeyBoard_Parameters.values(), document);
//        System.out.println(get());

    }

    @Override
    public void showComponent() {
        getCommandOutput(wmic_path_Win32_Keyboard_get + "* /format:list");
    }

}
