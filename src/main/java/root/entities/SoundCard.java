package root.entities;

import java.io.IOException;
import java.util.Arrays;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

public class SoundCard extends PC_Info {

    private static final String wmic_sounddev_get = "wmic sounddev get ";


    enum SoundCard_Parameters {
        Availability,
        Caption,
        ConfigManagerErrorCode,
        ConfigManagerUserConfig,
        CreationClassName,
        Description,
        DeviceID,
        DMABufferSize,
        ErrorCleared,
        ErrorDescription,
        InstallDate,
        LastErrorCode,
        Manufacturer,
        MPU401Address,
        Name,
        PNPDeviceID,
        PowerManagementCapabilities,
        PowerManagementSupported,
        ProductName,
        Status,
        StatusInfo,
        SystemCreationClassName,
        SystemName

    }

    public void writeToDocument(XWPFDocument document)throws IOException {

        XWPFParagraph paragraph = document.createParagraph();
        XWPFRun run = paragraph.createRun();
        run.setText("\n *********************** SoundCard Information ***********************  ");

        System.out.println(
                "\n *********************** SoundCard Information ***********************  ");
        getFullInfoAboutCurrentParameter(wmic_sounddev_get, SoundCard_Parameters.values(), document);

    }


    @Override
    public void showComponent() {
        getCommandOutput(wmic_sounddev_get+ "* /format:list");
    }

}
