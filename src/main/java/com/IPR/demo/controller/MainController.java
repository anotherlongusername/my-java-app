package com.IPR.demo.controller;

import com.IPR.demo.DTO.ReactiveDTO;
import com.IPR.demo.entity.Reactive;
import com.IPR.demo.repository.ReactiveRepo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Tag(name = "mainController") //для сваггера
@RestController
@RequiredArgsConstructor
public class MainController {

    @Autowired
    private ReactiveRepo reactiveRepo;
    private final ObjectMapper objectMapper;
    private static final Logger logger = LoggerFactory.getLogger(MainController.class);


    //ДОБАВЛЕНИЕ

    @Operation(
            summary = "добавляет новый реактив в БД",
            description = "распаковывает DTO, строит сущность реактива билдером и сохраняет в БД"

    ) //Описание реста в сваггере
    @PostMapping("api/add")
    public void addReactive(@RequestBody ReactiveDTO reactiveDTO) { //RequestBody - автоматическая десериализация json, вместо objectMappera
        logger.info("Log info: create " + reactiveRepo.save( //строим сущность реактива через билдер из полей ДТО и сохраняем в БД
                Reactive.builder()
                        .name(reactiveDTO.getName())
                        .articul(reactiveDTO.getArticul())
                        .vendor(reactiveDTO.getArticul())
                        .price(reactiveDTO.getPrice())
                        .count(reactiveDTO.getCount())
                        .build()));
    }


    //ПОИСК
    @Operation(
            summary = "отобразить все объекты из БД"
    )
    @SneakyThrows
    @GetMapping("api/getAll")
    public List<Reactive> getAll() {
        return reactiveRepo.findAll();
    }

    @Operation(
            summary = "отобразить реактив по айди из БД"
    )
    @GetMapping("api/getById")
    public Reactive getId(@RequestParam int id) {
        return reactiveRepo.findById(id).orElseThrow(); //orElseThrow() - optional на случай если по заданному id нет объекта
    }

    //УДАЛЕНИЕ
    @Operation(
            summary = "удалить реактив по айди из БД"
    )
    @DeleteMapping("api/delById")
    public void deleteById(@RequestParam int id) {
        reactiveRepo.deleteById(id);
    }

    @Operation(
            summary = "изменить реактив по айди из БД"
    )
    @PutMapping("api/changeReactive")
    public String changeReactive(@RequestBody Reactive reactive) { //RequestBody - автоматическая десериализация json, вместо objectMappera
        if (!reactiveRepo.existsById(reactive.getId())) {
            return "No such row";
        }
            return reactiveRepo.save(reactive).toString();

    }

}
