package root.entities;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

public class NetworkAdapters extends PC_Info {
    enum Parameter_Adapter {
        AdapterType,
        AdapterTypeId,
        AutoSense,
        Availability,
        Caption,
        ConfigManagerErrorCode,
        ConfigManagerUserConfig,
        CreationClassName,
        Description,
        DeviceID,
        ErrorCleared,
        ErrorDescription,
        GUID,
        Index,
        InstallDate,
        Installed,
        InterfaceIndex,
        LastErrorCode,
        MACAddress,
        Manufacturer,
        MaxNumberControlled,
        MaxSpeed,
        Name,
        NetConnectionID,
        NetConnectionStatus,
        NetEnabled,
        NetworkAddresses,
        PermanentAddress,
        PhysicalAdapter,
        PNPDeviceID,
        PowerManagementCapabilities,
        PowerManagementSupported,
        ProductName,
        ServiceName,
        Speed,
        Status,
        StatusInfo,
        SystemCreationClassName,
        SystemName,
        TimeOfLastReset

    }


    public  void writeToDocument(XWPFDocument document) {

        XWPFParagraph paragraph = document.createParagraph();
        XWPFRun run = paragraph.createRun();
        run.setText("\n *********************** Network adapters Information ***********************  ");

        System.out.println("\n *********************** Network adapters Information ***********************  ");

        getFullInfoAboutCurrentParameter(
                "wmic nic get",
                Parameter_Adapter.values(),
                document);

    }
}
