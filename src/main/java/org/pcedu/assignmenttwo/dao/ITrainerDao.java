package org.pcedu.assignmenttwo.dao;

import java.util.List;
import org.pcedu.assignmenttwo.entities.Trainer;

public interface ITrainerDao {

    public List<Trainer> findTrainers();

    public Trainer findById(int id);

    public boolean save(Trainer trainer);

    public boolean delete(int id);

    public boolean update(Trainer trainer);
}
