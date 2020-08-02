package com.sda.javagda34.students.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
}
