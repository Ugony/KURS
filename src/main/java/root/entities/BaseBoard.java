package root.entities;

import java.io.IOException;
import java.util.Scanner;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

public class BaseBoard extends PC_Info {

    private static final String wmic_baseboard_get = "wmic baseboard";

    enum BaseBoard_Parameters {
        Caption,
        ConfigOptions,
        CreationClassName,
        Depth,
        Description,
        Height,
        HostingBoard,
        HotSwappable,
        InstallDate,
        Manufacturer,
        Model,
        Name,
        OtherIdentifyingInfo,
        PartNumber,
        PoweredOn,
        Product,
        Removable,
        Replaceable,
        RequirementsDescription,
        RequiresDaughterBoard,
        SerialNumber,
        SKU,
        SlotLayout,
        SpecialRequirements,
        Status,
        Tag,
        Version,
        Weight,
        Width

    }

    public void writeToDocument(XWPFDocument document) throws IOException {


        XWPFParagraph paragraph = document.createParagraph();
        XWPFRun run = paragraph.createRun();
        run.setText("\n *********************** BaseBoard Information ***********************  ");


        System.out.println(
                "\n *********************** BaseBoard Information ***********************  ");

        getFullInfoAboutCurrentParameter(
                wmic_baseboard_get + " get",
                BaseBoard_Parameters.values(),
                document);

    }

    @Override
    public void showComponent() {
        getCommandOutput(wmic_baseboard_get);
    }
}



