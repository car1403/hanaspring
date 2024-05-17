package com.hana.v1.item.controller;

import com.hana.common.dto.Response;
import com.hana.common.util.Helper;
import com.hana.v1.item.dto.request.ItemRequestDto;
import com.hana.v1.item.service.ItemService;
import io.swagger.v3.oas.annotations.Operation;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/v1/item")
@RestController
public class ItemController {

    private final ItemService itemService;
    private final Response response;
    @Operation(summary = "Item 등록", description = "아이템 이름과  <br> 금액을 입력 ")
    // GET 일때
    @Parameter(name = "name", description = "Item 이름 입력" )
    @Parameter(name = "price", description = "Item 가격 입력")
    @PostMapping("/add")
    public ResponseEntity<?> add(@Validated @RequestBody ItemRequestDto dto, Errors errors) {
        // validation check
        if (errors.hasErrors()) {
            return response.invalidFields(Helper.refineErrors(errors));
        }
        return itemService.save(dto);
    }
    @PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_MANAGER')")
    @GetMapping("/get")
    public ResponseEntity<?> get() {
        return itemService.getall();
    }
    @Parameter(name = "id", description = "Item ID 입력")
    @GetMapping("/get/{id}")
    public ResponseEntity<?> get(@RequestParam("id") Long id) {
        return itemService.get(id);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@RequestParam("id") Long id) {
        return itemService.delete(id);
    }
    @PatchMapping("/update")
    public ResponseEntity<?> update(@Validated @RequestBody ItemRequestDto dto, Errors errors) {
        if (errors.hasErrors()) {
            return response.invalidFields(Helper.refineErrors(errors));
        }
        return itemService.modify(dto);
    }

}
