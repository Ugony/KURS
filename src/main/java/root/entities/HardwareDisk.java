package root.entities;

import java.io.IOException;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

public class HardwareDisk extends PC_Info {

    private static final String wmic_diskdrive_get = "wmic diskdrive ";


    enum HDD_Parameters {
        Availability,
        BytesPerSector,
        Capabilities,
        CapabilityDescriptions,
        Caption,
        CompressionMethod,
        ConfigManagerErrorCode,
        ConfigManagerUserConfig,
        CreationClassName,
        DefaultBlockSize,
        Description,
        DeviceID,
        ErrorCleared,
        ErrorDescription,
        ErrorMethodology,
        FirmwareRevision,
        Index,
        InstallDate,
        InterfaceType,
        LastErrorCode,
        Manufacturer,
        MaxBlockSize,
        MaxMediaSize,
        MediaLoaded,
        MediaType,
        MinBlockSize,
        Model,
        Name,
        NeedsCleaning,
        NumberOfMediaSupported,
        Partitions,
        PNPDeviceID,
        PowerManagementCapabilities,
        PowerManagementSupported,
        SCSIBus,
        SCSILogicalUnit,
        SCSIPort,
        SCSITargetId,
        SectorsPerTrack,
        SerialNumber,
        Signature,
        Size,
        Status,
        StatusInfo,
        SystemCreationClassName,
        SystemName,
        TotalCylinders,
        TotalHeads,
        TotalSectors,
        TotalTracks,
        TracksPerCylinder
    }

    public void writeToDocument(XWPFDocument document) throws IOException {


        XWPFParagraph paragraph = document.createParagraph();
        XWPFRun run = paragraph.createRun();
        run.setText("\n *********************** HardwareDisk Information ***********************  ");

        System.out.println("\n *********************** HardDrive Information ***********************  ");
        getFullInfoAboutCurrentParameter(wmic_diskdrive_get + "get", HDD_Parameters.values(),  document);

    }

    @Override
    public void showComponent() {
        getCommandOutput(wmic_diskdrive_get);
    }

}
