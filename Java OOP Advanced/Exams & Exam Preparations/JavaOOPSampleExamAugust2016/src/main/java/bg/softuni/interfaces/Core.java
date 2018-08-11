package bg.softuni.interfaces;

import bg.softuni.models.enums.CoreStatus;

public interface Core {
    String getType();

    Integer getDurability();

    Stack getFragments();

    String getName();

    CoreStatus getStatus();
}
