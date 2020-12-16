package org.pcedu.assignmenttwo.services;

import java.util.List;
import org.pcedu.assignmenttwo.entities.Trainer;

public interface ITrainer {

    public List<Trainer> viewAllTrainers();

    public Trainer findById(int id);

    public boolean save(Trainer trainer);

    public boolean delete(int id);

    public boolean update(Trainer trainer);
}
