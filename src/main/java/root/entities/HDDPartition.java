package root.entities;

import java.io.IOException;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

public class HDDPartition extends PC_Info {

    private static final String wmic_partition_get = "wmic partition get ";

    enum HDDPartition_Parameters {
        Access,
        Availability,
        BlockSize,
        Bootable,
        BootPartition,
        Caption,
        ConfigManagerErrorCode,
        ConfigManagerUserConfig,
        CreationClassName,
        Description,
        DeviceID,
        DiskIndex,
        ErrorCleared,
        ErrorDescription,
        ErrorMethodology,
        HiddenSectors,
        Index,
        InstallDate,
        LastErrorCode,
        Name,
        NumberOfBlocks,
        PNPDeviceID,
        PowerManagementCapabilities,
        PowerManagementSupported,
        PrimaryPartition,
        Purpose,
        RewritePartition,
        Size,
        StartingOffset,
        Status,
        StatusInfo,
        SystemCreationClassName,
        SystemName,
        Type

    }

    public void writeToDocument(XWPFDocument document) throws IOException {

        XWPFParagraph paragraph = document.createParagraph();
        XWPFRun run = paragraph.createRun();
        run.setText("\n *********************** Information about the partitions of HardDrive ***********************  ");


        System.out.println("\n *********************** Information about the partitions of HardDrive  ***********************  ");
        getFullInfoAboutCurrentParameter(wmic_partition_get , HDDPartition_Parameters.values(),  document);

    }

    @Override
    public void showComponent() {
        getCommandOutput(wmic_partition_get + "* /format:list");
    }

}
