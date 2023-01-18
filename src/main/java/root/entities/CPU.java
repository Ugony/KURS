package root.entities;

import java.io.IOException;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

public class CPU extends PC_Info {

    private static final String wmic_cpu_get = "wmic cpu get ";

    enum CPUParameters {
        AddressWidth,
        Architecture,
        AssetTag,
        Availability,
        Characteristics,
        CpuStatus,
        CreationClassName,
        CurrentClockSpeed,
        CurrentVoltage,
        DataWidth,
        DeviceID,
        ExtClock,
        Family,
        L2CacheSize,
        L3CacheSize,
        L3CacheSpeed,
        Level,
        LoadPercentage,
        Manufacturer,
        MaxClockSpeed,
        NumberOfCores,
        NumberOfEnabledCore,
        NumberOfLogicalProcessors,
        PowerManagementSupported,
        ProcessorId,
        ProcessorType,
        Role,
        SecondLevelAddressTranslationExtensions,
        SocketDesignation,
        Status,
        StatusInfo,
        SystemCreationClassName,
        SystemName,
        ThreadCount,
        UpgradeMethod,
        VirtualizationFirmwareEnabled,
        VMMonitorModeExtensions

    }

    public void writeToDocument(XWPFDocument document) throws IOException {

        XWPFParagraph paragraph = document.createParagraph();
        XWPFRun run = paragraph.createRun();
        run.setText("\n *********************** CPU Information ***********************  ");


        System.out.println("\n *********************** CPU Information ***********************  ");
        getFullInfoAboutCurrentParameter(wmic_cpu_get, CPUParameters.values(), document);

    }

    @Override
    public void showComponent() {
        getCommandOutput(wmic_cpu_get + "* /format:list");
    }

}
