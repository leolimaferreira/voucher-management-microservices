package com.vouchers.userservice.controller;

import com.vouchers.common.generic.GenericController;
import com.vouchers.userservice.dto.CreateUserDTO;
import com.vouchers.userservice.dto.UpdateUserDTO;
import com.vouchers.userservice.dto.UserSearchResultDTO;
import com.vouchers.userservice.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController implements GenericController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserSearchResultDTO> create(@RequestBody @Valid CreateUserDTO dto) {
        UserSearchResultDTO user = userService.create(dto);
        URI location = generateHeaderLocation(user.id());
        return ResponseEntity.created(location)
                .body(user);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserSearchResultDTO> findById(@PathVariable UUID id) {
        return ResponseEntity.ok(userService.findUserById(id));
    }

    @GetMapping
    public ResponseEntity<List<UserSearchResultDTO>> findAll() {
        return ResponseEntity.ok(userService.findAllUsers());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable UUID id, @RequestBody @Valid UpdateUserDTO dto) {
        userService.updateUser(id, dto);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
