package com.hospitality.SiHotel.controller;

import com.hospitality.SiHotel.dto.room.InsertItemDTO;
import com.hospitality.SiHotel.dto.room.InsertRoomDTO;
import com.hospitality.SiHotel.dto.room.UpdateRoomDTO;
import com.hospitality.SiHotel.enumeration.RoomType;
import com.hospitality.SiHotel.service.RoomService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/room")
public class RoomController {

    @Autowired
    RoomService service;

    @GetMapping("/index")
    public String index(@RequestParam(defaultValue = "1") Integer page,
                        @RequestParam(required = false) String number,
                        @RequestParam(required = false) String type,
                        Model model){
        var table = service.getTable(number, type, page);
        model.addAttribute("table", table);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", table.getTotalPages());
        model.addAttribute("number", number);
        model.addAttribute("type", type);
        return "room/index";
    }

    @GetMapping("/form")
    public String form(@RequestParam(required = false) String number, Model model) {
        if (number != null) {
            var dto = service.findById(number);
            model.addAttribute("action", "update");
            model.addAttribute("dto", dto);

        } else {
            var dto = new InsertRoomDTO();
            model.addAttribute("action", "insert");
            model.addAttribute("dto", dto);
        }
        return "room/form";
    }

    @PostMapping("/insert")
    public String insert(@Valid @ModelAttribute("dto") InsertRoomDTO dto,
                         BindingResult bindingResult,
                         Model model){
        if (bindingResult.hasErrors()){
            model.addAttribute("action", "insert");
            return  "room/form";
        }
        service.save(dto);
        return "redirect:/room/index";
    }

    @PostMapping("/update")
    public String update(@Valid @ModelAttribute("dto") UpdateRoomDTO dto,
                         BindingResult bindingResult,
                         Model model){
        if (bindingResult.hasErrors()){
            model.addAttribute("action", "update");
            return  "room/form";
        }
        service.save(dto);
        return "redirect:/room/index";
    }

    @GetMapping("/item")
    public String item(@RequestParam(required = true) String number,
                       @RequestParam(defaultValue = "1") Integer page,
                       Model model){
        var header = service.getRoomHeader(number);
        var table = service.getTable(number, page);

        model.addAttribute("number", number);
        model.addAttribute("header", header);
        model.addAttribute("table", table);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", table.getTotalPages());

        return "room/item";
    }

    @GetMapping("/item/form")
    public String itemForm(@RequestParam(required = true) String number, Model model) {
        var dto = new InsertItemDTO();
        dto.setRoomNumber(number);
        model.addAttribute("dto", dto);
        model.addAttribute("inventoryDropdown", service.getInventoryDropdown());
        return "room/item-form";
    }

    @PostMapping("/item/insert-item")
    public String insertItem(@Valid @ModelAttribute("dto") InsertItemDTO dto,
                             BindingResult bindingResult,
                             Model model, RedirectAttributes redirectAttributes){
        if (bindingResult.hasErrors()){
            model.addAttribute("inventoryDropdown", service.getInventoryDropdown());
            return  "room/item-form";
        }
        service.save(dto);
        redirectAttributes.addAttribute("number", dto.getRoomNumber());
        return "redirect:/room/item";
    }

}
