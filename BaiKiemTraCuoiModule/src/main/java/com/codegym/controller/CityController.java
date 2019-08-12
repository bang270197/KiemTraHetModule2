package com.codegym.controller;

import com.codegym.model.City;
import com.codegym.model.Nation;
import com.codegym.service.CityService;
import com.codegym.service.NationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CityController {
    @Autowired
    private CityService cityService;
    @Autowired
    private NationService nationService;
   @ModelAttribute("ListNation")
   public Iterable<Nation> nations(){
       return nationService.showAll();
   }
    @GetMapping("/")
    public ModelAndView showList(@PageableDefault(5) Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("city/list");
        modelAndView.addObject("city", cityService.showAll(pageable));
        return modelAndView;
    }

    @GetMapping("/show-create")
    public String showCreate(Model model) {
        model.addAttribute("city", new City());
        return "city/create";
    }
   @PostMapping("/create-city")
    public String createCity(@ModelAttribute City city,Model model){
       cityService.save(city);
       model.addAttribute("city",city);
       model.addAttribute("message","Them Thanh Cong");
       return "city/create";
   }

   @GetMapping("/show-edit/{id}")
    public String showEdit(@PathVariable Long id,Model model){
       City city=cityService.findById(id);
       model.addAttribute("city",city);
       return "city/edit";
   }
   @PostMapping("/edit-city")
    public String editCity(@ModelAttribute City city,Model model){
       cityService.save(city);
       model.addAttribute("city",city);
       model.addAttribute("message","Sua Thanh Cong");
       return "city/edit";
   }

   @GetMapping("/show-delete/{id}")
    public String showDelete(@PathVariable Long id,Model model){
       City city=cityService.findById(id);
       model.addAttribute("city",city);
       return "city/delete";
   }

   @PostMapping("/delete-city")
    public String deleteCity(@ModelAttribute City city,Model model){
       Long id=city.getId();
       cityService.delete(id);
       model.addAttribute("city",city);
       model.addAttribute("message","Xoa Thanh Cong");
       return "city/delete";
   }

   @GetMapping("/show-view/{id}")
    public String viewCity(@PathVariable Long id,Model model){
       City city=cityService.findById(id);
       model.addAttribute("city",city);
       return "city/view";
   }

}
