package idv.jk.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tours")
public class ToursController {

    @GetMapping("")
    public List<String> getAll() {
        return List.of("A", "B", "C");
    }


    @GetMapping("/{id}")
    public String getTour(@PathVariable String id) {
        return String.format("The id is %s", id);
    }
}
