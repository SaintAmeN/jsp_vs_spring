package com.sda.javagda34.students.controller;

import com.sda.javagda34.students.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller // powoduje, że wewnątrz klasy mogą być (adresowalne) mappingi
public class IndexController {

    // posiada mappingi - adresy które po wywołaniu uruchamiają funkcję
//    @RequestMapping(params = "/", method = RequestMethod.GET)
    @GetMapping("/")
    public String getIndexPage(Model model, @RequestParam(name = "imie", required = false) String param) {
        // requestParam - ?nazwa=wartosc&nazwa2=wartoscInna
        // Model model - dopisujemy za każdym razem, kiedy będziemy chcieli "przesłać coś do widoku".
        // poniżej wysyłam wartość zmiennej param, pod aliasem "imie", które zostanie wyświeltone w thymeleaf.
        model.addAttribute("imie", param);

        return "index"; // String zwrócony to nazwa pliku html w katalogu templates
    }

    @GetMapping("/multable")
    public String tabliczkaMnozenia(Model model,
                                    @RequestParam(name = "x", required = false, defaultValue = "10") int rozmiarX,
                                    @RequestParam(name = "y", required = false, defaultValue = "10") int rozmiarY) {

        model.addAttribute("rozmiar_x", rozmiarX);
        model.addAttribute("rozmiar_y", rozmiarY);

        return "tabliczka_mnozenia";
    }

//    @PutMapping("/update/{id}")
//    public void update(@PathVariable(name = "id") Long id, @RequestBody Student student){
//
//    }
}
