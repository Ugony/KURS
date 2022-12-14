package root.entities;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

public class BIOS extends PC_Info {
    enum Parameters {
        BiosCharacteristics,
        BIOSVersion,
        BuildNumber,
        Caption,
        CodeSet,
        CurrentLanguage,
        Description,
        EmbeddedControllerMajorVersion,
        EmbeddedControllerMinorVersion,
        IdentificationCode,
        InstallableLanguages,
        InstallDate,
        LanguageEdition,
        ListOfLanguages,
        Manufacturer,
        Name,
        OtherTargetOS,
        PrimaryBIOS,
        ReleaseDate,
        SerialNumber,
        SMBIOSBIOSVersion,
        SMBIOSMajorVersion,
        SMBIOSMinorVersion,
        SMBIOSPresent,
        SoftwareElementID,
        SoftwareElementState,
        Status,
        SystemBiosMajorVersion,
        SystemBiosMinorVersion,
        TargetOperatingSystem,
        Version
    }

    public  void writeToDocument(XWPFDocument document) {


        XWPFParagraph paragraph = document.createParagraph();
        XWPFRun run = paragraph.createRun();
        run.setText("\n *********************** BIOS Information ***********************  ");


        System.out.println("\n *********************** BIOS Information ***********************  ");
        getFullInfoAboutCurrentParameter("wmic bios get", Parameters.values(),  document);

    }
}
