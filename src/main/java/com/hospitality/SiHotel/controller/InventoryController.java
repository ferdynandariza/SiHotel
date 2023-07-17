package com.hospitality.SiHotel.controller;

import com.hospitality.SiHotel.dto.inventory.InsertInventoryDTO;
import com.hospitality.SiHotel.dto.inventory.UpdateInventoryDTO;
import com.hospitality.SiHotel.service.InventoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/inventory")
public class InventoryController {

    @Autowired
    InventoryService service;

    @GetMapping("/index")
    public String index(@RequestParam(defaultValue = "1") Integer page, Model model){
        var table = service.getTable(page);
        model.addAttribute("table", table);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", table.getTotalPages());
        return "inventory/index";
    }

    @GetMapping("/form")
    public String form(@RequestParam(required = false) String name, Model model) {
        if (name != null) {
            var dto = service.findById(name);
            model.addAttribute("action", "update");
            model.addAttribute("dto", dto);

        } else {
            var dto = new InsertInventoryDTO();
            model.addAttribute("action", "insert");
            model.addAttribute("dto", dto);
        }
        return "inventory/form";
    }

    @PostMapping("/insert")
    public String insert(@Valid @ModelAttribute("dto") InsertInventoryDTO dto,
                         BindingResult bindingResult,
                         Model model){
        if (bindingResult.hasErrors()){
            model.addAttribute("action", "insert");
            return  "inventory/form";
        }
        service.save(dto);
        return "redirect:/inventory/index";
    }

    @PostMapping("/update")
    public String update(@Valid @ModelAttribute("dto") UpdateInventoryDTO dto,
                         BindingResult bindingResult,
                         Model model){
        if (bindingResult.hasErrors()){
            model.addAttribute("action", "update");
            return  "inventory/form";
        }
        service.save(dto);
        return "redirect:/inventory/index";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam(required = true) String name, Model model){
        service.delete(name);
        return "redirect:/inventory/index";
//        var totalDependent = service.totalDependent(name);
//        if (true){
//        }
//        model.addAttribute("name", name);
//        model.addAttribute("totalDependent", totalDependent);
//        return "inventory/delete-error";
    }

}
