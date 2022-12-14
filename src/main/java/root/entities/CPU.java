package root.entities;

import java.io.IOException;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

public class CPU extends PC_Info {
    enum CPUParameters {
        AddressWidth,
        Architecture,
        AssetTag,
        Availability,
      //  Caption,
        Characteristics,
//        ConfigManagerErrorCode,
//        ConfigManagerUserConfig,
        CpuStatus,
        CreationClassName,
        CurrentClockSpeed,
        CurrentVoltage,
        DataWidth,
      //  Description,
        DeviceID,
//        ErrorCleared,
//        ErrorDescription,
        ExtClock,
        Family,
//        InstallDate,
        L2CacheSize,
//        L2CacheSpeed,
        L3CacheSize,
        L3CacheSpeed,
//        LastErrorCode,
        Level,
        LoadPercentage,
        Manufacturer,
        MaxClockSpeed,
       // Name,
        NumberOfCores,
        NumberOfEnabledCore,
        NumberOfLogicalProcessors,
//        OtherFamilyDescription,
  //      PartNumber,
//        PNPDeviceID,
     //   PowerManagementCapabilities,
        PowerManagementSupported,
        ProcessorId,
        ProcessorType,
//        Revision,
        Role,
        SecondLevelAddressTranslationExtensions,
   //     SerialNumber,
        SocketDesignation,
        Status,
        StatusInfo,
//        Stepping,
        SystemCreationClassName,
        SystemName,
        ThreadCount,
//        UniqueId,
        UpgradeMethod,
//        Version,
        VirtualizationFirmwareEnabled,
        VMMonitorModeExtensions
//        VoltageCaps
    }

    //    information about CPU
    public  void writeToDocument(XWPFDocument document) throws IOException {

        XWPFParagraph paragraph = document.createParagraph();
        XWPFRun run = paragraph.createRun();
        run.setText("\n *********************** CPU Information ***********************  ");


        System.out.println("\n *********************** CPU Information ***********************  ");
        getFullInfoAboutCurrentParameter("wmic cpu get", CPUParameters.values(), document);

    }
}
