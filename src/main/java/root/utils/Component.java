package root.utils;

public enum Component {
    BASE_BOARD("Информация о материнской плате"),
    BIOS("Информация о BIOS"),
    CPU("Информация о ЦП"),
    DISPLAY("Информация о мониторе"),
    GRAPHIC_CARD("Информация о видеокарте"),
    HARDWARE_DISK("Информация о жестком диске"),
    HDD_PARTITION("Информация о разделах жесткого диска"),
    KEY_BOARD("Информация о клавиатуре"),
    MOUSE("Информация о mouse"),
    RUNNING_APPS("Информация о запущеных приложениях"),
    SOUND_CARD("Информация о звуковой карте"),
    NETWORK_ADAPTER("Информация о сетевых адаптерах");

    private String value;

    Component(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
