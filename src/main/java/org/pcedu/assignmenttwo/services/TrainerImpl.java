/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pcedu.assignmenttwo.services;

import java.util.List;
import org.pcedu.assignmenttwo.dao.TrainerDaoImpl;
import org.pcedu.assignmenttwo.entities.Trainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author mac
 */

@Service("trainerService")
@Transactional
public class TrainerImpl implements ITrainer {
    @Autowired
    TrainerDaoImpl dao;
   
    @Override
    public List<Trainer> viewAllTrainers() {
        List<Trainer> trainers = dao.findTrainers();
        return trainers;
    }

    public boolean save(Trainer trainer) {
        return dao.save(trainer);
    }

    public boolean delete(int id) {
        return dao.delete(id);
    }

    public boolean update(Trainer trainer) {
        dao.update(trainer);
        return true;
    }

    public Trainer findById(int id) {
        return dao.findById(id);
    }

   
}
