package root.entities;

import java.io.IOException;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

public class SoundCard extends PC_Info {
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
        getFullInfoAboutCurrentParameter("wmic sounddev get", SoundCard_Parameters.values(),  document);
        //       System.out.println(get());

    }

}


//    private static StringBuilder get() {
//        SystemInfo systemInfo = new SystemInfo();
//        return new StringBuilder().append(systemInfo.getHardware().getUsbDevices(false));
//    }
//}