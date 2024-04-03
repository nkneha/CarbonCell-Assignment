package com.example.CarbonCellAssignment.dto;

import com.example.CarbonCellAssignment.model.ApiEntry;
import lombok.Data;

import java.util.List;

@Data
public class ApiResponse {
    private int count;
    private List<ApiEntry> entries;
}
