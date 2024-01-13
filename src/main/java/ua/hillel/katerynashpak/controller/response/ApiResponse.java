package ua.hillel.katerynashpak.controller.response;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@RequiredArgsConstructor
public class ApiResponse <D> {
    private boolean success;
    private D data;
    private List<String> messages;
}