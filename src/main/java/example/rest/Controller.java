package example.rest;

import example.api.MealDto;
import example.db.MealService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("${resource.path}")
public class Controller {

    private final MealService service;

    @GetMapping
    public MealDto get() {
        return service.find();
    }

    @GetMapping(path = "/{id}")
    public MealDto get(@PathVariable UUID id) {
        return service.findById(id);
    }

    @PostMapping
    public MealDto post(@RequestBody MealDto mealDto) {
        return service.create(mealDto);
    }
}
