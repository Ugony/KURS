package root.entities;



import java.io.IOException;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;


public class GraphicCard extends PC_Info {
    enum GraphicCard_Parameters {
//        AcceleratorCapabilities,
        AdapterCompatibility,
        AdapterDACType,
        AdapterRAM,
        Availability,
//        CapabilityDescriptions,
        Caption,
//        ColorTableEntries,
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
//        DeviceSpecificPens,
        DitherType,
        DriverDate,
        DriverVersion,
//        ErrorCleared,
//        ErrorDescription,
//        ICMIntent,
//        ICMMethod,
        InfFilename,
        InfSection,
//        InstallDate,
        InstalledDisplayDrivers,
//        LastErrorCode,
//        MaxMemorySupported,
//        MaxNumberControlled,
        MaxRefreshRate,
        MinRefreshRate,
        Monochrome,
        Name,
//        NumberOfColorPlanes,
//        NumberOfVideoPages,
        PNPDeviceID,
//        PowerManagementCapabilities,
//        PowerManagementSupported,
//        ProtocolSupported,
//        ReservedSystemPaletteEntries,
//        SpecificationVersion,
        Status,
//        StatusInfo,
        SystemCreationClassName,
        SystemName,
//        SystemPaletteEntries,
//        TimeOfLastReset,
        VideoArchitecture,
        VideoMemoryType,
//        VideoMode,
        VideoModeDescription,
        VideoProcessor

    }

    public void writeToDocument(XWPFDocument document) throws IOException {

        XWPFParagraph paragraph = document.createParagraph();
        XWPFRun run = paragraph.createRun();
        run.setText("\n *********************** GraphicCard Information ***********************  ");


        System.out.println(
                "\n *********************** GraphicCard Information ***********************  ");
        getFullInfoAboutCurrentParameter("wmic path Win32_Videocontroller get", GraphicCard_Parameters.values(), document);

    }

}

