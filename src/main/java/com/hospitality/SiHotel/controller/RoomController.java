package com.hospitality.SiHotel.controller;

import com.hospitality.SiHotel.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
        return "room/index";
    }
}
