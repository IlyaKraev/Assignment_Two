package org.pcedu.assignmenttwo.dao;

import java.util.List;
import org.hibernate.Criteria;
import org.pcedu.assignmenttwo.entities.Trainer;
import org.springframework.stereotype.Repository;

@Repository("trainerDao")
public class TrainerDaoImpl extends AbstractDao<Integer, Trainer> implements ITrainerDao {

    @Override
    public List<Trainer> findTrainers() {
        Criteria criteria = createEntityCriteria();
        return (List<Trainer>) criteria.list();
    }

    public boolean save(Trainer trainer) {
        boolean notSaved = persist(trainer);
        if (notSaved) {
            return false;
        }
        return true;
    }

    public boolean delete(int id) {
        Trainer t = getByKey(id);
        if (t != null) {
            delete(t);
            if (getByKey(id) == null) {
                return true;
            }
        }
        return false;
    }

    public Trainer findById(int id) {
        Trainer t = getByKey(id);
        if (t != null) {
            return t;
        }
        return null;
    }

    public boolean update(Trainer trainer) {
        Trainer db_trainer = findById(trainer.getId());
        if (db_trainer != null) {
            db_trainer.setFirstname(trainer.getFirstname());
            db_trainer.setLastname(trainer.getLastname());
            db_trainer.setDateofbirth(trainer.getDateofbirth());
            db_trainer.setSubject(trainer.getSubject());
            return save(db_trainer);
        } else {
            return false;
        }
    }
}
