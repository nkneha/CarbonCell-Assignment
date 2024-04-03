package com.example.CarbonCellAssignment.service;

import com.example.CarbonCellAssignment.model.ApiEntry;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface IAPIService {
    List<ApiEntry> fetchApis(String Category, Integer limit);
}
