package org.pcedu.assignmenttwo.controllers;

import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.pcedu.assignmenttwo.entities.Trainer;
import org.pcedu.assignmenttwo.services.ITrainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;

@Controller
@RequestMapping(value = {"/"})
public class TrainerController {

    private final String listurl = "list";
    private final String newurl = "new";
    private final String editurl = "edit";
    private final String deleteurl = "delete";
    private final String updateurl = "update";

    private String error = "I can't let you do that, " + System.getProperty("user.name");
    
    @Autowired
    ITrainer trainerService;

    @RequestMapping(value = {"/", "/list"}, method = RequestMethod.GET)
    public String listAllTrainers(ModelMap view, HttpServletRequest req) {
        List<Trainer> trainers = trainerService.viewAllTrainers();
        view.addAttribute("trainers", trainers);
        view.addAttribute("editurl", editurl);
        view.addAttribute("newurl", newurl);
        view.addAttribute("deleteurl", deleteurl);
        Map<String, ?> inputFlashMap = RequestContextUtils.getInputFlashMap(req);
        if (inputFlashMap != null) {
            String msg = (String) inputFlashMap.get("msg");
            view.addAttribute("msg", msg);
        } else {
            view.addAttribute("msg", "");
        }
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
    public String saveTrainer(ModelMap view, @Valid Trainer trainer, BindingResult bindres) {
        view.addAttribute("newurl", newurl);
        view.addAttribute("listurl", listurl);
        if (bindres.hasErrors()) {
            view.addAttribute("error", error);
        } else {
            trainerService.save(trainer);
            String create = "Trainer " + trainer.getFirstname() + " " + trainer.getLastname() + " created successfuly!";
            view.addAttribute("msg", create);
        }
        return ("newtrainer");
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteTrainer(ModelMap view, @PathVariable int id, RedirectAttributes ra) {
        if (trainerService.delete(id)) {
            ra.addFlashAttribute("msg", "Trainer deletion successful");
            return ("redirect:/list");
        } else {
            ra.addFlashAttribute("msg", "Trainer deletion failed.");
            return ("redirect:/list");
        }
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String editTrainer(ModelMap view,
            @PathVariable int id
    ) {
        Trainer trainer = trainerService.findById(id);
        view.addAttribute("trainer", trainer);
        view.addAttribute("updateurl", updateurl);
        return ("edittrainer");
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String updateTrainer(ModelMap view, @Valid Trainer trainer, BindingResult bindres, RedirectAttributes ra) {
        if (bindres.hasErrors()) {
            view.addAttribute("error", error);
            return ("edittrainer");
        } else {
            trainerService.update(trainer);
            String update = "Trainer " + trainer.getFirstname() + " " + trainer.getLastname() + " updated successfuly!";
            ra.addFlashAttribute("msg2", update);
            return ("redirect:/list");
        }
    }
}
