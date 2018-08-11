package contracts;

import exeptions.DuplicateModelException;
import models.boats.BaseBoat;

import java.util.List;

public interface Race
{
    int getDistance();

    int getWindSpeed();

    int getOceanCurrentSpeed();

    Boolean getAllowsMotorboats();

    void addParticipant(BaseBoat boat) throws DuplicateModelException;

    List<BaseBoat> getParticipants();
}
