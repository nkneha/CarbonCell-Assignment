package com.example.CarbonCellAssignment.service;

import com.example.CarbonCellAssignment.security.userDetails.CustomUserDetails;
import org.springframework.stereotype.Service;

@Service
public interface ITokenService {
    void buildTokenDetails(String token, CustomUserDetails userDetail);
}
