package com.hospitality.SiHotel.controller;

import com.hospitality.SiHotel.dto.room.InsertRoomDTO;
import com.hospitality.SiHotel.dto.room.UpdateRoomDTO;
import com.hospitality.SiHotel.dto.roomService.InsertEmployeeDTO;
import com.hospitality.SiHotel.dto.roomService.UpdatEmployeeDTO;
import com.hospitality.SiHotel.dto.roomService.UpsertRosterDTO;
import com.hospitality.SiHotel.service.RoomServiceService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/room-service")
public class RoomServiceController {

    @Autowired
    RoomServiceService service;

    @GetMapping("/index")
    public String index(@RequestParam(defaultValue = "1") Integer page,
                        @RequestParam(required = false) String number,
                        @RequestParam(required = false) String name,
                        Model model){
        var table = service.getTable(number, name, page);
        model.addAttribute("table", table);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", table.getTotalPages());
        model.addAttribute("number", number);
        model.addAttribute("name", name);
        return "room-service/index";
    }

    @GetMapping("/form")
    public String form(@RequestParam(required = false) String number, Model model) {
        if (number != null) {
            var dto = service.findById(number);
            model.addAttribute("action", "update");
            model.addAttribute("dto", dto);

        } else {
            var dto = new InsertEmployeeDTO();
            model.addAttribute("action", "insert");
            model.addAttribute("dto", dto);
        }
        return "room-service/form";
    }


    @PostMapping("/insert")
    public String insert(@Valid @ModelAttribute("dto") InsertEmployeeDTO dto,
                         BindingResult bindingResult,
                         Model model){
        if (bindingResult.hasErrors()){
            model.addAttribute("action", "insert");
            return  "room-service/form";
        }
        service.save(dto);
        return "redirect:/room-service/index";
    }

    @PostMapping("/update")
    public String update(@Valid @ModelAttribute("dto") UpdatEmployeeDTO dto,
                         BindingResult bindingResult,
                         Model model){
        if (bindingResult.hasErrors()){
            model.addAttribute("action", "update");
            return  "room-service/form";
        }
        service.save(dto);
        return "redirect:/room-service/index";
    }

    @GetMapping("/roster")
    public String roster(@RequestParam(required = true) String number, Model model){
        var header = service.getHeader(number);
        var roster = service.getRoster(number);
        model.addAttribute("header", header);
        model.addAttribute("roster", roster);
        return "room-service/roster";
    }

    @GetMapping("/roster/form")
    public String rosterForm(@RequestParam(required = true) String number, Model model) {
        var dto = service.rosterById(number);
        model.addAttribute("action", "save");
        model.addAttribute("dto", dto);
        return "room-service/roster-form";
    }

    @PostMapping("/roster/save")
    public String update(@Valid @ModelAttribute("dto") UpsertRosterDTO dto,
                         BindingResult bindingResult,
                         Model model, RedirectAttributes redirectAttributes){
        if (bindingResult.hasErrors()){
            model.addAttribute("action", "save");
            return  "room-service/roster-form";
        }
        service.saveRoster(dto);
        redirectAttributes.addAttribute("number", dto.getEmployeeNumber());
        return "redirect:/room-service/roster";
    }

}
