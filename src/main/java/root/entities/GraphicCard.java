package root.entities;


import java.io.IOException;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;


public class GraphicCard extends PC_Info {

    private static final String wmic_path_Win32_Videocontroller_get = "wmic path Win32_Videocontroller ";

    enum GraphicCard_Parameters {
        AdapterCompatibility,
        AdapterDACType,
        AdapterRAM,
        Availability,
        Caption,
        ConfigManagerErrorCode,
        ConfigManagerUserConfig,
        CreationClassName,
        CurrentBitsPerPixel,
        CurrentHorizontalResolution,
        CurrentNumberOfColors,
        CurrentNumberOfColumns,
        CurrentNumberOfRows,
        CurrentRefreshRate,
        CurrentScanMode,
        CurrentVerticalResolution,
        Description,
        DeviceID,
        DitherType,
        DriverDate,
        DriverVersion,
        InfFilename,
        InfSection,
        InstalledDisplayDrivers,
        MaxRefreshRate,
        MinRefreshRate,
        Monochrome,
        Name,
        PNPDeviceID,
        Status,
        SystemCreationClassName,
        SystemName,
        VideoArchitecture,
        VideoMemoryType,
        VideoModeDescription,
        VideoProcessor

    }

    public void writeToDocument(XWPFDocument document) throws IOException {

        XWPFParagraph paragraph = document.createParagraph();
        XWPFRun run = paragraph.createRun();
        run.setText("\n *********************** GraphicCard Information ***********************  ");


        System.out.println(
                "\n *********************** GraphicCard Information ***********************  ");
        getFullInfoAboutCurrentParameter(wmic_path_Win32_Videocontroller_get +
                "get",
                GraphicCard_Parameters.values(),
                document);

    }

    @Override
    public void showComponent() {
        getCommandOutput(wmic_path_Win32_Videocontroller_get);
    }

}

