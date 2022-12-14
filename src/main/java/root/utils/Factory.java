package root.utils;

import root.entities.*;

public class Factory {

    public PC_Info getComponents(Component components) {
        switch (components) {
            case CPU:
                return new CPU();
            case BIOS:
                return new BIOS();
            case MOUSE:
                return new Mouse();
            case DISPLAY:
                return new Display();
            case KEY_BOARD:
                return new KeyBoard();
            case BASE_BOARD:
                return new BaseBoard();
            case SOUND_CARD:
                return new SoundCard();
            case GRAPHIC_CARD:
                return new GraphicCard();
            case RUNNING_APPS:
                return new RunningApplication();
            case HARDWARE_DISK:
                return new HardwareDisk();
            case HDD_PARTITION:
                return new HDDPartition();
            case NETWORK_ADAPTER:
                return new NetworkAdapters();
        }
        return null;
    }

}
