package com.hospitality.SiHotel.controller;

import com.hospitality.SiHotel.dto.booking.ReservationDTO;
import com.hospitality.SiHotel.dto.room.InsertItemDTO;
import com.hospitality.SiHotel.service.BookingService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/booking")
public class BookingController {

    @Autowired
    BookingService service;

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
        return "booking/index";
    }

    @GetMapping("/detail")
    public String detail(@RequestParam(required = true) String number,
                       @RequestParam(defaultValue = "1") Integer page,
                       Model model) {
        var detail = service.getDetail(number);

        model.addAttribute("number", number);
        model.addAttribute("detail", detail);

        return "booking/detail";
    }

    @GetMapping("/reserve-form")
    public String reserveForm(@RequestParam(required = true) String room, Model model){
        var dto = new ReservationDTO();
        dto.setRoomNumber(room);
        dto.setGuestUsername("anonymous");
        var detail = service.getDetail(room);
        model.addAttribute("detail", detail);
        model.addAttribute("roomNumber", room);
        model.addAttribute("dto", dto);

        return "booking/reserve-form";
    }

    @PostMapping("/reserve")
    public String reserve(@Valid @ModelAttribute("dto") ReservationDTO dto,
                          BindingResult bindingResult,
                          Model model){
        if (bindingResult.hasErrors()){
//            model.addAttribute("inventoryDropdown", service.getInventoryDropdown());
            return "booking/reserve-form";
        }
        service.makeReservation(dto);
        return "redirect:/booking/index";
    }
}
