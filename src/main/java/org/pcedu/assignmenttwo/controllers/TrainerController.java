package org.pcedu.assignmenttwo.controllers;

import java.util.List;
import org.pcedu.assignmenttwo.entities.Trainer;
import org.pcedu.assignmenttwo.services.ITrainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = {"/"})
public class TrainerController {

    private final String listurl = "list";
    private final String newurl = "new";
    private final String editurl = "edit";
    private final String deleteurl = "delete";
    private final String updateurl = "update";

    @Autowired
    ITrainer trainerService;

    @RequestMapping(value = {"/", "/list"}, method = RequestMethod.GET)
    public String listAllTrainers(ModelMap view, @RequestParam(required = false) String msg) {
        List<Trainer> trainers = trainerService.viewAllTrainers();
        view.addAttribute("trainers", trainers);
        view.addAttribute("editurl", editurl);
        view.addAttribute("projectName", "Assignment Two");
        view.addAttribute("newurl", newurl);
        view.addAttribute("deleteurl", deleteurl);
        return ("list");
    }

    @RequestMapping(value = {"/new"}, method = RequestMethod.GET)
    public String newTrainer(ModelMap view) {
        Trainer trainer = new Trainer();
        view.addAttribute("trainer", trainer);
        view.addAttribute("newurl", newurl);
        view.addAttribute("listurl", listurl);
        return ("newtrainer");
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public String saveTrainer(ModelMap view, Trainer trainer) {
        trainerService.save(trainer);
        view.addAttribute("newurl", newurl);
        view.addAttribute("listurl", listurl);
        return ("newtrainer");
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteTrainer(ModelMap view, @PathVariable int id) {
        trainerService.delete(id);
        return ("redirect:/list");
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String editTrainer(ModelMap view, @PathVariable int id) {
        Trainer trainer = trainerService.findById(id);
        view.addAttribute("trainer", trainer);
        view.addAttribute("updateurl", updateurl);
        return ("edittrainer");
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String updateStudent(ModelMap view, Trainer trainer) {
        trainerService.update(trainer);
        return ("redirect:/list");
    }
}
