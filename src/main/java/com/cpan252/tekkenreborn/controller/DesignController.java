package com.cpan252.tekkenreborn.controller;

import java.util.EnumSet;

import com.cpan252.tekkenreborn.model.Fighter;
import com.cpan252.tekkenreborn.model.Fighter.Anime;
import com.cpan252.tekkenreborn.model.FighterPool;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/design")
// this indicates that fighterPool has a lifetime of a session
@SessionAttributes("fighterPool")
public class DesignController {

    @GetMapping
    public String design() {
        return "design";
    }

    @ModelAttribute
    public void animes(Model model) {
        var animes = EnumSet.allOf(Anime.class);
        model.addAttribute("animes", animes);
        log.info("animes converted to string:  {}", animes);
    }

    @ModelAttribute(name = "fighterPool")
    public FighterPool fighterPool() {
        return new FighterPool();
    }

    @ModelAttribute
    public Fighter fighter() {
        return Fighter
                .builder()
                .build();
    }

    @PostMapping
    public String processFighterAddition(@Valid Fighter fighter,
            @ModelAttribute FighterPool pool, Errors errors) {
        if (errors.hasErrors()) {
            return "design";
        }
        pool.add(fighter);
        return "redirect:/design";
    }
}
