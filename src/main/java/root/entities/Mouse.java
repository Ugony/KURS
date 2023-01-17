package root.entities;

import java.io.IOException;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

public class Mouse extends PC_Info {

    private static final String wmic_path_Win32_PointingDevice_get = "wmic path Win32_PointingDevice ";

    enum Mouse_parameters {
        Availability,
        Caption,
        ConfigManagerErrorCode,
        ConfigManagerUserConfig,
        CreationClassName,
        Description,
        DeviceID,
        DeviceInterface,
        DoubleSpeedThreshold,
        ErrorCleared,
        ErrorDescription,
        Handedness,
        HardwareType,
        InfFileName,
        InfSection,
        InstallDate,
        IsLocked,
        LastErrorCode,
        Manufacturer,
        Name,
        NumberOfButtons,
        PNPDeviceID,
        PointingType,
        PowerManagementCapabilities,
        PowerManagementSupported,
        QuadSpeedThreshold,
        Resolution,
        SampleRate,
        Status,
        StatusInfo,
        Synch,
        SystemCreationClassName,
        SystemName

    }

    public void writeToDocument(XWPFDocument document) throws IOException {


        XWPFParagraph paragraph = document.createParagraph();
        XWPFRun run = paragraph.createRun();
        run.setText("\n *********************** Mouse Information ***********************  ");

        System.out.println(
                "\n *********************** Mouse Information ***********************  ");
        getFullInfoAboutCurrentParameter(wmic_path_Win32_PointingDevice_get + "get", Mouse_parameters.values(),  document);

    }

    @Override
    public void showComponent() {
        getCommandOutput(wmic_path_Win32_PointingDevice_get);
    }

}
